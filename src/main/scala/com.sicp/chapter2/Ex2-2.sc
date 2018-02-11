class Point(val x: Double, val y: Double) {
  override def toString: String = s"($x, $y)"

}

class Segment(val a: Point, val b: Point) {
  override def toString: String = s"$a ------- $b"

  def midpoint(): Point = new Point((a.x + b.x) / 2, (a.y + b.y) / 2)
}

val s = new Segment(new Point(2, 4), new Point(3, 6))
s.midpoint()

