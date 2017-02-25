package week1

abstract class Tree
case class Inner(left: Tree, right: Tree) extends Tree
case class Leaf(num: Int) extends Tree