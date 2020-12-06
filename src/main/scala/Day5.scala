import scala.io.BufferedSource

class Day5 {

  case class PassInfo(row: Int, column: Int, seatId: Int)

  def reduceRange(min: Int, max: Int, rangeStr: String): Int = {
     val finalRange = rangeStr.toCharArray
      .foldLeft((min, max)) { (range, nextDirection) =>
        nextDirection match {
          case 'F' | 'L' => (range._1, range._1 + ((range._2 - range._1) / 2))
          case 'B' | 'R' => (range._1 + 1 + ((range._2 - range._1) / 2), range._2)
          case _ => throw new RuntimeException(s"invalid character $nextDirection found in boarding pass string")
        }
      }
    if (finalRange._1 != finalRange._2) {
      throw new RuntimeException("finalRange._1 is not equal to finalRange._2")
    }
    finalRange._1
  }

  def getPassInfo(boardingPass: String): PassInfo = {
    val rowString = boardingPass.substring(0, 7)
    val colString = boardingPass.substring(7, 10)
    val MIN_ROW = 0
    val MAX_ROW = 127
    val MIN_COL = 0
    val MAX_COL = 7

    val row = reduceRange(MIN_ROW, MAX_ROW, rowString)
    val col = reduceRange(MIN_COL, MAX_COL, colString)
    val seatId = (row * 8) + col
    PassInfo(row, col, seatId)
  }

  def findHighestSeatId(passFile: BufferedSource): Int = {
    passFile
      .getLines()
      .map(p => getPassInfo(p))
      .map(p => p.seatId)
      .toList
      .max
  }

  def findMySeat(passFile: BufferedSource): Int = {
    passFile
      .getLines()
      .map(p => getPassInfo(p))
      .map(p => p.seatId)
      .toList
      .sorted
      .zipWithIndex
      .find( seat => {
        seat._1 - seat._2 != 28
      })
      .get._1 - 1
  }

}
