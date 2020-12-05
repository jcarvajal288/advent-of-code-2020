import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day1Test extends AnyFlatSpec {

  private val day1 = new Day1()

  it should "solve the example problem" in {
    val exampleReport = Source.fromResource("Day1ExampleInput")
    assert(day1.solveReport(exampleReport) == 514579)
  }

  it should "solve the full problem" in {
    val fullReport = Source.fromResource("Day1FullInput")
    val solution = day1.solveReport(fullReport)
    println(solution)
  }

  it should "solve the extended problem" in {
    val fullReport = Source.fromResource("Day1FullInput")
    val solution = day1.solveExtendedReport(fullReport)
    println(solution)
  }
}
