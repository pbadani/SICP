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

//def isPrime(value: Int): Boolean = (2 to Math.sqrt(value).toInt).forall(value % _ != 0)
def isPrimeFast(value: Int): Boolean = !(2 to Math.sqrt(value).toInt).exists(value % _ == 0)

def reportPrime(elapsedTime: Long) = {
  println("***")
  println(elapsedTime)
}

isPrime(2)
isPrimeFast(2)

isPrime(3)
isPrimeFast(3)

isPrime(4)
isPrimeFast(4)

isPrime(5)
isPrimeFast(5)

isPrime(6)
isPrimeFast(6)

isPrime(7)
isPrimeFast(7)


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

val base = 1000000

searchForPrimes(base, 3)
searchForPrimes(base * 10, 3)
searchForPrimes(base * 100, 3)
searchForPrimes(base * 1000, 3)

