import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day4Test extends AnyFlatSpec {
  private val day4 = new Day4()

  it should "solve the example problem" in {
    val passportFile = Source.fromResource("Day4ExampleInput")
    assert(day4.findNumberOfValidPassports(passportFile) == 2)
  }

  it should "solve the full problem" in {
    val passportFile = Source.fromResource("Day4FullInput")
    assert(day4.findNumberOfValidPassports(passportFile) == 242)
  }

  it should "solve the extended problem" in {
    val passportFile = Source.fromResource("Day4FullInput")
    assert(day4.findNumberOfValidPassportsExtended(passportFile) == 186)
  }

  it should "validate fields correctly" in {
    assert(day4.isValidBirthYear(Some("2002")))
    assert(!day4.isValidBirthYear(Some("2003")))

    assert(day4.isValidHeight(Some("60in")))
    assert(day4.isValidHeight(Some("190cm")))
    assert(!day4.isValidHeight(Some("190in")))
    assert(!day4.isValidHeight(Some("60")))

    assert(day4.isValidHairColor(Some("#123abc")))
    assert(!day4.isValidHairColor(Some("#123abz")))
    assert(!day4.isValidHairColor(Some("123abc")))

    assert(day4.isValidEyeColor(Some("brn")))
    assert(!day4.isValidEyeColor(Some("wat")))

    assert(day4.isValidPassportId(Some("000000001")))
    assert(!day4.isValidPassportId(Some("0123456789")))
  }
}
