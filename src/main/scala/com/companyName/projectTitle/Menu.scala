package com.companyName.projectTitle

trait Menu {
  val MenuItemPrice: Double
}

object Cola extends Menu {
  val MenuItemPrice: Double = 0.50
}

object Coffee extends Menu {
  val MenuItemPrice: Double = 1.00
}

object CheeseSandwich extends Menu {
  val MenuItemPrice: Double = 2.00
}

object SteakSandwich extends Menu {
  val MenuItemPrice: Double = 4.50
}
