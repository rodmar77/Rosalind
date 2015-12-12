import java.io.File

object BA1B extends App {
  
  val in = new java.util.Scanner(new File("/tmp/input.txt"))
  val (main, size) = (in.nextLine, in.nextInt)
  
  val fullList = main
                  .sliding(size)
                  .toList
                  .groupBy(_.toString)
                  .mapValues(_.size)
                  .toList
                  .sortBy(_._2)
                  .reverse
                  
   println(fullList
             .takeWhile(_._2 == fullList.head._2)
             .map(_._1)
             .mkString(" "))
}