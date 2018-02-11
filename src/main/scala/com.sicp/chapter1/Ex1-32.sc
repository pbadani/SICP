def accumulate(combiner: (Double, Double) => Double, zeroValue: Double, term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
  if (a > b)
    zeroValue
  else
    combiner(term(a), accumulate(combiner, zeroValue, term, next(a), next, b))
}

def sumCombiner = (x: Double, y: Double) => x + y
val sumZeroValue = 0

def productCombiner = (x: Double, y: Double) => x * y
val productZeroValue = 1

def identity(x: Double) = x
def increment(x: Double) = x + 1

accumulate(sumCombiner, sumZeroValue, identity, 1, increment, 10)
accumulate(productCombiner, productZeroValue, identity, 1, increment, 10)
