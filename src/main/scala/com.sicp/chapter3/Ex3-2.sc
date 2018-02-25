def makeMonitored(f: Int => Int): Either[String, Int] => Int = {
  var counter = 0
  x =>
    x match {
      case Left("how-many-calls?") => counter
      case Left("reset-count?") =>
        counter = 0
        counter
      case Right(value) =>
        counter += 1
        f(value)
    }
}

val square = (x: Int) => x * x

val s = makeMonitored(square)

s(Left("how-many-calls?"))
s(Right(100))
s(Left("how-many-calls?"))