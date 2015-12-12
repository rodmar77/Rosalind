import java.util.Scanner
import java.io._

object BA2C extends Rosalind {
  
  val in = new Scanner(new File("/tmp/input.txt"))
  val (text, size) = (in.next, in.nextInt)
  
  val matrix = "ACGT".flatMap(f => Range(0, size).map(p => (f, p) -> in.nextDouble)).toMap
  val probs = text
      .sliding(size)
      .map(kmer => (kmer, kmer
          .indices
          .map(i => matrix(
              (kmer(i), i)))
          .product))
      .toList
      .sortBy(_._2)
      .reverse
          
  println(probs
      .takeWhile(_._2 == probs.head._2)
      .sortBy(tuple => text.indexOf(tuple._1))
      .head
      ._1)
  
}