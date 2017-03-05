package week3

import scala.annotation.tailrec

object lecture1 extends App{

  @tailrec
  def iterate(n:Int, f:Int=>Int, x:Int): Int = {
    if (n == 0) x else iterate(n - 1, f, f(x))
  }

  def square(x:Int): Int = x*x

  println(iterate(1, square, 3))

}
