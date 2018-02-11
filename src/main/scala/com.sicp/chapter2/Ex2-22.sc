def squareList(items: Int*): List[Int] = {
  def square(x: Int) = x * x

  //for easier append to the end of the list
  //reverse the original list, pre-pend the element
  //and then reverse the final list
  def appendToTheEndOfList(l: List[Int], element: Int): List[Int] = (element :: l.reverse).reverse

  def squareIter(accumulator: List[Int], items: Int*): List[Int] = {
    if (items.isEmpty)
      accumulator
    else {
      squareIter(appendToTheEndOfList(accumulator, square(items.head)), items.tail: _*)
    }
  }

  squareIter(List[Int](), items: _*)
}

squareList(1, 2, 3, 4)