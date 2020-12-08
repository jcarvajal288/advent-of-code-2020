import org.scalatest.flatspec.AnyFlatSpec

class Day7Test extends AnyFlatSpec {

  private val day7 = new Day7()

  it should "find the correct answer for the example problem" in {
    assert(day7.findHowManyBagsContain("Day7ExampleInput", "shiny gold") == 4)
  }

  it should "find the correct answer for the full problem" in {
    assert(day7.findHowManyBagsContain("Day7FullInput", "shiny gold") == 169)
  }

  it should "find the correct answer for the extended problem" in {
    //val answerFile = Source.fromResource("Day7FullInput")
    //assert(day7.findSumOfEveryoneAnswers(answerFile) == 3740)
  }
}
