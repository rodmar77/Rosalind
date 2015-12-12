import java.io.File

object BA1D extends App {

  val in = new java.util.Scanner(new File("/tmp/input.txt"))
  val (pattern, main) = (in.nextLine, in.nextLine)
  println(main.sliding(pattern.length).zipWithIndex.filter(_._1.equals(pattern)).map(_._2).mkString(" "))  
  
}