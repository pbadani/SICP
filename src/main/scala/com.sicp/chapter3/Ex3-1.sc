def makeAccumulator(initialValue: Int): Int => Int = {
  var currentValue = initialValue
  x => {
    currentValue += x
    currentValue
  }
}

val a = makeAccumulator(5)
a(10)
a(10)

val b = makeAccumulator(15)
b(10)
b(10)