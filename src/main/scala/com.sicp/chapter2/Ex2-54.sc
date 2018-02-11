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

def equal[A](a: List[A], b: List[A]): Boolean = {
  a match {
    case Null => b match {
      case Null => true
      case _ => false
    }
    case SingleElement(e) => b match {
      case SingleElement(f) => e == f
      case _ => false
    }
    case Cons(h, t) => b match {
      case Cons(h2, t2) => equal(h, h2) && equal(t, t2)
      case _ => false
    }
  }
}