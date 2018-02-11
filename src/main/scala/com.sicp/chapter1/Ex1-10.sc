def a(x: Int, y: Int): Int = {
  if (y == 0) 0
  else if (x == 0) 2 * y
  else if (y == 1) 2
  else a(x - 1, a(x, y - 1))
}

a(1, 10)

a(2, 4)

a(3, 3)

def f(n: Int) = a(0, n)
def g(n: Int) = a(1, n)
def h(n: Int) = a(2, n)
def k(n: Int) = 5 * n * n

f(2)
f(3)
f(4)
//f computes 2 * n

g(2)
g(3)
g(4)
//g computes 2 ^ n

h(2)
h(3)
h(4)
//h computes ?
//TODO

k(2)
k(3)
k(4)
//k computes 5 * n * n
