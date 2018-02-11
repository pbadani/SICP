class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator for a rational number should not be zero.")

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val divisor = gcd(n, d)
  val numerator = n / divisor
  val denominator = d / divisor

  override def toString: String = s"$numerator / $denominator "
}

//new Rational(5, 0)

println(new Rational(5, 3))
println(new Rational(6, 3))

println(new Rational(5, -3))
println(new Rational(6, -3))

println(new Rational(-5, 3))
println(new Rational(-6, 3))

println(new Rational(-5, -3))
println(new Rational(-6, -3))
