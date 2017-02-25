object lecture2 {
  val n: Int = 5

  def isPrime(n: Int): Boolean = {
    2.until(n).forall(x => (n % x) != 0)
  }

  (1 until n) flatMap (i =>
    (1 until i) filter (j => isPrime(i + j)) map
      (j => (i, j)))


  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)


  isPrime(10)
}


