sealed trait Tree[+A] {
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

val sampleMessage = Seq[Int](0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0)


def decode[A](bits: Seq[Int], tree: Tree[A]): Seq[A] = {
  def decode1(bits: Seq[Int], currentBranch: Tree[A]): Seq[A] = {
    if (bits.isEmpty) {
      Seq.empty
    }
    currentBranch match {
      case Leaf(s, _) => Seq(s) ++ decode1(bits, tree)
      case NonLeaf(left, right) => bits match {
        case Nil => Seq.empty
        case 0 :: rest => decode1(rest, left)
        case 1 :: rest => decode1(rest, right)
      }
    }
  }

  decode1(bits, tree)
}

decode(sampleMessage, sampleTree)








