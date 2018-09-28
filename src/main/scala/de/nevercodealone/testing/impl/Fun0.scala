package de.nevercodealone.testing.impl

object Fun0 {

  def exec(a: String): Int = Option(a).map(_.length).getOrElse(0)

}
