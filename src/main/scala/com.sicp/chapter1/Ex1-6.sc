def sqrtIter(guess: Double, x: Double): Double = {

  def newIf(predicate: Boolean, consequent: Double, alternative: Double): Double = {
    predicate match {
      case true => consequent
      case false => alternative
    }
  }

  def goodEnough(guess: Double, x: Double): Boolean = {
    Math.abs(Math.pow(guess, 2) - x) < 0.001
  }

  def improve(guess: Double, x: Double): Double = {
    (guess + (x / guess)) / 2
  }

  newIf(goodEnough(guess, x), guess, sqrtIter(improve(guess, x), x))
}

// Since newIf evaluates all its parameters in
// applicative order (i.e, first evaluate values then apply)
// The recursive call to sqrtIter() is performed always,
// even at the truncating condition
// Resulting in infinite loop (StackOverflowError)


//Uncomment this to see the error.
//sqrtIter(1, 5)

//Better way to implement the newIf
def sqrtIter1(guess: Double, x: Double): Double = {

  //Here alternative is implemented as call by name i.e., it is evaluated only when needed.
  def newIf(predicate: Boolean, consequent: Double, alternative: => Double): Double = {
    predicate match {
      case true => consequent
      case false => alternative
    }
  }

  def goodEnough(guess: Double, x: Double): Boolean = {
    Math.abs(Math.pow(guess, 2) - x) < 0.001
  }

  def improve(guess: Double, x: Double): Double = {
    (guess + (x / guess)) / 2
  }

  newIf(goodEnough(guess, x), guess, sqrtIter1(improve(guess, x), x))
}

sqrtIter1(1, 5)