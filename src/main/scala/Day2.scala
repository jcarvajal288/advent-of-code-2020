import scala.io.BufferedSource

class Day2 {

  case class PassObj(minTimes: Int,
                     maxTimes: Int,
                     letter: Char,
                     password: String
                    ) {}

  def readPasswordObjects(passwordFileContents: BufferedSource): List[PassObj] = {
    passwordFileContents
      .getLines()
      .map((line: String) => {
        val splits: Array[String] = line.split(" ")
        val timesSplits: Array[String] = splits(0).split("-")
        val minTimes: Int = timesSplits(0).toInt
        val maxTimes: Int = timesSplits(1).toInt
        val letter: Char = splits(1)(0)
        val password: String = splits(2)
        PassObj(
          minTimes,
          maxTimes,
          letter,
          password
        )
      })
      .toList
  }

  def isValidPassword(passObj: PassObj): Boolean = {
    val timesLetterOccurs = passObj.password.count(_ == passObj.letter)
    timesLetterOccurs >= passObj.minTimes && timesLetterOccurs <= passObj.maxTimes
  }

  def isValidExtendedPassword(passObj: PassObj): Boolean = {
    val firstPositionHasLetter = passObj.password.charAt(passObj.minTimes-1).equals(passObj.letter)
    val secondPositionHasLetter = passObj.password.charAt(passObj.maxTimes-1).equals(passObj.letter)
    firstPositionHasLetter ^ secondPositionHasLetter
  }

  def findValidPasswords(passwordFileContents: BufferedSource): Int = {
    val passwordObjects = readPasswordObjects(passwordFileContents)
    val validPasswordObjects = passwordObjects.filter(passObj => isValidPassword(passObj))
    validPasswordObjects.size
  }

  def findValidExtendedPasswords(passwordFileContents: BufferedSource): Int = {
    val passwordObjects = readPasswordObjects(passwordFileContents)
    val validPasswordObjects = passwordObjects.filter(passObj => isValidExtendedPassword(passObj))
    validPasswordObjects.size
  }

}
