package de.nevercodealone.testing.impl

import de.nevercodealone.testing.{CreditCard, Payment, PaymentService}

import scala.concurrent.Future

class SimplePaymentService extends PaymentService {
  override def pay(payment: Payment): Future[Unit] = {
    payment.cc match {
      case CreditCard.AmericanExpress if payment.amount >= 1000 =>
        Future.failed(new IllegalArgumentException("Amount to High"))
      case CreditCard.Visa if payment.amount <= 100 =>
        Future.failed(new IllegalArgumentException("Amount to Low"))
      case _ => Future.successful()
    }
  }
}
