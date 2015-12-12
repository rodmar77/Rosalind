object BA1J extends Rosalind {
  
  val (text, length, max) = ("ACGTTGCATGTCGCATGATGCATGAGAGCT", 4, 1)

  val combs = comb(length)
  println(
    text
      .sliding(length)
      .flatMap(sub => combs.map(comb => List[(String, Int)](
          (comb, hamming(sub, comb)), 
          (comb, hamming(sub, reverseComplement(comb))))))
      .flatten
      .filter(_._2 <= max)
      .toList
      .groupBy(_._1)
      .mapValues(_.size)
      .map(List[(String, Int)](_))
      .reduce((a, b) => {
         if (a.head._2 < b.head._2) b
         else if (a.head._2 > b.head._2) a
         else (a ++ b)
      })
      .map(_._1)
      .mkString(" "))
}