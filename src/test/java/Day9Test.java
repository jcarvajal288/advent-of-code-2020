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
    void FullProblemTest() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/Day9FullInput")
                )
        );
        assertEquals(15353384, Day9.findWeakNumber(br, 25));
    }
}
