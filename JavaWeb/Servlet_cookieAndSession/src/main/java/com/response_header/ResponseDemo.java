package com.response_header;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * refresh:定时刷新/经过n秒后执行跳转
 *  应用场景：登陆注册 失败，提示"您登陆/注册失败"，经过3秒跳转到主页
 */
@WebServlet(name = "ResponseDemo")
public class ResponseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置一个响应头:refresh
        //设置每两秒刷新一次
        response.setHeader("refresh","2");

        //设置经过3秒跳转到指定的页面下
        response.setHeader("refresh","3;/adv.html");


        //解决乱码
        //Content-Type
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write("访问到了servlet");

        response.setHeader("Content-Type","text/html");
        //解决响应乱码
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("<html>+" +
                "<head><title>响应数据</title></head>"+
                "<body>访问到了servlet...</body>"+
                "</html>");
    }
}
