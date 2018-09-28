package de.nevercodealone.testing

import scala.collection.immutable.Seq

case class Article(articleNumber: String, price: Long)

trait Basket {

  def add(article: Article, times: Int): Unit

  def get: Seq[Article]

  def remove(articleNumber: String): Unit

  def size: Int

  def totalAmount: Long
}

