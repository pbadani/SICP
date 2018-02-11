def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

def square = (x: Int) => x * x
def inc = (x: Int) => x + 1

compose(square, inc)(6)