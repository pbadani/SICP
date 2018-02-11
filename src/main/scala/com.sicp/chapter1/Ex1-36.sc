def fixedPoint(f: Double => Double, firstGuess: Double) = {
  def isCloseEnough(x: Double, y: Double): Boolean = Math.abs(x - y) < 0.0001

  def tryValue(guess: Double): Double = {
    val next = f(guess)
    println("***")
    println(next)
    if (isCloseEnough(guess, next))
      next
    else
      tryValue(next)
  }

  tryValue(firstGuess)
}

def sqrtFixedPoint(x: Double) = (y: Double) => (y + (x / y)) / 2

fixedPoint(sqrtFixedPoint(5), 1)

def f(x: Double) = Math.log(1000) / Math.log(x)

fixedPoint(f, 2)
