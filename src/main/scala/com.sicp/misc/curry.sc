def curry[A, B, C](f: (A, B) => C): A => B => C = (a: A) => (b: B) => f(a, b)

curry[Int, Int, Int]((a: Int, b: Int) => a + b)(1)(2)
curry[Int, Int, Int](_ + _)(1)(2)


def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)