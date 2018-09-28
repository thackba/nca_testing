package de.nevercodealone.testing

import de.nevercodealone.testing.impl._

case class Entry(a: Int, b: String)

object Functions extends {

  def add(a: Int, b: Int): Int = Add.exec(a, b)

  def fun0(a: String): Int = Fun0.exec(a)

  def fun1(a: String, b: String): String = Fun1.exec(a, b)

  def fun2(a: Entry): Int = Fun2.exec(a)

  def fun3(a: Entry, b: Entry): String = Fun3.exec(a, b)
}
