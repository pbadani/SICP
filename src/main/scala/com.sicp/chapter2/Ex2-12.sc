case class Tolerance(value: Double)

class Interval(val lower: Double, val upper: Double) {

  //center and tolerance are double values and this parameter list can clash with the one defined with lower and upper bounds
  //Hence we represent Tolerance with a case class to 'differentiate' the two constructors
  def this(center: Double, tolerance: Tolerance) = {
    this(center - tolerance.value, center + tolerance.value)
  }

  def +(that: Interval): Interval = {
    new Interval(this.lower + that.lower, this.upper + that.upper)
  }

  def *(that: Interval): Interval = {
    val p = Seq(
      this.lower * that.lower,
      this.lower * that.upper,
      this.upper * that.lower,
      this.upper * that.upper
    )
    new Interval(p.min, p.max)
  }

  def /(that: Interval): Interval = {
    this * that.reciprocal()
  }

  def reciprocal(): Interval = {
    new Interval(1.0 / this.upper, 1.0 / this.lower)
  }

  def -(that: Interval): Interval = {
    new Interval(this.lower - that.upper, this.upper - that.lower)
  }

  override def toString: String = s"[$lower to $upper]"
}

val a = new Interval(2, 4)
val c = new Interval(4, Tolerance(2))

a + c
a * c
a / c
a - c