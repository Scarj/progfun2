package week1

import scala.collection.immutable.Nil
import scala.util.Random

trait Generator[+T] {
  self =>

  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }
}

object Generator {

  val integers: Generator[Int] = new Generator[Int] {
    val rand = new Random

    override def generate: Int = rand.nextInt()
  }

  val booleans = new Generator[Boolean] {
    override def generate: Boolean = integers.generate > 0
  }

  def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
    x <- t
    y <- u
  } yield (x, y)

  def single[T](x: T): Generator[T] = new Generator[T] {
    override def generate: T = x
  }

  def choose(lo: Int, hi: Int): Generator[Int] = {
    for (x <- integers) yield lo + x % (hi - lo)
  }

  def oneOf[T](xs: T*): Generator[T] = {
    for (idx <- choose(0, xs.length)) yield xs(idx)
  }

  def emptyLists: Generator[Nil.type] = single(Nil)

  def nonEmptyLists: Generator[List[Int]] = for {
    head <- integers
    tail <- lists
  } yield head :: tail

  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree
}