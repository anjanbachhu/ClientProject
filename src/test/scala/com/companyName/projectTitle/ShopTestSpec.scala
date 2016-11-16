package com.companyName.projectTitle

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class ShopTestSpec extends FlatSpec with Matchers with BeforeAndAfter {

  import checkout.cartAmount
  import ExcuteTests._

  //empty cart
  it should "return zero when the cart is empty" in {
    val totBill = cartAmount(List.empty[Menu])
    totBill shouldBe 0.0
  }

  //Cart contain mix items
  it should "pass when cart contain mix items" in {
    val totAmount = cartAmount(_MixItems)
    ExcuteTests.bigDecimalFormatter(totAmount) shouldBe _MixItems_bill
  }
}

object ExcuteTests{

  def bigDecimalFormatter(x: Double) = {
    BigDecimal(x).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  val _MixItems = Cola :: Coffee :: CheeseSandwich :: Nil
  val _MixItems_bill = bigDecimalFormatter(Cola.MenuItemPrice + Coffee.MenuItemPrice + CheeseSandwich.MenuItemPrice)
}