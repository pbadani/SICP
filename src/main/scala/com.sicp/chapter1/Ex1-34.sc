def f(g: Int => Int) = {
  g(2)
}

def square = (x: Int) => x * x

f(square)

f(z => z * (z + 1))

//function f() takes argument of type function (lambda)
//function g() takes argument of type Int.
//Hence invoking f() with argument f will result in type mismatch
//f(f)