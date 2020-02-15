package com.ssy.chatroom.config;

import freemarker.template.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 监听器
 * 当中有两个方法：
 * contextInitialized():项目一启动就会调用这个方法(Tomcat帮忙调用)
 * contextDestroyed():项目终止的时候会调用这个方法(全局资源释放)
 */
//添加注解代表这个类具备了监听器的能力
@WebListener
public class FreeMarketListener implements ServletContextListener {
    public static final String TEMPLATE_KET = "_template_";

    //当项目启动时会将key="_template_",value=cfg;注册到整个项目中
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //配置FreeMarket的页面在哪个路径下
        //配置版本
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        //配置加载ftl的路径
        try {
            cfg.setDirectoryForTemplateLoading(
                    new File("G:\\程序\\chatroom_websocket\\src\\main\\webapp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //配置页面编码
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        //把整个配置写入上下文中 key-value
        sce.getServletContext().setAttribute(TEMPLATE_KET,cfg);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
