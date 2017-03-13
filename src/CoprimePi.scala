import scala.util.Random

/**
  * Approximate Pi using the a random number generator and the probability two numbers are coprime
  */
object CoprimePi {
  def main(args: Array[String]): Unit = {
    val calculated = calculatePi(new Random(), 100000)
    println(s"Calculated Pi to be $calculated")
    println(s"Percent Error is ${Math.abs(Math.PI - calculated) / Math.PI * 100}%")
  }

  def calculatePi(random: Random, iterations: Int = 1000): Double = {
    def calculatePiAccum(coprime: Int, count: Int): Double = {
      if (count == 0) return Math.sqrt(6 / (coprime / iterations.toDouble))

      val c = gcd(Math.abs(random.nextLong()), Math.abs(random.nextLong())) == 1
      calculatePiAccum(if (c) coprime + 1 else coprime, count - 1)
    }

    calculatePiAccum(0, iterations)
  }

  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)
}

