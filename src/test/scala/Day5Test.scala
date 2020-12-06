import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day5Test extends AnyFlatSpec {
  private val day5 = new Day5()

  it should "find the correct info for sample boarding passes" in {
    val pass1 = day5.getPassInfo("FBFBBFFRLR")
    val pass2 = day5.getPassInfo("BFFFBBFRRR")
    val pass3 = day5.getPassInfo("FFFBBBFRRR")
    val pass4 = day5.getPassInfo("BBFFBBFRLL")

    assert(pass1.row == 44)
    assert(pass1.column == 5)
    assert(pass1.seatId == 357)

    assert(pass2.row == 70)
    assert(pass2.column == 7)
    assert(pass2.seatId == 567)

    assert(pass3.row == 14)
    assert(pass3.column == 7)
    assert(pass3.seatId == 119)

    assert(pass4.row == 102)
    assert(pass4.column == 4)
    assert(pass4.seatId == 820)
  }

  it should "find the correct answer for the full problem" in {
    val passFile = Source.fromResource("Day5FullInput")
    assert(day5.findHighestSeatId(passFile) == 842)
  }

  it should "find my seat" in {
    val passFile = Source.fromResource("Day5FullInput")
    assert(day5.findMySeat(passFile) == 617)
  }
}
