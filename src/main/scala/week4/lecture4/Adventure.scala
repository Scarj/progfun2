package week4.lecture4

trait Adventure {
  def collectCoins():List[Coin]
  def buyTreasure(coins:List[Coin]):Tresure
}
