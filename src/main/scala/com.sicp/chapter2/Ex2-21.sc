def squareList(items: Int*): List[Int] = {
  def square(x: Int) = x * x
  if (items.isEmpty)
    List[Int]()
  else
    square(items.head) :: squareList(items.tail: _*)
}

squareList(1, 2, 3, 4)