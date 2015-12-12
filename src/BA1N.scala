object BA1N extends App {
  
  def combWithDistance(s: String, d: Int) = {
    def getIncFor(curr: String, c: Char) = if (s(curr.length) == c) (0) else (1)
    def combWithDistance(curr: String, currDist: Int, acc: Set[String]): Set[String] = {
      if (currDist > d) (acc)
      else if (curr.length == s.length) (acc + curr)
      else "ACTG".foldRight(acc)((a, b) => {
        b ++ combWithDistance(curr + a, currDist + getIncFor(curr, a), acc)
      })
    }
    
    combWithDistance("", 0, Set[String]())
  }

  val (text, max) = ("GTTTTGGT", 3)
  println(combWithDistance(text, max).mkString("\n"))
}