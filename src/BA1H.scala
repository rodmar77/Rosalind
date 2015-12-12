object BA1H extends Rosalind {

  val (pattern, main, max) = ("ATTCTGGA", "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAATGCCTAGCGGCTTGTGGTTTCTCCTACGCTCC", 3)
  println(main
            .sliding(pattern.length)
            .zipWithIndex
            .map { case (text, index) => (hamming(text, pattern), index) }
            .toList
            .sortBy(_._1)
            .takeWhile(_._1 <= max)
            .map(_._2)
            .sorted
            .mkString(" "))
  
}