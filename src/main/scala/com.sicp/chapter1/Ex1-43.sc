def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

def repeat(f: Int => Int, n: Int): Int => Int = {
  if (n == 0)
    (x: Int) => x
  else
    compose(f, repeat(f, n - 1))
}

def square = (x: Int) => x * x

repeat(square, 2)(5)