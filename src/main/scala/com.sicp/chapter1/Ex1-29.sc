def simpson(f: Double => Double, a: Double, b: Double, n: Double) = {
  val fixedN = if (isOdd(n)) n + 1 else n
  val h = (b - a) / fixedN

  def term(k: Double) = {
    val y = f(a + k * h)
    if (k == 0 || k == n)
      y
    else if (isOdd(k))
      4 * y
    else
      2 * y
  }

  def inc(k: Double) = k + 1

  sum(term, 0, inc, n) * h / 3
}

def sum(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
  if (a > b)
    0
  else
    term(a) + sum(term, next(a), next, b)
}

def isOdd(n: Double) = n % 2 == 1

def cube(n: Double) = n * n * n

simpson(cube, 0, 1, 100)
simpson(cube, 0, 1, 1000)

def integral(f: Double => Double, a: Double, b: Double, dx: Double) = {
  def addDx(x: Double) = x + dx

  sum(f, a + (dx / 2.0), addDx, b) * dx
}

integral(cube, 0, 1, 0.01)
integral(cube, 0, 1, 0.001)
