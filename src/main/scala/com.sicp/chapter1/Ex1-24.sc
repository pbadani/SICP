def expmod(base: Int, exp: Int, m: Int): Int = {
  if (exp == 0)
    1
  else if (isEven(exp))
    remainder(square(expmod(base, exp / 2, m)), m)
  else
    remainder(base * expmod(base, exp - 1, m), m)
}

def isEven(n: Int) = remainder(n, 2) == 0

def remainder(dividend: Int, divisor: Int) = dividend % divisor

def square(n: Int) = n * n

//TODO