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

def reverse[A](list: List[A]): List[A] = {
  list match {
    case Null => Null
    case Cons(h, t) => append(reverse(t), h)
  }
}

def append[A](list: List[A], element: A): List[A] = {
  list match {
    case Null => Cons(element, Null)
    case Cons(h, t) => Cons(h, append(t, element))
  }
}

val a = Cons(23, Cons(72, Cons(149, Cons(34, Null))))
reverse(a)
a.length()

//Another way to reverse using accumulators
def reverseWithAccumulator[A](list: List[A]): List[A] = {
  def iter(list: List[A], acc: List[A]): List[A] = {
    list match {
      case Null => acc
      case Cons(h, t) => iter(t, Cons(h, acc))
    }
  }
  iter(list, Null)
}


reverseWithAccumulator(a)