def findOrderedTripletsWithSumEqualTo(n: Int, sum: Int) = {
  (1 to n) flatMap {
    i => (i + 1 to n) flatMap {
      j => (j + 1 to n) map {
        k => (i, j, k)
      }
    }
  } filter {
    tuple => tuple._1 + tuple._2 + tuple._3 == sum
  }
}

findOrderedTripletsWithSumEqualTo(100, 10)