package com.wushu.aopmessage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.wushu.aopmessage")
@EnableAspectJAutoProxy
public class AppConfig {
}
