def pair(a: Double, b: Double): Double => Double = x => {
  require(a >= 0, "a should be non negative")
  require(b >= 0, "b should be non negative")

  val firstBase = 2
  val secondBase = 3
  val n = Math.pow(firstBase, a) * Math.pow(secondBase, b)

  require(x == 0 || x == 1, s"Invalid index $x")
  if (x == 0) {
    // We want to access the first number of the pair
    // Flush out the multiples of 3 in the final product
    val d = flushMultiplesOf(n, secondBase)

    // finally we are left with a number of the form 2 ^ a
    // To get the exponent a we perform log2(number)
    // log2(number) =  log10(number) / log10(2)
    logToTheBase(d, firstBase)
  } else {
    // We want to access the second number of the pair
    //Flush out the multiples of 2 in the final product
    val d = flushMultiplesOf(n, firstBase)

    // finally we are left with a number of the form 2 ^ a
    // To get the exponent a we perform log3(number)
    // log2(number) =  log10(number) / log10(3)
    logToTheBase(d, secondBase)
  }

  def logToTheBase(number: Double, base: Double) = Math.log10(number) / Math.log10(base)

  def flushMultiplesOf(number: Double, base: Double) = {
    var d = number
    while (d % base == 0)
      d = d / base
    d
  }
}

val p = pair(8, 15)
p(0)
p(1)
p(2)