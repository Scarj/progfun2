package week4.lecture5

import scala.concurrent.ExecutionContext

trait Future[T] {
  def onComplete(success: T => Unit, failed: Throwable => Unit): Unit

  def onComplete(callback: Observer[T] => Unit)
}

object Future {
  def apply(body: => T)(implicit context: ExecutionContext): Future[T]
}