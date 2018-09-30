package de.nevercodealone.testing

import de.nevercodealone.testing.impl.SimpleBasket
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, Tag, WordSpec}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

// execute: sbt testOnly -- -n BasketTests ( -n: only tag / -l: exclude tag )
object BasketTests extends Tag("BasketTests")

class BasketSpec extends WordSpec with GeneratorDrivenPropertyChecks with Matchers with ScalaFutures {

  "Basket" should {
    "have a size of one if an article was add" taggedAs BasketTests in new Fixture {
      forAll((a: Article) => {
        val basket = new SimpleBasket
        basket.add(a)
        basket should have size 1
      })
    }

    "no items results in size 0" in new Fixture {
      val basket = new SimpleBasket
      basket should have size 0
    }

    "one item results in 1" in new Fixture {
      val basket = new SimpleBasket
      private val article = Article("v9jdtisnndkzldmlhievzl3mqHh0e", 5)
      basket.add(article)

      basket should have size 1
      basket.get.head.price shouldBe article.price % 5
    }


  }

  class Fixture {

    implicit def arbitrary[T](implicit generator: Gen[T]): Arbitrary[T] = Arbitrary(generator)

    implicit val articleGenerator: Gen[Article] = for {
      articleNumber <- Gen.alphaNumStr suchThat (s => s.nonEmpty)
      price <- Gen.choose(0, 10000L)
    } yield Article(articleNumber, price)
  }

}
