def filteredAccumulate(combiner: (Double, Double) => Double, zeroValue: Double, term: Double => Double, a: Double, next: Double => Double, b: Double, filter: Double => Boolean): Double = {
  if (a > b)
    zeroValue
  else if (filter(a))
    combiner(term(a), filteredAccumulate(combiner, zeroValue, term, next(a), next, b, filter))
  else
    filteredAccumulate(combiner, zeroValue, term, next(a), next, b, filter)
}

def sumCombiner = (x: Double, y: Double) => x + y
val sumZeroValue = 0

def productCombiner = (x: Double, y: Double) => x * y
val productZeroValue = 1

def identity(x: Double) = x
def increment(x: Double) = x + 1
def square(x: Double) = x * x

def isPrime(x: Double): Boolean = !(2 to Math.sqrt(x).toInt).exists(x % _ == 0)
def gcd(x: Double, y: Double): Double = if (y == 0) x else gcd(y, x % y)
def prodPredicate(n: Double) = (x: Double) => x > 0 && x < n && gcd(n, x) == 1

filteredAccumulate(sumCombiner, sumZeroValue, square, 1, increment, 10, isPrime)
filteredAccumulate(productCombiner, productZeroValue, identity, 1, increment, 10, prodPredicate(10))
