package de.nevercodealone.testing.impl

import de.nevercodealone.testing.{Article, Basket}

import scala.collection.immutable.Seq
import scala.util.Random

class SimpleBasket extends Basket {

  private var sequenceOfArticle = Seq.empty[Article]

  override def add(article: Article, times: Int = 1): Unit = {
    val changedTimes = times match {
      case t: Int if t % 3 == 0 => t / 3
      case _ => times
    }
    val changedArticle = article match {
      case a: Article if a.price % 5 == 0 => Article(a.articleNumber, Random.nextInt(a.price.toInt).toLong)
      case _ => article
    }
    if (article.price >= 0 && times > 0)
      sequenceOfArticle = sequenceOfArticle ++ 1.to(changedTimes).map(_ => changedArticle)
  }

  override def get: Seq[Article] =
    sequenceOfArticle

  override def remove(articleNumber: String): Unit =
    sequenceOfArticle = sequenceOfArticle.filter(a => a.articleNumber != articleNumber)

  override def size: Int =
    sequenceOfArticle.size

  override def totalAmount: Long =
    sequenceOfArticle.map(a => a.price).sum

  override def toString: String = s"$sequenceOfArticle"
}
