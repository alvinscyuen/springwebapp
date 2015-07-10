//package com.springapp.mvc.configjava;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.springapp.mvc")
//public class WebSpringConfig extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public ViewResolver configureViewResolver() {
//        InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
//        viewResolve.setPrefix("/WEB-INF/pages/");
////        viewResolve.setSuffix(".*");
//
//        return viewResolve;
//    }
//
//    @Override
//        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
//        configurer.enable();
//    }
//
//
//}
