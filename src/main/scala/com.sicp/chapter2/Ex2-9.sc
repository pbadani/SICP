class Interval(val lower: Double, val upper: Double) {
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

  def width(): Double = {
    upper - lower / 2.0
  }

  override def toString: String = s"[$lower to $upper]"
}

val a = new Interval(2, 4)
val b = new Interval(3, 6)

val sum = a + b
val mul = a * b
val div = a / b
val diff = a - b


val widthA = a.width()
val widthB = b.width()

sum.width()
diff.width()

mul.width()
div.width()

val c = new Interval(-1, 1)
a / c