def isOdd(n: Double): Boolean = {
  n % 2 == 1
}

def isEven(n: Double): Boolean = !isOdd(n)

def square(x: Double) = x * x


//This is the exponential process
def expRecursive(b: Double, n: Double): Double = {
  if (n == 1)
    b
  else if (isOdd(n))
    b * expRecursive(b, n - 1)
  else expRecursive(square(b), n / 2)
}

expRecursive(3, 100)

//In the iterative process, accumulator is the accumulator
def expIterative(b: Double, n: Double): Double = {

  def iter(accumulator: Double, base: Double, exponent: Double): Double = {
    if (exponent == 0)
      accumulator
    else if (isOdd(exponent)) {
      iter(accumulator * base, base, exponent - 1)
    } else {
      iter(accumulator, square(base), exponent / 2)
    }
  }

  iter(1, b, n)
}

expIterative(3, 100)

//The iterative process splits the problem into half every time
//Hence the runtime is O(logn)
//Try one more where we always split the problem size exponentially
//like n/2, n/4, n/8......
def exp(b: Double, n: Double): Double = {

  def calc(accumulator: Double, base: Double, exponent: Double, problemSize: Double): Double = {
    if (exponent == 0)
      accumulator
    else if (isOdd(exponent))
      calc(accumulator * b, base, exponent - 1, problemSize)
    else
      calc(accumulator, Math.pow(base, problemSize), n / problemSize, problemSize * 2)
  }

  calc(1, b, n, 2)
}

expIterative(3, 100)