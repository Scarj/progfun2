import scala.annotation.tailrec

object loops {

  def power(x: Double, exp: Int): Double = {
    var result = 1.0
    var i = exp
    while (i > 0) {
      result = result * x
      i = i - 1
    }
    result
  }

  def power2(x: Double, exp: Int): Double = {
    var result = 1.0
    var i = exp
    WHILE(i > 0) {
      result = result * x
      i = i - 1
    }
    result
  }

  def power3(x: Double, exp: Int): Double = {
    var result = 1.0
    var i = exp
    REPEAT {
      result = result * x
      i = i - 1
    }(i <= 0)
    result
  }

  def power4(x: Double, exp: Int): Double = {
    var result = 1.0
    var i = exp
    REPEAT {
      result = result * x
      i = i - 1
    } {UNTIL(i <= 0)}
    result
  }


  @tailrec
  def WHILE(condition: => Boolean)(command: => Unit): Unit = {
    if(condition) {
      command
      WHILE(condition)(command)
    }
  }

  @tailrec
  def REPEAT(command: => Unit)(condition: => Boolean): Unit = {
    command
    if(!condition) REPEAT(command)(condition)
  }

  def UNTIL(condition: => Boolean):Boolean = {
    condition
  }

  power4(2,3)
}