package com.knoldus.services

import com.knoldus.dao.ServiceDao
import org.springframework.jmx.`export`.annotation.{ManagedOperation, ManagedResource}

@ManagedResource(objectName = "com.knoldus.services:name=ServiceImpl")
class ServiceImpl extends ServiceDao{

  val list: List[String] = List("Knoldus", "Scala", "FE", "Devops", "QA")

  @ManagedOperation
  def ping: String = "pong"

  @ManagedOperation
  def add(number1: Int, number2: Int): Int =  number1 + number2

  @ManagedOperation
  def verifyName(name: String): Boolean = list.contains(name)

}
