def smallestDivisor(n: Int): Int = {
  def findDivisor(n: Int, testDivisor: Int): Int = {
    if (square(testDivisor) > n)
      n
    else if (divides(n, testDivisor))
      testDivisor
    else findDivisor(n, testDivisor + 1)
  }

  def square(n: Int) = n * n

  def divides(dividend: Int, divisor: Int) = {
    dividend % divisor == 0
  }

  findDivisor(n, 2)
}

def isPrime(n: Int): Boolean = smallestDivisor(n) == n

smallestDivisor(199)
smallestDivisor(1999)
smallestDivisor(19999)