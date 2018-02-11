sealed trait Structure

case class Weight(number: Int) extends Structure

case class Mobile(left: Branch, right: Branch) extends Structure

case class Branch(length: Int, structure: Structure)

def totalWeight(mobile: Structure): Int = {
  mobile match {
    case Weight(e) => e
    case Mobile(left, right) => totalWeight(left.structure) + totalWeight(right.structure)
  }
}

def torque(branch: Branch): Int = {
  branch.length * totalWeight(branch.structure)
}

def isBalanced(mobile: Structure): Boolean = {
  mobile match {
    case Mobile(left, right) =>
      (torque(left) == torque(right)) &&
        isBalanced(left.structure) &&
        isBalanced(right.structure)
    //No branching, only a weight
    case _ => true
  }
}


