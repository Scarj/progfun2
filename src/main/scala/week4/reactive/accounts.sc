import week4.reactive.{BankAccount, Signal}

object accounts {
  def consolidated(accts: List[BankAccount]): Signal[Int] = {
    Signal(accts.map(_.balance()).sum)
  }

  val a = new BankAccount()
  val b = new BankAccount()
  val c = consolidated(List(a, b))
  c()
  a.deposit(20)
  b.deposit(30)
  c()

  val xchange = Signal(246.00)
  val inDollar = Signal(c()*xchange())
  inDollar()
  b.withdraw(10)
  inDollar()
}