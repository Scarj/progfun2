package week4.lecture5

trait Observer[T] {
  def onNext(value: T): Unit
  def onError(error: Throwable): Unit
}