import java.util.Scanner
import java.io.File

object BA1A extends App {

  val in = new Scanner(new File("/tmp/input.txt"))  
  val (text, sub) = (in.nextLine, in.nextLine)
  println(text.sliding(sub.length).count(_.equals(sub)))
  
}