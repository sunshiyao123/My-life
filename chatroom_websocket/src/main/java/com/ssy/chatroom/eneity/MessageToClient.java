package com.ssy.chatroom.eneity;

import java.util.Map;

/**
 * 后端发送给前端的信息实体
 */
public class MessageToClient {
    //聊天内容
    private String content;
    //服务端登陆的所有用户列表

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent(String username,String content) {
        this.content = username + "说：" + content;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    private Map<String,String> names;


}
