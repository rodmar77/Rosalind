import java.io.File

object BA1F extends App {
  
  val in = new java.util.Scanner(new File("/tmp/input.txt"))
  val differences = getDiffs(in.nextLine)

  println(differences
              .zipWithIndex
              .sortBy(_._1)
              .takeWhile(_._1 == differences.min)
              .map(_._2)
              .mkString(" "))
  
  def getDiffs(text: String): List[Int] = {
    val map = Map[Char, Int]('C'-> -1, 'G' -> 1).withDefaultValue(0)

    def getDiffs(sum: Int, digits: Seq[Int], acc: List[Int]): List[Int] = {
       if (digits.isEmpty) (acc)
       else (getDiffs(sum - digits.last, digits.init, (sum - digits.last) :: acc))
    }

    val digits = text.map(map)
    getDiffs(digits.sum, digits, List[Int]())
  }
}