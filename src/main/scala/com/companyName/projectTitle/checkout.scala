package com.companyName.projectTitle

object checkout {
  def cartAmount(cart: List[Menu]): Double = cart.foldLeft(0.0)((x, Menu) => x + Menu.MenuItemPrice)
}
