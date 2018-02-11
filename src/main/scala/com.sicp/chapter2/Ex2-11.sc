//TODO
// [+, +] * [+, +]
// [+, +] * [-, +]
// [+, +] * [-, -]
//
// [-, +] * [+, +]
// [-, +] * [-, +]
// [-, +] * [-, -]
//
// [-, -] * [+, +]
// [-, -] * [-, +]
// [-, -] * [-, -]


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
    require(!that.spansZero(), s"Interval $that spans zero. Cannot divide.")
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

  def spansZero(): Boolean = {
    this.lower <= 0 && this.upper >= 0
  }

  override def toString: String = s"[$lower to $upper]"
}

val a = new Interval(2, 4)
val b = new Interval(3, 6)
val c = new Interval(-1, 1)
a / c