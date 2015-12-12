import java.io._
import java.util.Scanner

object BA1I extends Rosalind {
  
  val in = new Scanner(new File("/tmp/input.txt"))
  val (text, length, max) = (in.nextLine, in.nextInt, in.nextInt)

  val combs = comb(length)
  val items = text
                .sliding(length)
                .flatMap(sub => combs.map(comb => (comb, hamming(sub, comb))))
                .toList
                .sortBy(_._2)
                .takeWhile(_._2 <= max)
                .groupBy(_._1)
                .mapValues(_.map(_._1))
                .mapValues(f => f.distinct.map(kmer => (kmer, f.count(_.equals(kmer)))))
                .flatMap(_._2)
                .toList
                .sortBy(_._2)
                .reverse
                
  println(items
            .takeWhile(_._2 == items.head._2)
            .map(_._1)
            .mkString(" "))

}