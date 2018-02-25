case class Cons[A](head: A, tail: Cons[A])

val a = Cons(23, Cons(72, Cons(149, Cons(34, null))))

def lastPair[A](list: Cons[A]): Cons[A] = {
  if (list.tail == null)
    list
  else
    lastPair(list.tail)
}

lastPair(a)