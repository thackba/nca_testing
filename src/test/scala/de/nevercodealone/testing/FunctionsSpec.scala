package de.nevercodealone.testing

import de.nevercodealone.testing.{Entry => E}
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class FunctionsSpec extends WordSpec with Matchers with GeneratorDrivenPropertyChecks {

  "Functions.add" should {
    "add two integers" in new Fixture(2, 4) {
      result shouldBe 6
    }
    "add two integers 1" in new Fixture(0, 1) {
      result shouldBe 1
    }
    "add two integers 2" in new Fixture(0, 4) {
      result shouldBe 6
    }
    "add two integers 3" in new Fixture(4, 0) {
      result shouldBe 0
    }
    "add two integers 4" in new Fixture(0, 2) {
      result shouldBe 3
    }
    "add two integers 5" in new Fixture(0, 0) {
      result shouldBe 0
    }
    "add two integers 6" in new Fixture(3, 4) {
      result shouldBe 6
    }
    "add two integers 7" in new Fixture(3, 5) {
      result shouldBe 7
    }
  }

  "string to int convert"in {
    Functions.fun2(E(2, "foo")) shouldBe 5
  }

  "compute length of string"in {
    forAll { s: String =>
      Functions.fun0(s) shouldBe s.length
    }
  }

  "append first string behind second"in {
    forAll { (s: String, t: String) =>
      Functions.fun1(s, t) shouldBe t + s
    }
  }

  "feierabend" in new EntryFixture {
    forAll { e: E =>
      Functions.fun2(e) shouldBe e.a + e.b.length
    }
  }

  class Fixture(a: Int, b: Int) {
    // ...
    // preparation
    // ...
    val result: Int = Functions.add(a, b)
  }

  class EntryFixture {

    implicit def arbitrary[T](implicit generator: Gen[T]): Arbitrary[T] = Arbitrary(generator)

    implicit val entryGenerator: Gen[E] = for {
      b <- Gen.alphaNumStr suchThat (s => s.nonEmpty)
      a <- Gen.choose(0, 10000)
    } yield E(a, b)
  }


}
