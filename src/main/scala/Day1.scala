import scala.io.BufferedSource

class Day1 {

  def getEntries(reportFile: BufferedSource): List[Int] = {
    reportFile
      .getLines()
      .map((line: String) => {
        line.toInt
      })
      .toList
  }

  def solveReport(reportFile: BufferedSource): Int = {
    val entries = getEntries(reportFile)
    for(a <- entries; b <- entries) {
      if ((a + b) == 2020) {
        return a * b
      }
    }
    0
  }

  def solveExtendedReport(reportFile: BufferedSource): Int = {
    val entries = getEntries(reportFile)
    for(a <- entries; b <- entries; c <- entries) {
      //println(s"$a - $b - $c")
      if ((a + b + c) == 2020) {
        return a * b * c
      }
    }
    0
  }
}
