package de.nevercodealone.testing

import scala.collection.immutable.Seq

case class Person(id: String, name: String, yearOfBirth: Int)

trait DB {

  def store(entries: Seq[Person]): Seq[String]

  def get(id: String): Option[Person]

}
