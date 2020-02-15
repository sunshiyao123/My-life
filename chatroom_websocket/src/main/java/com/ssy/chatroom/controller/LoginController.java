package com.ssy.chatroom.controller;


import com.ssy.chatroom.config.FreeMarketListener;
import com.ssy.chatroom.service.AccountService;
import com.ssy.chatroom.utils.CommUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final AccountService accountService = new AccountService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (CommUtils.strIsNull(username) || CommUtils.strIsNull(password)) {
            //登陆失败
            writer.println("<script>\n" +
                    "    alert(\"用户名或密码为空\");\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        }
        try {
            if (accountService.userLogin(username,password)) {
                //登陆成功，跳转到前端页面，加载chat.ftl
                Template template = getTemplate(req,"/chat.ftl");
                Map<String,String> map = new HashMap<>();
                map.put("username",username);
                try {
                    template.process(map,writer);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            } else {
                writer.println("<script>\n" +
                        "    alert(\"用户名或密码不正确\");\n" +
                        "    window.location.href = \"/index.html\";\n" +
                        "</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Template getTemplate(HttpServletRequest req,String fileName) {
        Configuration cfg = (Configuration) req.getServletContext().
                getAttribute(FreeMarketListener.TEMPLATE_KET);

        try {
            return cfg.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
