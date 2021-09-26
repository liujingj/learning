package com.ljj.malllearning;


import com.ljj.malllearning.springboot.Server;
import com.ljj.malllearning.springboot.annotation.EnableHelloWorld;
import com.ljj.malllearning.springboot.annotation.EnableServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableServer(type = Server.Type.HTTP)
public class EnableServerBootstrap {

    public void main(String[] args) {
        //构建Annotation配置驱动Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前引导类到spring上下文
        context.register(EnableServerBootstrap.class);
        //启动上下文
        context.refresh();
        Server server = context.getBean( Server.class);
        server.start();
        server.stop();

    }
}


