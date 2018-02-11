def product(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
  if (a > b)
    1
  else
    term(a) * product(term, next(a), next, b)
}

def identity(x: Double) = x

def increment(x: Double) = x + 1

def factorial(n: Double) = product(identity, 1, increment, n)

factorial(5)

def evenTerm(n: Double) = n + (n % 2)

def oddTerm(n: Double) = n + ((n + 1) % 2)

val (start, end) = (2, 150)

val numerator = product(evenTerm, start, increment, end)

val denominator = product(oddTerm, start, increment, end)

val pi = 4 * numerator / denominator


def productIterative(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
  def iter(a: Double, accumulator: Double): Double = {
    if (a > b)
      accumulator
    else
      iter(next(a), term(a) * accumulator)
  }

  iter(a, 1)
}

val numerator1 = productIterative(evenTerm, start, increment, end)

val denominator1 = productIterative(oddTerm, start, increment, end)

val pi1 = 4 * numerator1 / denominator1
