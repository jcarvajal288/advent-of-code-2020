import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day3Test extends AnyFlatSpec {

  private val day3 = new Day3()

  it should "solve the example problem" in {
    val slopeFile = Source.fromResource("Day3ExampleInput")
    assert(day3.findNumberOfTreesOnSlope(slopeFile, (3,1)) == 7)
  }

  it should "solve the full problem" in {
    val slopeFile = Source.fromResource("Day3FullInput")
    assert(day3.findNumberOfTreesOnSlope(slopeFile, (3,1)) == 205)
  }

  it should "solve the extended problem" in {
    val slopeFile = Source.fromResource("Day3FullInput")
    val results = List[Double](
      day3.findNumberOfTreesOnSlope(Source.fromResource("Day3FullInput"), (1,1)),
      day3.findNumberOfTreesOnSlope(Source.fromResource("Day3FullInput"), (3,1)),
      day3.findNumberOfTreesOnSlope(Source.fromResource("Day3FullInput"), (5,1)),
      day3.findNumberOfTreesOnSlope(Source.fromResource("Day3FullInput"), (7,1)),
      day3.findNumberOfTreesOnSlope(Source.fromResource("Day3FullInput"), (1,2))
    )
    println(results)
    println(results.product)
  }
}
