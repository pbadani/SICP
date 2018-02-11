case class Tolerance(value: Double)

class Interval(val lower: Double, val upper: Double) {

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

def par1(r1: Interval, r2: Interval) = r1 * r2 / (r1 + r2)
def par2(r1: Interval, r2: Interval) = {
  val one = new Interval(1, 1)
  println(one / r1)
  println(one / r2)
  one / (one / r1 + one / r2)
}

val a = new Interval(2, 4)
val b = new Interval(3, 6)

par1(a, b)
par2(a, b)