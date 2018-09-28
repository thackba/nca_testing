package de.nevercodealone.testing

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop._

object FunctionsSpecification extends Properties("Functions") {

  property("add should form the sum of a and b") = forAll {
    (a: Int, b: Int) =>
      classify(a >= 0, "a pos", "a neg") {
        classify(b >= 0, "b pos", "b neg") {
          Functions.add(a, b) == a + b
        }
      }
  }

  property("add is commutative") = forAll(smallInteger, smallInteger) {
    (a: Int, b: Int) => Functions.add(a, b) == Functions.add(b, a)
  }

  val smallInteger: Gen[Int] = Gen.choose(0, 100)
}
