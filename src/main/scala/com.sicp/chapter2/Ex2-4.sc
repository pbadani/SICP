def pair(a: Int, b: Int): Int => Int = x => {
  require(x == 0 || x == 1, s"Invalid index $x")
  if (x == 0) a else b
}

val p = pair(2, 4)
p(0)
p(1)
p(2)
