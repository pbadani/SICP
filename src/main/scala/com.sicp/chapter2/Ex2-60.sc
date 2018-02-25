sealed trait Set[+A] {
  def isEmpty() = this == Null

  def length(): Int
}

object Null extends Set[Nothing] {
  override def toString: String = "[]"

  override def length(): Int = 0
}

case class Cons[A](head: A, tail: Set[A]) extends Set[A] {
  private def values(l: Set[A]): Seq[A] = {
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

def elementOfSet[A](x: A, set: Set[A]): Boolean = {
  set match {
    case Null => false
    case Cons(h, t) => if (h == x) true else elementOfSet(x, t)
  }
}

def adjoinSet[A](x: A, set: Set[A]): Set[A] = Cons(x, set)

def intersectionSet[A](a: Set[A], b: Set[A]): Set[A] = {
  if (a.isEmpty() || b.isEmpty()) {
    Null
  } else {
    a match {
      case Cons(h, t) if elementOfSet(h, b) => Cons(h, intersectionSet(t, b))
      case Cons(_, t) => intersectionSet(t, b)
    }
  }
}

def unionSet[A](a: Set[A], b: Set[A]): Set[A] = {
  if (a.isEmpty()) {
    b
  } else if (b.isEmpty()) {
    a
  } else {
    a match {
      case Cons(h, t) => Cons(h, unionSet(t, b))
    }
  }
}

val a = Cons(1, Cons(2, Cons(3, Cons(4, Null))))
val b = Cons(1, Cons(4, Cons(6, Cons(8, Null))))

elementOfSet(3, a)
adjoinSet(5, a)
intersectionSet(a, b)
unionSet(a, b)

//The elementOfSet check is removed from adjoinSet and unionSet which is O(1) operation
