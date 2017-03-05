package week3.circuits

trait Simulation {
  def currentTime: Int
  def afterDelay(delay: Int)(block: => Unit): Unit
  def run(): Unit
}
