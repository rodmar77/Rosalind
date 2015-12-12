import java.util.Scanner
import java.io._

object BA2A extends Rosalind {
  
  val in = new Scanner(new File("/tmp/input.txt"))  
  val (length, diff, kmers) = (in.nextInt, in.nextInt, getKmers(in))
  val motifs = comb(length)
                
  println(kmers
            .flatMap(kmer => motifs
                                .map(motif => (kmer, motif, kmer
                                                              .sliding(length)
                                                              .map(hamming(_, motif))
                                                              .filter(_ <= diff))))
            .groupBy(_._2)
            .mapValues(_
                .map(n => (n._1, n._3.size))
                .filter(_._2 > 0)
                .size)
            .filter(_._2 == kmers.size)
            .map(_._1)
            .toList
            .sorted
            .mkString(" "))
  
}