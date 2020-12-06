import scala.io.BufferedSource

class Day4 {

  case class Passport(
                     birthYear: Option[String],
                     issueYear: Option[String],
                     expirationYear: Option[String],
                     height: Option[String],
                     hairColor: Option[String],
                     eyeColor: Option[String],
                     passportId: Option[String],
                     countryId: Option[String]
                     )

  def extractField(maybeStrings: Option[Array[String]]): Option[String] = {
    maybeStrings match {
      case Some(pair) => Some(pair(1))
      case None => None
    }
  }

  def createPassport(blob: String): Passport = {
    val fields = blob
      .split("\\s+")
      .map(fieldBlob => fieldBlob.split(":"))
    val byr = extractField(fields.find(f => f(0).equals("byr")))
    val iyr = extractField(fields.find(f => f(0).equals("iyr")))
    val eyr = extractField(fields.find(f => f(0).equals("eyr")))
    val hgt = extractField(fields.find(f => f(0).equals("hgt")))
    val hcl = extractField(fields.find(f => f(0).equals("hcl")))
    val ecl = extractField(fields.find(f => f(0).equals("ecl")))
    val pid = extractField(fields.find(f => f(0).equals("pid")))
    val cid = extractField(fields.find(f => f(0).equals("cid")))
    Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid)
  }

  def getPassports(passportFileContents: BufferedSource): List[Passport] = {
    passportFileContents
      .mkString
      .split("\\r\\n\\r\\n")
      .map(blob => createPassport(blob))
      .toList
  }

  def isValidPassport(p: Passport): Boolean = {
    List[Boolean](
      p.birthYear.isDefined,
      p.issueYear.isDefined,
      p.expirationYear.isDefined,
      p.height.isDefined,
      p.hairColor.isDefined,
      p.eyeColor.isDefined,
      p.passportId.isDefined,
    ).forall(_ == true)
  }

  def findNumberOfValidPassports(passportFileContents: BufferedSource): Int = {
    getPassports(passportFileContents)
      .count(p => isValidPassport(p))
  }

  def isValidBirthYear(birthYear: Option[String]): Boolean = {
    if(birthYear.isEmpty) {
      return false
    }
    val by = birthYear.get.toInt
    val valid = 1920 <= by && by <= 2002
    valid
  }

  def isValidIssueYear(issueYear: Option[String]): Boolean = {
    if(issueYear.isEmpty) {
      return false
    }
    val by = issueYear.get.toInt
    2010 <= by && by <= 2020
  }

  def isValidExpirationYear(expirationYear: Option[String]): Boolean = {
    if(expirationYear.isEmpty) {
      return false
    }
    val by = expirationYear.get.toInt
    2020 <= by && by <= 2030
  }

  def isValidHeight(height: Option[String]): Boolean = {
    if(height.isEmpty) {
      return false
    }

    val hgt = height.get
    val hgt_int: Int = ("""\d+""".r findFirstIn(hgt)) match {
      case Some(h) => h.toInt
      case None => return false
    }

    if(hgt.contains("cm")) {
      (150 <= hgt_int && hgt_int <= 193)
    } else if(hgt.contains("in")) {
      (59 <= hgt_int && hgt_int <= 76)
    } else {
      false
    }
  }

  def isValidHairColor(hairColor: Option[String]): Boolean = {
    if (hairColor.isEmpty) {
      return false
    }
    val validHairColor = raw"#([a-f]|[0-9]){6}".r
    hairColor.get match {
      case validHairColor(_*) => true
      case _ => false
    }
  }

  def isValidEyeColor(eyeColor: Option[String]): Boolean = {
    if (eyeColor.isEmpty) {
      return false
    }
    val eyc = eyeColor.get
    val validEyeColors: List[String] = List("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    validEyeColors.contains(eyc)
  }

  def isValidPassportId(passportId: Option[String]): Boolean = {
    if (passportId.isEmpty) {
      return false
    }
    val validPid = raw"[0-9]{9}".r
    passportId.get match {
      case validPid(_*) => true
      case _ => false
    }
  }

  def isValidPassportExtended(p: Passport): Boolean = {
    List[Boolean](
      isValidBirthYear(p.birthYear),
      isValidIssueYear(p.issueYear),
      isValidExpirationYear(p.expirationYear),
      isValidHeight(p.height),
      isValidHairColor(p.hairColor),
      isValidEyeColor(p.eyeColor),
      isValidPassportId(p.passportId),
    ).forall(_ == true)
  }

  def findNumberOfValidPassportsExtended(passportFileContents: BufferedSource): Int = {
    getPassports(passportFileContents)
      .count(p => isValidPassportExtended(p))
  }
}
