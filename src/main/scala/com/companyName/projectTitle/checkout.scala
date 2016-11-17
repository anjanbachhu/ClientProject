package com.companyName.projectTitle

object checkout {
  def cartAmount(cart: List[Menu]): Double = {

    //calculate cart total
    val CartTotal = cart.foldLeft(0.0)((noOfItems, item) => noOfItems +  item.MenuItemPrice)

    //drinks
    val drinks = cart.groupBy(d => d.isItDrink).map(ds => (ds._1, ds._2.length))
    val drinksCount = drinks.getOrElse(true, 0)

    //hotfood
    val hotFood = cart.groupBy(h => h.isItHotFood).map(hf => (hf._1, hf._2.length))
    val hotFoodCount = hotFood.getOrElse(true, 0)

    //food
    val groupFoodItems = cart.groupBy(item => item.isItFood)
    val isThereAnyFoodinCart = groupFoodItems.getOrElse(true, 0)
    var foodCount = 0

    if (isThereAnyFoodinCart != 0) {
      foodCount = groupFoodItems(true).filter(fd => fd.isItHotFood == false).size
    }

    var serviceChargePercentage = 0

    if(hotFoodCount > 0){
      serviceChargePercentage = 20
    }
    else if(foodCount > 0){
      serviceChargePercentage = 10
    }
    else {
      serviceChargePercentage = 0
    }

    val cartTotalWithServiceCharge = CartTotal + CalculateServiceCharge(CartTotal, serviceChargePercentage)
    val FinalCartTotal = Utils.Common.bigDecimalFormatter(cartTotalWithServiceCharge)
    FinalCartTotal
  }

  /*
     Below function calculates the Service charge for cart total
   */
  def CalculateServiceCharge(CartTotal : Double, ServiceChargePercentage: Int): Double ={

    //get percentage fracton ie 0.2
    val PercentageFraction = getPercentageFraction(ServiceChargePercentage)

    // Multiply the service charge to cart total
    var TotalServiceCharge = CartTotal * PercentageFraction

    // Maximum service charge should be £20
    if(TotalServiceCharge >= 20)
    {
      TotalServiceCharge = 20
    }
    TotalServiceCharge
  }

  /*
  Below function returns the Percentage Fraction
  Ex :- if percentage = 20 then it will retun 0.2
        if percentage = 10 then it will retun 0.1
   */
  def getPercentageFraction(percentage : Int): Double ={
    val PercentageFraction =  percentage.toFloat / 100
    PercentageFraction
  }
}
