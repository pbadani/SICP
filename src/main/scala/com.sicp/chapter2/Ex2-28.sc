sealed trait List[+A] {
  def isEmpty(): Boolean
}

object List {
  def apply[A](elements: A*): List[A] = {
    if (elements.isEmpty) {
      Null
    } else {
      Cons(SingleElement(elements.head), apply(elements.tail: _*))
    }
  }
}

object Null extends List[Nothing] {
  override def isEmpty(): Boolean = true
}

case class SingleElement[A](e: A) extends List[A] {
  override def isEmpty(): Boolean = false
}

// Head now does not hold a single value but another Cons
case class Cons[A](head: List[A], tail: List[A]) extends List[A] {
  override def isEmpty(): Boolean = false
}

def fringe[A](x: List[A]): List[A] = {
  x match {
    case Null => Null
    case SingleElement(e) => List(e)
    case Cons(h, t) => Cons(fringe(h), fringe(t))
  }
}

fringe(List(List(1, 2), List(3, 4)))

//TODO implement toString for better representation