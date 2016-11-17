package com.companyName.projectTitle

trait Menu {
  val MenuItemPrice: Double
  val isItDrink : Boolean
  val isItFood : Boolean
  val isItHotFood : Boolean
}

object Cola extends Menu {
  val MenuItemPrice: Double = 0.50
  val isItDrink: Boolean = true
  val isItFood: Boolean = false
  val isItHotFood: Boolean = false
}

object Coffee extends Menu {
  val MenuItemPrice: Double = 1.00
  val isItDrink: Boolean = true
  val isItFood: Boolean = false
  val isItHotFood: Boolean = false

}

object CheeseSandwich extends Menu {
  val MenuItemPrice: Double = 2.00
  val isItDrink: Boolean = false
  val isItFood: Boolean = true
  val isItHotFood: Boolean = false

}

object SteakSandwich extends Menu {
  val MenuItemPrice: Double = 4.50
  val isItDrink: Boolean = false
  val isItFood: Boolean = true
  val isItHotFood: Boolean = true
}
