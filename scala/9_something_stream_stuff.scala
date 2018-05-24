object Main {
  def natStream(): Stream[Int] = 1 #:: natStream.map(_+1)
  def catalanStream():Stream[Int] = natStream.map(cat(_))
  def smarandStream():Stream[Int] = natStream.map(isSma(_))
  def merseStream():Stream[Int] = natStream.map(powTwo(_)-1)
  def mersennePrimeStream():Stream[Int] = merseStream.filter(isMPrime(_))
  
  def cat(n: Int): Int = (fak(2*n)) / fak(n+1) * fak(n)
  def fak(n: Int): Int = n match  {
    case _ if (n<0) => 0
    case (n) if (n==0) => 1
    case _ => n * fak(n-1)
  }
  
  def isSma(n: Int): Int = natStream.filter(fak(_)%n == 0).head
  
  def powTwo(n: Int): Int = {
    if (n == 0) 1
    else 2*powTwo(n-1)
  }
  
  def isMPrime(n: Int): Boolean = (2 to math.sqrt(n).toInt).forall(n%_!=0)
  
  def main(args: Array[String]) {
     println("Catalan")
     catalanStream take 10 foreach println
     println()
     println("Smarand")
     smarandStream take 10 foreach println
     println()
     println("MersennePime")
     mersennePrimeStream take 10 foreach println
     println()
  }
}