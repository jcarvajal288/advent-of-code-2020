import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

class Day10 {

    static int find1JoltDiffs_x_3JoltDiffs(BufferedReader bufferedReader) {
        List<Integer> sortedAdapters = bufferedReader
                .lines()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int oneJoltDifferences = 0;
        int threeJoltDifferences = 1; // built in adapter counts as 3-jolt
        int previousJoltage = 0;
        ListIterator<Integer> iter = sortedAdapters.listIterator(0);
        for(; iter.hasNext(); iter.next()) {
            int currentJoltage = sortedAdapters.get(iter.nextIndex());
            switch(currentJoltage - previousJoltage) {
                case 1:
                    oneJoltDifferences++;
                    break;
                case 3:
                    threeJoltDifferences++;
                    break;
                default:
                    String message = String.format("Invalid difference %d found with joltages %d and %d", (currentJoltage - previousJoltage), previousJoltage, currentJoltage);
                    throw new RuntimeException(message);
            }
            previousJoltage = currentJoltage;
        }
        return oneJoltDifferences * threeJoltDifferences;
    }

    static long countAllArrangements(BufferedReader bufferedReader) {
        List<Integer> sortedAdapters = bufferedReader
                .lines()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return countLeafNodes(sortedAdapters, 0);
    }

    private static int countLeafNodes(List<Integer> sortedAdapters, int position) {
        System.out.print(String.format("%d: ", sortedAdapters.get(position)));
        List<Integer> childNodePositions = findChildIndicesForPosition(sortedAdapters, position);
        if(childNodePositions.isEmpty()) {
            return 1;
        } else if (childNodePositions.size() == 1) {
            return countLeafNodes(sortedAdapters, childNodePositions.get(0));
        } else {
            return childNodePositions
                    .stream()
                    .map(childPosition -> countLeafNodes(sortedAdapters, childPosition))
                    .reduce(0, Integer::sum);
        }
    }

    private static List<Integer> findChildIndicesForPosition(List<Integer> sortedAdapters, int position) {
        int currentJoltage = sortedAdapters.get(position);
        List<Integer> childNodePositions = new ArrayList<>();
        for(int i = position+1; i < sortedAdapters.size(); i++) {
            if (sortedAdapters.get(i) - currentJoltage > 3) {
                break;
            }
            System.out.print(sortedAdapters.get(i) + ",");
            childNodePositions.add(i);
        }
        System.out.println("");
        return childNodePositions;
    }
}
