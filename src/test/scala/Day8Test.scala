import org.scalatest.flatspec.AnyFlatSpec

class Day8Test extends AnyFlatSpec {

  private val day8 = new Day8()

  it should "find the correct answer for the example problem" in {
    assert(day8.findValueInAccumulator("Day8ExampleInput") == 5)
  }

  it should "find the correct answer for the full problem" in {
    println(day8.findValueInAccumulator("Day8FullInput"))
    //assert(day8.findValueInAccumulator("Day8FullInput") == 5)
  }

  it should "find the correct answer for the second example problem" in {
  }

  it should "find the correct answer for the extended problem" in {
  }
}
