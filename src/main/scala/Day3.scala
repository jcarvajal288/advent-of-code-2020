import scala.io.BufferedSource

class Day3 {

  def readSlopeGrid(slopeFileContents: BufferedSource): List[List[Boolean]] = {
    slopeFileContents
      .getLines()
      .map(line => {
        line
          .toList
          .map {
            case '.' => false
            case '#' => true
          }
      })
      .toList
  }

  def findNumberOfTreesOnSlope(slopeFile: BufferedSource, angle: (Int, Int)): Int = {
    val slopeGrid = readSlopeGrid(slopeFile)
    val slopeWidth = slopeGrid(0).size
    slopeGrid
      .zipWithIndex
      .filter(i => i._2 % angle._2 == 0)
      .map( indexedLine => {
        val line = indexedLine._1
        val xCoord = (indexedLine._2 * angle._1) % slopeWidth
        val isTree = line(xCoord)
        isTree
      })
      .count(b => b)
  }

}
