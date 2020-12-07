import scala.io.BufferedSource

class Day6 {

  def getGroups(answerFileContents: BufferedSource): List[String] = {
    answerFileContents
      .mkString
      .split("\\r\\n\\r\\n")
      .toList
  }

  def findSumOfAnswers(answerFile: BufferedSource): Int = {
    getGroups(answerFile)
      .map(group => {
        group
          .split("\\r\\n")
          .mkString
          .distinct
          .length
      })
      .sum
  }

  def findSumOfEveryoneAnswers(answerFile: BufferedSource): Int = {
    getGroups(answerFile)
      .map(group => {
        val people = group.split("\\r\\n")
        val firstPerson = people.head
        people.tail
          .foldLeft(firstPerson) { (intersection, nextList) =>
            intersection.intersect(nextList)
          }
          .length
      })
      .sum
  }

}
