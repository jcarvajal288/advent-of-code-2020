import scala.collection.mutable
import scala.io.Source

class Day8 {

  class CPU(initialAccumulator: Int, initialInstructionPointer: Int) {
    var accumulator: Int = initialAccumulator
    var instPtr: Int = initialInstructionPointer
    var previousInstructions: mutable.Queue[Int] = mutable.Queue[Int]()

    def runProgram(instructionList: List[(String, Int)]): Unit = {
      while (!previousInstructions.contains(instPtr)) {
        previousInstructions += instPtr
        val (opcode, argument) = instructionList(instPtr)
        opcode match {
          case "acc" =>
            accumulator += argument
            instPtr += 1
          case "jmp" => instPtr += argument
          case "nop" => instPtr += 1
          case _ => throw new RuntimeException(s"Unknown opcode $opcode")
        }
      }
    }
  }

  def getInstructionList(inputFile: String): List[(String, Int)] = {
    Source.fromResource(inputFile)
      .getLines()
      .map(line => {
        val splits = line.split(" ")
        val opcode: String = splits(0)
        val argument: Int = splits(1).toInt
        (opcode, argument.toInt)
      })
      .toList
  }

  def findValueInAccumulator(inputFile: String): Int = {
    val instructionList = getInstructionList(inputFile)
    val cpu = new CPU(0, 0)
    cpu.runProgram(instructionList)
    cpu.accumulator
  }
}
