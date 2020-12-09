import scala.collection.mutable
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

  def extractColorWithNumber(rawColorString: String): (Int, String) = {
    val splits = rawColorString.strip()
      .split(" ")
    val number = splits.head.toInt
    val color = splits
      .tail
      .init
      .mkString(" ")
    (number, color)
  }


  private def getParentBag(line: String): String = {
    line
      .split("contain")
      .head
      .split(" ")
      .init
      .mkString(" ")
  }

  private def findBagsThatContainColor(rulesFile: String, bagColor: String): List[String] = {
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

  private def findBagsThatContain(rulesFile: String, bagColor: String, currentBags: List[String]): List[String] = {
    val newBags = findBagsThatContainColor(rulesFile, bagColor)
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
    val allBags = findBagsThatContain(rulesFile, bagColor, List[String]())
    allBags.distinct.size
  }

  def getChildBags(line: String): List[String] = {
    line
      .split("contain")
      .last
      .split(",")
      .flatMap(rawColorString => {
        if (rawColorString == " no other bags.") {
          List[String]()
        } else {
          val (number, color) = extractColorWithNumber(rawColorString)
          List.fill(number)(color)
        }
      })
      .toList
  }

  def findBagsContainedBy(rulesMap: Map[String, List[String]], bagColor: String): Unit = {
    val nextLayerOfBags: List[String] = rulesMap(bagColor)
    totalBags += bagColor
    nextLayerOfBags.foreach( newBagColor => {
      findBagsContainedBy(rulesMap, newBagColor)
    })
  }

  private var totalBags = mutable.Queue[String]()

  def constructMap(rulesFile: String): Map[String, List[String]] = {
    Source.fromResource(rulesFile)
      .getLines()
      .map(line => {
        getParentBag(line) -> getChildBags(line)
      })
      .toMap
  }

  def findHowManyBagsInside(rulesFile: String, bagColor: String): Int = {
    totalBags = mutable.Queue[String]()
    val rulesMap = constructMap(rulesFile)
    findBagsContainedBy(rulesMap, bagColor)
    println(totalBags)
    totalBags.size - 1
  }

}
