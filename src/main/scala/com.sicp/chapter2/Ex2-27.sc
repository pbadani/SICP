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

def deepReverse[A](list: List[A]): List[A] = {
  list match {
    case Null => Null
    case SingleElement(e) => SingleElement(e)
    case Cons(h, t) => Cons(deepReverse(t), deepReverse(h))
  }
}

val a = Cons(List(1, 2), List(3, 4))
deepReverse(a)

//TODO implement toString for better representation