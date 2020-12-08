import scala.io.{BufferedSource, Source}

class Day7 {

  private def getBagColorsContainedInThisBag(line: String): List[String] = {
    line
      .split("contain")
      .last
      .split(",")
      .map(rawColorString => {
        extractColor(rawColorString)
      })
      .toList
  }

  private def extractColor(rawColorString: String): String = {
    rawColorString.strip()
      .split(" ")
      .tail
      .init
      .mkString(" ")
  }

  def getParentBag(line: String): String = {
    line
      .split("contain")
      .head
      .split(" ")
      .init
      .mkString(" ")
  }

  def findBagsThatContainColor(rulesFile: String, bagColor: String): List[String] = {
    Source.fromResource(rulesFile)
      .getLines()
      .filter(line => {
        line
          .split("contain")
          .last
          .contains(bagColor)
      })
      .toList
      .map(line => {
        getParentBag(line)
      })
  }

  def findBagsThatContain(rulesFile: String, bagColor: String, currentBags: List[String]): List[String] = {
    val newBags = findBagsThatContainColor(rulesFile, bagColor)
    //println(newBags)
    //println(currentBags)
    //println()
    if (newBags.isEmpty) {
      currentBags
    } else {
      val newCurrentBags = currentBags ++ newBags
      newBags.foldLeft(List[String]()) { (bags, nextColor) =>
        bags ++ findBagsThatContain(rulesFile, nextColor, newCurrentBags)
      }
    }
  }

  def findHowManyBagsContain(rulesFile: String, bagColor: String): Int = {
    val allBags = findBagsThatContain(rulesFile, bagColor, List())
    allBags.distinct.size
  }

}
