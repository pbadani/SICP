//Calc fibonacci in logarithmic number of steps
//nth Fibonacci number can be calculated by applying
//n transformations to a column vector [1 0]
//The transformation matrix is
//T = 1 1
//    1 0

//T(p,q) = p+q  q
//         q    p

def fib(n: Int): Double = {
  def fibIter(a: Double, b: Double, p: Double, q: Double, count: Int): Double = {
    if (count == 0) {
      b
    } else if (isEven(count)) {
      //splits the problem size to half
      //hence O(log(n))
      val pNew = square(p) + square(q)
      val qNew = 2 * p * q + square(q)
      fibIter(a, b, pNew, qNew, count / 2)
    } else {
      val aTransformed = (p + q) * a + b * q
      val bTransformed = q * a + b * p
      fibIter(aTransformed, bTransformed, p, q, count - 1)
    }
  }

  fibIter(1, 0, 0, 1, n)
}

def isEven(n: Int): Boolean = {
  n % 2 == 0
}

def square(n: Double): Double = n * n

fib(10)