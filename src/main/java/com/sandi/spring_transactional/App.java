package com.sandi.spring_transactional;

import com.sandi.spring_transactional.config.ProductConfig;
import com.sandi.spring_transactional.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String...args){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        context.registerShutdownHook();
        ProductService service = context.getBean("productService", ProductService.class);
        service.saveProduct();
        context.close();
    }

}
