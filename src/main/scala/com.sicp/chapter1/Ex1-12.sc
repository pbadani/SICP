def pascalTriangle(levels: Int) = {

  def getElement(row: Int, col: Int): Int = {
    if (col == 1 || row == col)
      1
    else
      getElement(row - 1, col) + getElement(row - 1, col - 1)
  }

  def printLevel(current: Int): Unit = {
    if (current <= levels) {
      println((1 to current).map(column => getElement(current,column)).mkString(" "))
      printLevel(current + 1)
    }
  }

  printLevel(1)
}

pascalTriangle(10)
