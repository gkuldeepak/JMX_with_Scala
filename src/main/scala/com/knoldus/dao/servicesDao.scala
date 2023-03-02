package com.knoldus.dao

trait ServiceDao {

  def ping: String

  def add(number1: Int, number2: Int): Int

  def verifyName(name: String): Boolean

}
