def proc(a: Int, b: Int, c: Int): Int = {
  val (max1, min1) = if (a > b) (a, b) else (b, a)
  val max2 = if (min1 > c) min1 else c
  sos(max1, max2)
}

def proc1(a: Int, b: Int, c: Int): Int = {
  if (a > b) {
    if (b > c) sos(a, b) else sos(a, c)
  } else {
    if (a > c) sos(a, b) else sos(b, c)
  }
}

def sos(x: Int, y: Int): Int = sq(x) + sq(y)

def sq(x: Int) = x * x

proc(1, 2, 3)
proc1(1, 2, 3)

proc(3, 2, 1)
proc1(3, 2, 1)

proc(1, 3, 2)
proc1(1, 3, 2)

proc(1, 2, -3)
proc1(1, 2, -3)

proc(1, -2, -3)
proc1(1, -2, -3)

proc(-1, -2, -3)
proc1(-1, -2, -3)