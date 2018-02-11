// Under normal-order evaluation rules,
// the interpreter fully expands a procedure
// before reducing it.

// Operand expressions are substituted for parameters
// until an expression involving only primitive operators is reached

// Under applicative-order rules,
// arguments are evaluated before operators are applied.
// This can often avoid multiple unnecessary evaluations of the same expression,
// which is one of the reasons why Lisp uses applicative-order evaluation.


var count = 0

def evaluateRemainder(a: Int, b: Int) = {
  count = count + 1
  a % b
}

def normalGCD(a: => Int, b: => Int): Int = {
  if (b == 0) a else normalGCD(b, evaluateRemainder(a, b))
}

def applicativeGCD(a: Int, b: Int): Int = {
  if (b == 0) a else applicativeGCD(b, evaluateRemainder(a, b))
}

count = 0
normalGCD(206, 40)
"Count in normal order: " + count

count = 0
applicativeGCD(206, 40)
"Count in applicative order: " + count