def uniquePairs(n: Int) = {
  (1 to n) flatMap {
    i => (1 until i) map (j => (i, j))
  }
}

uniquePairs(10)


