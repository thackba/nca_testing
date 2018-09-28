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
        basket.add(a)
        basket should have size 1
      })
    }
  }

  class Fixture {
    val basket = new SimpleBasket

    implicit def arbitrary[T](implicit generator: Gen[T]): Arbitrary[T] = Arbitrary(generator)

    implicit val articleGenerator: Gen[Article] = for {
      articleNumber <- Gen.alphaNumStr suchThat (s => s.nonEmpty)
      price <- Gen.choose(0, 10000L)
    } yield Article(articleNumber, price)
  }

}
