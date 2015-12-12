import java.util.Scanner
import java.io._

object BA2D extends Rosalind {
  
   val in = new Scanner(new File("/tmp/input.txt"))
   val (k, t) = (in.nextInt, in.nextInt)
   val dna = (1 to t).map(n => in.next)
   
   println(greedyMotifSearch)
   
   def greedyMotifSearch= {
       def matrix(xs: Seq[String]) = {
           val ocurrences = xs
                             .flatMap(_.zipWithIndex)
                             .groupBy(_._1)
                             .mapValues(list => list
                                 .groupBy(_._2)
                                 .mapValues(_.size))
           
           def perc(codon: Char, index: Int) = {
               if (ocurrences.contains(codon)) (
                   ocurrences(codon).getOrElse(index, 0) / 
                   ocurrences
                     .values
                     .flatMap(_.toList)
                     .filter(_._1 == index)
                     .map(_._2)
                     .sum
                     .toDouble)

               else 0d
           }

           "ACGT".map(c => Range(0, k).map(i => perc(c, i)))
       }
       
       def greedyMotifSearch(index: Int, bestMotifs: Seq[String]) = {
         
       }
       
       matrix(dna)
   }
}