package de.nevercodealone.testing

import org.scalacheck.Gen
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class FunctionsPropertySpec extends WordSpec
  with GeneratorDrivenPropertyChecks
  with Matchers {

  "Functions.add" should {

    "add two integers" in {
      forAll { (a: Int, b: Int) =>
        Functions.add(a, b) shouldBe a + b
      }
    }

    "be commutative" in {
      forAll(intGenerator, intGenerator) { (a: Int, b: Int) =>
        Functions.add(a, b) shouldBe Functions.add(b, a)
      }
    }
  }

  val intGenerator: Gen[Int] = Gen.choose(-100, 100)
}
