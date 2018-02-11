//First algorithm is recursive as it builds a series of deferred +1 operations which will be executed on the return of the terminating condition

def add1(a: Int, b: Int): Int = {
  if (a == 0) b else 1 + add1(a - 1, b)
}

add1(4, 5)

//Second algorithm is iterative as the entire state is explicitly captured in the variables.
def add2(a: Int, b: Int): Int = {
  if (a == 0) b else add2(a - 1, b + 1)
}

add2(4, 5)

