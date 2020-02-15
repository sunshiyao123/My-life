package com.ssy.chatroom.service;

import com.ssy.chatroom.eneity.MessageFromClient;
import com.ssy.chatroom.eneity.MessageToClient;
import com.ssy.chatroom.utils.CommUtils;

import javax.servlet.Servlet;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

//将一个类标记为websocket终端，括号内值与前端websocket地址相同
@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有连接到后端的websocket的一个集合，为什么用静态的
    // (必须共享client，每打开一个页签则自动生成一个servlet实例)
    private static CopyOnWriteArraySet<WebSocket> clients =
            new CopyOnWriteArraySet<>();
    //缓存所有用户列表
    private static Map<String,String> names = new ConcurrentHashMap<>();


    //绑定当前websocket会话
    private Session session;
    //当前客户端的用户名
    private String userName;

    //当前端建立连接后调用此方法
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //获取地址中的传参：'ws://127.0.0.1:8080/websocket?username=' + '${username}'
        //获取到username = ${username}
        this.userName = session.getQueryString().split("=")[1];
        //将客户端聊天实体保存到clients
        clients.add(this);
        //将当前用户以及SessionId保存到用户列表
        names.put(session.getId(),userName);
        System.out.println("有新的连接："+userName+"上线了！");
        //发送给所有在线用户一个上线通知
        MessageToClient  messageToClient = new MessageToClient();
        messageToClient.setContent(userName+"上线了！");
        messageToClient.setNames(names);
        //发送信息
        String jsonStr = CommUtils.ObjectToJson(messageToClient);
        for (WebSocket webSocket : clients) {
            webSocket.sendMessage(jsonStr);
        }
    }

    @OnError
    public void onError(Throwable e) {
        System.err.println("WebSocket连接失败");
    }

    @OnMessage
    public void onMessage(String msg) {
        //将msg -> MessageFromClient
        MessageFromClient messageFromClient = (MessageFromClient)
                CommUtils.JsonToObject(msg,MessageFromClient.class);
        if (messageFromClient.getType().equals("1")) {
            //群聊信息
            //信息内容
            String content = messageFromClient.getMsg();
            MessageToClient messageToClient = new MessageToClient();
            messageToClient.setContent(content);
            messageToClient.setNames(names);

            //群聊信息广播
            for (WebSocket webSocket : clients) {
                webSocket.sendMessage(CommUtils.ObjectToJson(messageToClient));
            }
        } else if (messageFromClient.getType().equals("2")) {
            //私聊信息      {"to":"0-","msg":"33333","type":2}
            String content = messageFromClient.getMsg();
            //分解出的to信息：给谁发送信息
            String tos = messageFromClient.getTo();
            String[] to = tos.substring(0,tos.length()-1).split("-");
            List<String> list = Arrays.asList(to);
            //给指定的SessionId发送信息
            for (WebSocket webSocket : clients) {
                if (list.contains(webSocket.session.getId()) &&
                        this.session.getId() != webSocket.session.getId()) {
                    MessageToClient messageToClient = new MessageToClient();
                    messageToClient.setContent(webSocket.userName,content);
                    messageToClient.setNames(names);
                    webSocket.sendMessage(CommUtils.ObjectToJson(messageToClient));
                }
            }
        }
    }

    @OnClose
    public void onClose() {
        //将客户端聊天实体从clients移出
        clients.remove(this);
        //将当前用户以及SessionId从用户列表移出
        names.remove(session.getId());
        System.out.println(userName+"下线了！");
        //发送给所有在线用户一个下线通知
        MessageToClient messageToClient = new MessageToClient();
        messageToClient.setContent(userName+"下线了！");
        messageToClient.setNames(names);
        //发送信息
        String jsonStr = CommUtils.ObjectToJson(messageToClient);
        for (WebSocket webSocket : clients) {
            webSocket.sendMessage(jsonStr);
        }
    }


    //发送信息，群聊时将所有信息发送至每个session
    public void sendMessage(String msg) {
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
