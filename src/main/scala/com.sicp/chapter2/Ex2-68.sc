sealed trait Tree[+A] {
  def isLeaf(): Boolean

  def symbols: Seq[A]

  def weight: Int
}

case class Leaf[A](symbol: A, weight: Int) extends Tree[A] {
  override def isLeaf(): Boolean = false

  override def symbols: Seq[A] = Seq(symbol)
}

case class NonLeaf[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  override def isLeaf(): Boolean = false

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

val sampleBits = Seq[Int](0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0)

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

val sampleMessage = decode(sampleBits, sampleTree)

def encode[A](message: Seq[A], tree: Tree[A]): Seq[Int] = {
  def encodeSymbol(a: A, value: Tree[A]): Seq[Int] = {
    if (!tree.symbols.contains(a)) {
      return Seq.empty
    }
    value match {
      case NonLeaf(left, _) if left.symbols.contains(a) => Seq(0) ++ encodeSymbol(a, left)
      case NonLeaf(_, right) if right.symbols.contains(a) => Seq(1) ++ encodeSymbol(a, right)
      case Leaf(_, _) => Seq.empty
    }
  }

  message match {
    case Nil => Seq.empty
    case a :: rest => encodeSymbol(a, tree) ++ encode(rest, tree)
  }
}

val sampleBits2 = encode(sampleMessage, sampleTree)
sampleBits == sampleBits2




