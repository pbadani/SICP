sealed trait Stream[+A]

object Null extends Stream[Nothing] {
  override def toString: String = "[]"
}

//tail is the thunk to simulate lazy evaluation
case class Cons[A](head: A, tail: () => Stream[A]) extends Stream[A] {
  private def values(l: Stream[A]): Seq[A] = {
    l match {
      case Cons(h, t) => Seq(h) ++ Seq(values(t()): _*)
      case _ => Seq.empty
    }
  }

  override def toString: String = {
    "[" + values(this).mkString(",") + "]"
  }
}

def enumerate(low: Int, high: Int): Stream[Int] = {
  if (low > high) {
    Null
  } else {
    Cons(low, () => enumerate(low + 1, high))
  }
}

def filter[A](s: () => Stream[A], predicate: A => Boolean): () => Stream[A] = {
  () =>
    s() match {
      case Null => Null
      case Cons(h, t) if predicate(h) => Cons(h, filter(() => t(), predicate))
      case Cons(_, t) => filter(t, predicate)()
    }
}

def sieve(s: Stream[Int]): Stream[Int] = {
  s match {
    case Null => Null
    case Cons(h, t) => Cons(h, filter(() => t(), (x: Int) => (x % h) != 0))
  }
}

sieve(enumerate(2, 1000))

val a = filter(() => enumerate(2, 1000), (x: Int) => true)
a()

