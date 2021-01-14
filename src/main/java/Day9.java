import java.io.BufferedReader;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Day9 {

    static long findWeakNumber(BufferedReader bufferedReader, int preambleLength) {
        List<Long> numbersList = bufferedReader
                .lines()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        ListIterator<Long> startOfWindow = numbersList.listIterator(0);
        ListIterator<Long> endOfWindow = numbersList.listIterator(preambleLength);
        while(endOfWindow.hasNext()) {
            if (!endOfWindowIsSumOfPreviousNumbers(startOfWindow.nextIndex(), endOfWindow.nextIndex(), numbersList)) {
                return endOfWindow.next();
            }
            startOfWindow.next();
            endOfWindow.next();
        }
        return -999;
    }

    private static boolean endOfWindowIsSumOfPreviousNumbers(int firstNumberIndex, int lastNumberIndex, List<Long> numbers) {
        long lastNumber = numbers.get(lastNumberIndex);
        for(int i = firstNumberIndex; i < lastNumberIndex; i++) {
            for(int j = i+1; j < lastNumberIndex; j++) {
                if((numbers.get(i) + numbers.get(j)) == lastNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}
