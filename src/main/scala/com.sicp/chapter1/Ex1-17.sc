def multiply(a: Int, b: Int): Int = {
  if (b == 0)
    0
  else
    a + multiply(a, b - 1)
}

multiply(10, 20)
multiply(10, 21)
multiply(10, 22)

def multiplyFast(a: Int, b: Int): Int = {
  if (b == 0)
    0
  else if (isOdd(b))
    a + multiplyFast(doubleValue(a), halveValue(b))
  else multiplyFast(doubleValue(a), halveValue(b))
}

multiplyFast(10, 20)
multiplyFast(10, 21)
multiplyFast(10, 22)

def isOdd(x: Int) = x % 2 == 1

def doubleValue(x: Int) = x * 2

def halveValue(x: Int) = x / 2