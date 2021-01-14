import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {

    @Test
    void exampleProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day9ExampleInput")
                )
        );
        assertEquals(127, Day9.findWeakNumber(br, 5));
    }

    @Test
    void fullProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day9FullInput")
                )
        );
        assertEquals(15353384, Day9.findWeakNumber(br, 25));
    }

    @Test
    void extendedProblemOnExampleInputTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day9ExampleInput")
                )
        );
        assertEquals(62, Day9.solveExtendedProblem(br, 127));
    }

    @Test
    void extendedProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day9FullInput")
                )
        );
        assertEquals(2466556, Day9.solveExtendedProblem(br, 15353384));
    }
}
