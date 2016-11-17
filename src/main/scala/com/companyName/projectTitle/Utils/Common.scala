package com.companyName.projectTitle.Utils

object Common {
  def bigDecimalFormatter(x: Double) = {
    BigDecimal(x).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}
