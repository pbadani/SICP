def multiply(a: Int, b: Int): Int = {
  def multiplyIter(accumulator: Int, a: Int, b: Int): Int = {
    if (b == 0)
      accumulator
    else if (isOdd(b))
      multiplyIter(accumulator + a, a, b - 1)
    else
      multiplyIter(accumulator, doubleValue(a), halveValue(b))
  }

  multiplyIter(0, a, b)
}

multiply(10, 20)
multiply(10, 21)
multiply(10, 22)

def isOdd(x: Int) = x % 2 == 1

def doubleValue(x: Int) = x * 2

def halveValue(x: Int) = x / 2