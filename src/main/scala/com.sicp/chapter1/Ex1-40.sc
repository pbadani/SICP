def cubic(a: Int, b: Int, c: Int) = (x: Int) => {
  cube(x) + a * square(x) + b * x + c
}

def cube(x: Int) = x * x * x

def square(x: Int) = x * x