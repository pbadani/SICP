def p(): Int = p()

//x and y are both call by value
def applicativeTest(x: Int, y: Int) = if (x == 0) 0 else y

//Uncomment to see continuous loop to evaluate p
//applicativeTest(0, p())

//Here y is call by name
def normalTest(x: Int, y: => Int) = if (x == 0) 0 else y

normalTest(0, p())

//Another Example
def p1(): Int = {
  println("Inside p1")
  1
}

applicativeTest(0, p1())

normalTest(0, p1())
