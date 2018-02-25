sealed trait Tree[+A] {
  def isEmpty(): Boolean
}

object List {
  def apply[A](elements: A*): Tree[A] = {
    if (elements.isEmpty) {
      Null
    } else {
      Cons(Leaf(elements.head), apply(elements.tail: _*))
    }
  }
}

object Null extends Tree[Nothing] {
  override def isEmpty(): Boolean = true
}

case class Leaf[A](e: A) extends Tree[A] {
  override def isEmpty(): Boolean = false
}

// Head now does not hold a single value but another Cons
case class Cons[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  override def isEmpty(): Boolean = false
}

def squareTree(tree: Tree[Int]): Tree[Int] = map(tree, (x: Int) => x * x)

def map[A](tree: Tree[A], m: A => A): Tree[A] = {
  tree match {
    case Null => Null
    case Leaf(e) => Leaf(m(e))
    case Cons(h, t) => Cons(map(h, m), map(t, m))
  }
}