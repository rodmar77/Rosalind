import java.util.Scanner

class Rosalind extends App {
  
  def hamming(a: String, b: String) = a.indices.count(n => (a(n) != b(n)))

  def comb(l: Int)=("ACTG" * l).combinations(l).flatMap(_.mkString.permutations.toList).toList
  
  def reverseComplement(a: String) = {
    val inverse = Map[Char, Char]('A' -> 'T', 'T' -> 'A', 'C' -> 'G', 'G' -> 'C')
    a.map(inverse).reverse
  }
  
  def patternToNumber(pattern: String): BigInt = {
	  if (pattern.isEmpty) 0
	  else 4*patternToNumber(pattern.init) + symbolToNumber(pattern.last)
  }

  def numberToPattern(index: Int, k: Int): String = {
	  if (k == 1) (numberToSymbol(index))
	  else numberToPattern(index / 4, k-1) + numberToSymbol(index % 4)  
  }
  
  def numberToSymbol(symbol: Int) = {
    symbol match {
      case 0 => "A"
      case 1 => "C"
      case 2 => "G"
      case default => "T"
    }
  }

  def symbolToNumber(symbol: Char) = {
    symbol match {
      case 'A' => 0
      case 'C' => 1
      case 'G' => 2
      case default => 3
    }
  }
  
  
  def getKmers(in: Scanner) = {
    def getKmers(acc: List[String]): List[String] = {
       if (in.hasNext) (getKmers(acc :+ in.next))
       else (acc)
    }
    
    getKmers(List[String]())
  }
}