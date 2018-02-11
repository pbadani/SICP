sealed trait List[+A] {
  def isEmpty() = this == Null

  def length():Int
}

object Null extends List[Nothing] {
  override def toString: String = "[]"

  override def length():Int = 0
}

case class Cons[A](head: A, tail: List[A]) extends List[A] {
  private def values(l: List[A]): Seq[A] = {
    l match {
      case Cons(h, t) => Seq(h) ++ Seq(values(t): _*)
      case _ => Seq.empty
    }
  }

  def length(): Int = values(this).length

  override def toString: String = {
    "[" + values(this).mkString(",") + "]"
  }
}

