List(1, 2, 3, 4) map (_ + 10) filter (_ % 2 == 0) map (_ * 3)

def pair(i: => Int) = {
  val j = i
  println("Hi")
  (j, j)
}

pair {
  println("inside")
  1 + 1
}

def pair2(i: => Int) = {
  lazy val j = i;
  (j, j)
}
pair2 {
  println("hi");
  1 + 41
}


(1 to 10) flatMap {
  i => (1 to i) map (x => (i, x))
}