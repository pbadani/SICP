def forEach(f: Int => Unit, items: Int*): Unit = {
  if (items.nonEmpty) {
    f(items.head)
    forEach(f, items.tail: _*)
  }
}

forEach(println(_), 1, 2, 3, 4)