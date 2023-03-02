package com.knoldus.config

import org.springframework.context.annotation.{Bean, Configuration, DependsOn}
import org.springframework.jmx.support.{ConnectorServerFactoryBean, MBeanServerFactoryBean}
import org.springframework.remoting.rmi.RmiRegistryFactoryBean

@Configuration
class JMXConfig {

  @Bean
  def mBeanServerFactoryBean:MBeanServerFactoryBean = {
    new MBeanServerFactoryBean
  }

  @Bean
  def registry: RmiRegistryFactoryBean = {
    new RmiRegistryFactoryBean()
  }

  @Bean
  @DependsOn(Array("registry"))
  def connectorServer(): ConnectorServerFactoryBean = {
    val connectorServerFactoryBean = new ConnectorServerFactoryBean()
    connectorServerFactoryBean.setObjectName("connector:name=JMXConnectorServer")
    connectorServerFactoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/connector")
    connectorServerFactoryBean
  }

}
