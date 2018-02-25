def makeAccount(initialBalance: Int, initialPassword: String): (String, String) => (Int) => Either[Int, String] = {
  var currentBalance = initialBalance
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
        Right("Password doesn't match")
      }
  }
}

val acc = makeAccount(100, "LetMeIn")
acc("LetMeIn!", "withdraw")(40)
acc("LetMeIn", "withdraw")(40)
acc("LetMeIn", "withdraw")(140)
acc("LetMeIn", "deposit")(140)