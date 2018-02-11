class Point(val x: Double, val y: Double) {
  override def toString: String = s"($x, $y)"

  def distance(another: Point) = Math.sqrt(Math.pow(this.x - another.x, 2) + Math.pow(this.y - another.y, 2))
}

class Segment(val a: Point, val b: Point) {
  override def toString: String = s"$a ------- $b"

  def midpoint(): Point = new Point((a.x + b.x) / 2, (a.y + b.y) / 2)
}

class Rectangle(val upperLeft: Point, val lowerRight: Point) {
  val upperRight = new Point(lowerRight.x, upperLeft.y)
  val lowerLeft = new Point(upperLeft.x, lowerRight.y)

  private val length = upperLeft.distance(upperRight)
  private val breadth = upperLeft.distance(lowerLeft)

  def perimeter() = 2 * (length + breadth)

  def area() = length * breadth
}

val r = new Rectangle(new Point(1, 4), new Point(3, 2))
r.perimeter()
r.area()