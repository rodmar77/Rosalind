object BA1K extends Rosalind {
  
  val (text, k) = ("ACGCGGCTCTGAAA", 2)
  
  println(comb(k).sorted.map(kmer => text.sliding(k).filter(_.equals(kmer)).size).mkString(" "))
  
}