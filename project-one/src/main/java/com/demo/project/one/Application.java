package com.demo.project.one;

import com.demo.project.one.service.DemoService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/project-one.xml");
        DemoService demoService = (DemoService)context.getBean("demoService");
        demoService.queryDb();
    }
}
