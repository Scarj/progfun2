package week4.lecture4

import week4.lecture5.Future

trait Socket {
  def readFromMemory(): Future[Array[Byte]]
  def sendToEurope(packet: Array[Byte]): Future[Array[Byte]]
}
