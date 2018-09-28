package de.nevercodealone.testing

import scala.concurrent.Future

trait CreditCard {
  def provider: String
}

object CreditCard {

  object AmericanExpress extends CreditCard {
    val provider = "amex"
  }

  object MasterCard extends CreditCard {
    val provider = "mastercard"
  }

  object Visa extends CreditCard {
    val provider = "visa"
  }

}

case class Payment(amount: Long, cc: CreditCard)

trait PaymentService {

  def pay(payment: Payment): Future[Unit]

}
