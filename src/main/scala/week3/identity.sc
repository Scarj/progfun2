import week3.BankAccount

object identity {

  val x: BankAccount = new BankAccount

  x.deposit(30)
  x.withdraw(20)

  val x1: BankAccount = new BankAccount
  val y1: BankAccount = new BankAccount
  x1.deposit(30)
  y1.withdraw(20)

}