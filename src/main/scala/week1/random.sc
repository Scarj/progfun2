import week1.Generator
import week1.Generator._

object random {

  val booleans2: Generator[Boolean] = for (x <- integers) yield x > 0

  val booleans3: Generator[Boolean] = integers map (x => x > 0)

  val pairsInt = new Generator[(Int, Int)] {
    override def generate: (Int, Int) = (integers.generate, integers.generate)
  }

  def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
    x <- t
    y <- u
  } yield (x, y)

  trees.generate

  def test[T](g: Generator[T], numTimes: Int = 100)
             (test: T => Boolean): Unit = {
    for(i<- 0.until(numTimes)) {
      val value = g.generate
      assert(test(value), "test failed for " + value)
    }
    println(s"passed $numTimes tests")
  }

  test(pairs(lists, lists)) {
    case (xs, ys) => (xs ++ ys).length >= xs.length
  }

}