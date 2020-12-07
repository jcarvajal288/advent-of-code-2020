import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Day6Test extends AnyFlatSpec {

  private val day6 = new Day6()

  it should "find the correct answer for the example problem" in {
    val answerFile = Source.fromResource("Day6ExampleInput")
    assert(day6.findSumOfAnswers(answerFile) == 11)
  }

  it should "find the correct answer for the extended example problem" in {
    val answerFile = Source.fromResource("Day6ExampleInput")
    assert(day6.findSumOfEveryoneAnswers(answerFile) == 6)
  }

  it should "find the correct answer for the full problem" in {
    val answerFile = Source.fromResource("Day6FullInput")
    assert(day6.findSumOfAnswers(answerFile) == 7128)
  }

  it should "find the correct answer for the extended problem" in {
    val answerFile = Source.fromResource("Day6FullInput")
    assert(day6.findSumOfEveryoneAnswers(answerFile) == 3640)
  }
}
