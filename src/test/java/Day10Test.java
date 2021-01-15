import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

    @Test
    void exampleProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day11ExampleInput")
                )
        );
        assertEquals(35, Day10.find1JoltDiffs_x_3JoltDiffs(br));
    }

    @Test
    void exampleProblem2Test() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day10ExampleInput2")
                )
        );
        assertEquals(220, Day10.find1JoltDiffs_x_3JoltDiffs(br));
    }

    @Test
    void fullProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day10FullInput")
                )
        );
        assertEquals(2059, Day10.find1JoltDiffs_x_3JoltDiffs(br));
    }

    @Test
    void extendedProblemExampleTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day10ExampleInput")
                )
        );
        assertEquals(8, Day10.countAllArrangements(br));
    }

    @Test
    void extendedProblemExample2Test() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day10ExampleInput2")
                )
        );
        assertEquals(19208, Day10.countAllArrangements(br));
    }
}
