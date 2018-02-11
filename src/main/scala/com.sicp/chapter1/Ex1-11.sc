def fRecursive(n: Int): Int = {
  if (n < 3) n else fRecursive(n - 1) + 2 * fRecursive(n - 2) + 3 * fRecursive(n - 3)
}

fRecursive(10)

//TODO
//def fIterative(n: Int): Int = {
//  def fIter(a: Int, b: Int, c: Int, count: Int): Int = {
//    if (n < 0)
//      n
//    else if (n == 0)
//      a
//    else
//      fIter(b, c, 3 * a + 2 * b + c, count - 1)
//  }
//
//  fIter(0, 1, 2, n)
//}
//
//fIterative(10)