package de.nevercodealone.testing

import org.scalatest._

class FunctionsSpec extends WordSpec with Matchers {

  "Functions.add" should {

    "add two integers" in new Fixture(2, 4) {
      result shouldBe 6
    }
  }

  class Fixture(a: Int, b: Int) {
    // ...
    // preparation
    // ...
    val result: Int = Functions.add(a, b)
  }

}
