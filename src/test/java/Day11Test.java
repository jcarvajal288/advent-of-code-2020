import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    @Test
    void exampleProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day11ExampleInput")
                )
        );
        assertEquals(37, Day11.findFinalOccupiedSeats(br));
    }

    @Test
    void fullProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day11FullInput")
                )
        );
        assertEquals(2321, Day11.findFinalOccupiedSeats(br));
    }
}
