def smallestDivisor(n: Int): Int = {

  def next(n: Int) = if (n == 2) 3 else n + 2

  def findDivisor(n: Int, testDivisor: Int): Int = {
    if (square(testDivisor) > n)
      n
    else if (divides(n, testDivisor))
      testDivisor
    else findDivisor(n, next(testDivisor))
  }

  def square(n: Int) = n * n

  def divides(dividend: Int, divisor: Int) = {
    dividend % divisor == 0
  }

  findDivisor(n, 2)
}

def timedPrimeTest(n: Int): Boolean = {
  //  println(n)
  startPrimeTest(n, System.nanoTime())
}

def startPrimeTest(n: Int, startTime: Long): Boolean = {
  if (isPrime(n)) {
    reportPrime(System.nanoTime() - startTime)
    return true
  }
  false
}

def isPrime(n: Int): Boolean = smallestDivisor(n) == n

def reportPrime(elapsedTime: Long) = {
  println("***")
  println(elapsedTime)
}


def searchForPrimes(start: Int, maxPrimes: Int): List[Int] = {

  def primesFrom(start: Int, maxPrimes: Int): List[Int] = {
    if (maxPrimes == 0) {
      List()
    } else if (timedPrimeTest(start)) {
      start :: primesFrom(start + 2, maxPrimes - 1)
    } else {
      primesFrom(start + 2, maxPrimes)
    }
  }

  primesFrom(if (isEven(start)) start + 1 else start, maxPrimes)
}

def isEven(n: Int): Boolean = n % 2 == 0

val base = 1000000

searchForPrimes(base, 3)
searchForPrimes(base * 10, 3)
searchForPrimes(base * 100, 3)
searchForPrimes(base * 1000, 3)

