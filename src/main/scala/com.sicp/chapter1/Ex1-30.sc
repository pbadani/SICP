def sum(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
  def iter(a: Double, accumulator: Double): Double = {
    if (a > b)
      accumulator
    else iter(next(a), term(a) + accumulator)
  }

  iter(a, 0)
}

def identity(x: Double) = x

def inc(x: Double) = x + 1

sum(identity, 1, inc, 3)