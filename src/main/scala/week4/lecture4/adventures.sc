import week4.lecture4.Adventure

object adventures {
  val adventure: Adventure = Adventure()
  val coins: List[Coin] = adventure.collectCoins()
  val treasure: Treasure = adventure.buyTreasure(coins)

  val socket = Socket()
  val pocket = socket.readFromMemory()
  val confirmation = socket.sendToEurope(packet)
}