import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day1Test extends AnyFlatSpec {

  val day1 = new Day1()
  val exampleReport = Source.fromResource("Day1ExampleInput")

  it should "solve the example problem" in {
    assert(day1.solveReport(exampleReport) == 514579)
  }

}
