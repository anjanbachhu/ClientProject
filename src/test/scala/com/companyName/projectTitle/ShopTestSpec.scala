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
  /*
  it should "pass when cart contain mix items" in {
    val totAmount = cartAmount(_MixItems)
    Utils.Common.bigDecimalFormatter(totAmount) shouldBe _MixItems_bill
  }
  */

  //only drinks
  it should "add 0% service charge when cart contain only drinks" in {
    val totAmount = cartAmount(_AllItemsDrinks)
    Utils.Common.bigDecimalFormatter(totAmount) shouldBe _AllItemsDrinksTotal
    println("calculated Amount :- " + totAmount + ", TestSpecAmount:- " + _AllItemsDrinksTotal)
  }

  //drinks and cold food
  it should "add 10% service charge when cart contain drinks and cold food" in {
    val totAmount = cartAmount(_DrinkAndFood_NoHot)
    Utils.Common.bigDecimalFormatter(totAmount) shouldBe _DrinkAndFood_NoHot_TotalWithService
    println("calculated Amount :- " + totAmount + ", TestSpecAmount:- " + _DrinkAndFood_NoHot_TotalWithService)
  }

  //drinks and hot food
  it should "add 20% service charge when cart contain drinks and hot food" in {
    val totAmount = cartAmount(_DrinkAndFood_Hot)
    Utils.Common.bigDecimalFormatter(totAmount) shouldBe _DrinkAndFood_Hot_TotalWithService
    println("calculated Amount :- " + totAmount + ", TestSpecAmount:- " + _DrinkAndFood_Hot_TotalWithService)
  }

  // maximum £20 as service charge
  it should "add maximum £20 as service charge" in {
    val totAmount = cartAmount(_100_SteakSandwichs)
    Utils.Common.bigDecimalFormatter(totAmount) shouldBe _100_SteakSandwichs_TotalWithService
    println("calculated Amount :- " + totAmount + ", TestSpecAmount:- " + _100_SteakSandwichs_TotalWithService)
  }
}


object ExcuteTests{

  val _MixItems = Cola :: Coffee :: CheeseSandwich :: Nil
  val _MixItems_bill = Utils.Common.bigDecimalFormatter(Cola.MenuItemPrice + Coffee.MenuItemPrice + CheeseSandwich.MenuItemPrice + SteakSandwich.MenuItemPrice)

  // Zero service charge
  val _AllItemsDrinks = Cola :: Cola :: Coffee :: Coffee :: Nil
  val _AllItemsDrinksTotal = Cola.MenuItemPrice + Cola.MenuItemPrice + Coffee.MenuItemPrice + Coffee.MenuItemPrice

  //10% Service charge
  val _DrinkAndFood_NoHot = Cola :: Cola :: CheeseSandwich :: Nil
  val _DrinkAndFood_NoHot_Total = Cola.MenuItemPrice + Cola.MenuItemPrice + CheeseSandwich.MenuItemPrice
  val _DrinkAndFood_NoHot_TotalWithService = _DrinkAndFood_NoHot_Total + (_DrinkAndFood_NoHot_Total * 0.10)

  // 20% service charge
  val _DrinkAndFood_Hot = Cola :: Cola :: CheeseSandwich :: SteakSandwich :: Nil
  val _DrinkAndFood_Hot_Total = Cola.MenuItemPrice + Cola.MenuItemPrice + CheeseSandwich.MenuItemPrice + SteakSandwich.MenuItemPrice
  val _DrinkAndFood_Hot_TotalWithService = _DrinkAndFood_Hot_Total + (_DrinkAndFood_Hot_Total * 0.20)

  // maximum £20 as service charge
  val _100_SteakSandwichs = List.fill(100)(SteakSandwich)
  val _100_SteakSandwichs_Total = SteakSandwich.MenuItemPrice * 100
  var _100_SteakSandwichs_ServiceCharge = _100_SteakSandwichs_Total * 0.20

  if (_100_SteakSandwichs_ServiceCharge >= 20) {
    _100_SteakSandwichs_ServiceCharge = 20
  }
  var _100_SteakSandwichs_TotalWithService = _100_SteakSandwichs_Total + _100_SteakSandwichs_ServiceCharge
}
