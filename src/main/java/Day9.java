import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

class Day9 {

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

    static long solveExtendedProblem(BufferedReader bufferedReader, long targetNumber) {
        List<Long> numbersList = bufferedReader
                .lines()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<Long> continuousSet = findContinuousSetThatAddsToTarget(numbersList, targetNumber);
        Long min = Collections.min(continuousSet);
        Long max = Collections.max(continuousSet);
        return min + max;
    }

    private static List<Long> findContinuousSetThatAddsToTarget(List<Long> numbersList, long targetNumber) {
        ListIterator<Long> startOfSet = numbersList.listIterator(0);
        for(; startOfSet.hasNext(); startOfSet.next()) {
            long sum = numbersList.get(startOfSet.nextIndex());
            List<Long> continuousSet = new ArrayList<>(Collections.singletonList(numbersList.get(startOfSet.nextIndex())));
            ListIterator<Long> iter = numbersList.listIterator(startOfSet.nextIndex()+1);
            for(; iter.hasNext(); iter.next()) {
                long nextNumber = numbersList.get(iter.nextIndex());
                continuousSet.add(nextNumber);
                sum += nextNumber;
                if (sum == targetNumber) {
                    return continuousSet;
                } else if (sum > targetNumber) {
                    break;
                }
            }
        }
        return new ArrayList<>();
    }
}
