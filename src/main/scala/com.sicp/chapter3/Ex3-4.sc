def makeAccount(initialBalance: Int, initialPassword: String): (String, String) => (Int) => Either[Int, String] = {
  var currentBalance = initialBalance
  var incorrectPasswordCount = 0
  val callTheCops = () => "Call the Cops!"
  (password, action) => {
    amount =>
      if (password == initialPassword) {
        action match {
          case "withdraw" => if (currentBalance < amount) {
            Right("Not sufficient funds!")
          } else {
            currentBalance -= amount
            Left(currentBalance)
          }
          case "deposit" =>
            currentBalance += amount
            Left(currentBalance)
          case _ => Right("Operation not supported.")
        }
      } else {
        incorrectPasswordCount match {
          case 7 =>
            incorrectPasswordCount = 0
            Right(callTheCops())
          case _ =>
            incorrectPasswordCount += 1
            Right("Password doesn't match")
        }
      }
  }


}

val acc = makeAccount(100, "LetMeIn")
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn!", "withdraw")(40)