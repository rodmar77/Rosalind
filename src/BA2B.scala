import java.util.Scanner
import java.io._

object BA2B extends Rosalind {
  implicit def iterableWithAvg[T:Numeric](data:Iterable[T]) = new {
    def average[T]( ts: Iterable[T] )( implicit num: Numeric[T] ) = {
      num.toDouble( ts.sum ) / ts.size
    }

    def avg = average(data)
  }
  
  val in = new Scanner(new File("/tmp/input.txt"))  
  val (size, kmers) = (in.nextInt, getKmers(in))
    
  val motifs = comb(size)
                .flatMap(motif => kmers
                    .map(kmer => (motif, kmer
                      .sliding(size)
                      .map(hamming(motif, _)))))
                .groupBy(_._1)
                .mapValues(_.map(_._2.min).avg)
                .toList
                .sortBy(_._2)

  println(motifs
              .takeWhile(_._2 == motifs.head._2)
              .map(_._1)
              .mkString(" "))
}