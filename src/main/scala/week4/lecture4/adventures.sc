import week4.lecture4.Adventure
import week4.lecture5.Future

import scala.collection.immutable.Queue

object adventures {
  val adventure: Adventure = Adventure()
  val coins: List[Coin] = adventure.collectCoins()
  val treasure: Treasure = adventure.buyTreasure(coins)

  val socket = Socket()
  val packet:Future[Array[Byte]] = socket.readFromMemory()
  packet.onComplete {
    case Success(p) => {
      val confirmation:Future[Array[Byte]] = socket.sendToEurope(p)
    }
    case Failure(t) => t
  }

  val memory = Queue[EmailMessage](
    EmailMessage(from = "Erik", to = "Ronald"),
    EmailMessage(from = "Martin", to = "Erik"),
    EmailMessage(from = "Roland", to = "Martin")
  )

  def readFromMemory():Future[Array[Byte]] = Future {
    val email = memory.dequeue()
    val serializer = serialization.findSerializerFor(email)
    serializer.toBinary(email)
  }
}