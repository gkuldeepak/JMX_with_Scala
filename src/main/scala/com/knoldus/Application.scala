package com.knoldus

import com.knoldus.config.JMXConfig
import com.knoldus.services.ServiceImpl
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, Bean, Configuration, EnableMBeanExport}

object Application extends App {

  @Configuration
  @EnableMBeanExport
  class ManagedResourceConfig {
    @Bean(name = Array("ServiceImpl"))
    def serviceImpl(): ServiceImpl = {
      new ServiceImpl
    }
  }

  new AnnotationConfigApplicationContext(classOf[JMXConfig], classOf[ManagedResourceConfig])

}
