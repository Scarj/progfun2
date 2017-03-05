package week3.circuits

import scala.annotation.tailrec

class AbstractSimulation extends Simulation {
  type Action = () => Unit
  case class Event(time: Int, action: Action)
  private type Agenda = List[Event]
  private var agenda: Agenda = List()
  private var curtime: Int = 0

  override def currentTime: Int = curtime

  override def afterDelay(delay: Int)(block: => Unit): Unit = {
    val event = Event(curtime + delay, () => block)
    agenda = insert(agenda, event)
  }

  def insert(ag: Agenda, event: Event): Agenda = ag match {
    case first :: tail if first.time <= event.time => first :: insert(tail, event)
    case _ => event :: ag
  }

  @tailrec
  private def loop(): Unit = agenda match {
    case first :: tail => {
      agenda = tail
      curtime = first.time
      first.action()
      loop()
    }
    case Nil =>
  }

  override def run(): Unit = {
    afterDelay(0) {
      println("*** simulation started, time = " + currentTime + " ***")
    }
    loop()
  }
}
