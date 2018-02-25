import scala.collection.mutable._

// TODO: Implement implicit ordering

sealed trait Tree[A <: Ordering[A]] {
  def symbols: Seq[A]

  def weight: Int
}

case class Leaf[A](symbol: A, weight: Int) extends Tree[A] {
  override def symbols: Seq[A] = Seq(symbol)
}

case class NonLeaf[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  override def symbols: Seq[A] = left.symbols ++ right.symbols

  override def weight: Int = left.weight + right.weight
}


def makeLeaf[A](symbol: A, weight: Int): Tree[A] = Leaf[A](symbol, weight)

def makeCodeTree[A](left: Tree[A], right: Tree[A]): Tree[A] = NonLeaf[A](left, right)

val sampleTree = makeCodeTree(
  makeLeaf('A', 4),
  makeCodeTree(
    makeLeaf('B', 2),
    makeCodeTree(
      makeLeaf('D', 1),
      makeLeaf('C', 1)
    )
  )
)
def makeLeafSet[A](list: List[(A, Int)]): PriorityQueue[Tree[A]] = {
  PriorityQueue[Tree[A]](list.map(tuple => makeLeaf(tuple._1, tuple._2)): _*)
}

def successiveMerge[A](p: PriorityQueue[Tree[A]]): Tree[A] = {
  require(p.nonEmpty)
  if (p.size == 1) {
    p.dequeue()
  } else {
    val first = p.dequeue()
    val second = p.dequeue()
    p.enqueue(makeCodeTree(first, second))
    successiveMerge(p)
  }
}

val tree = successiveMerge(
  makeLeafSet(
    List(
      ("A", 4),
      ("B", 2),
      ("C", 1),
      ("D", 1)
    )
  )
)