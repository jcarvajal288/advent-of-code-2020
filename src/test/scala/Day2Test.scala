import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day2Test extends AnyFlatSpec {

  private val day2 = new Day2()

  it should "solve the example problem" in {
    val passwordFile = Source.fromResource("Day2ExampleInput")
    assert(day2.findValidPasswords(passwordFile) == 2)
  }

  it should "solve the full problem" in {
    val passwordFile = Source.fromResource("Day2FullInput")
    println(day2.findValidPasswords(passwordFile))
  }

  it should "solve the extended problem" in {
    val passwordFile = Source.fromResource("Day2FullInput")
    println(day2.findValidExtendedPasswords(passwordFile))
  }
}
