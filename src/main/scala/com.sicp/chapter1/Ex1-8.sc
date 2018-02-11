def cubeRtIter(guess: Double, x: Double): Double = {

  def goodEnough(guess: Double, x: Double): Boolean = {
    Math.abs(Math.pow(guess, 3) - x) < 0.001
  }

  def improve(guess: Double, x: Double): Double = {
    ((x / Math.pow(guess, 2)) + (2 * guess)) / 3
  }

  if (goodEnough(guess, x)) guess else cubeRtIter(improve(guess, x), x)
}

cubeRtIter(1, 5)