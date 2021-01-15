import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Day11 {

    static int findFinalOccupiedSeats(BufferedReader br) {
        List<List<Character>> seatMap = constructSeatMap(br);
        seatMap = fillAllSeats(seatMap);
        printSeatMap(seatMap);
        List<List<Character>> newSeatMap;
        do {
            newSeatMap = iterateSeatMap(seatMap);
            printSeatMap(newSeatMap);
        } while (!seatMap.equals(newSeatMap));
        return countOccupiedSeats(seatMap);
    }

    private static void printSeatMap(List<List<Character>> seatMap) {
        seatMap.stream().forEachOrdered(row -> {
            for(char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        });
        System.out.println();
    }

    private static List<List<Character>> constructSeatMap(BufferedReader bufferedReader) {
        return bufferedReader
                .lines()
                .map(line -> line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static List<List<Character>> fillAllSeats(List<List<Character>> seatMap) {
        return seatMap.stream()
                .map(seatRow -> seatRow.stream().map(ch -> {
                    if (ch == 'L') {
                        return '#';
                    } else {
                        return ch;
                    }
                }).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static List<List<Character>> iterateSeatMap(List<List<Character>> seatMap) {
        List<List<Character>> newSeatMap = new ArrayList<>();
        for(int row = 0; row < seatMap.size(); row++) {
            int rowSize = seatMap.get(row).size();
            List<Character> newRow = new ArrayList<>();
            for(int seat = 0; seat < rowSize; seat++) {
                char newSeat = transformSeat(row, seat, seatMap);
                newRow.add(newSeat);
            }
            newSeatMap.add(newRow);
        }
        return newSeatMap;
    }

    private static char transformSeat(int rowIndex, int seatIndex, List<List<Character>> seatMap) {
        List<Character> row = seatMap.get(rowIndex);
        if (row.get(seatIndex) == '.') {
            return '.';
        }
        int numSurroundingOccupiedSeats = countSurroundingOccupiedSeats(rowIndex, seatIndex, seatMap);
        if (row.get(seatIndex) == 'L' && numSurroundingOccupiedSeats == 0) {
            return '#';
        } else if (row.get(seatIndex) == '#' && numSurroundingOccupiedSeats >= 4) {
            return 'L';
        }
        return row.get(seatIndex);
    }

    private static int countSurroundingOccupiedSeats(int rowIndex, int seatIndex, List<List<Character>> seatMap) {
        int count = 0;
        for(int r = rowIndex-1; r <= rowIndex+1; r++) {
            for(int s = seatIndex-1; s <= seatIndex+1; s++) {
                if (coordinateOutOfBounds(r, s, seatMap) || (r == rowIndex && s == seatIndex)) {
                    continue;
                }
                if (seatMap.get(r).get(s) == '#') {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean coordinateOutOfBounds(int rowIndex, int seatIndex, List<List<Character>> seatMap) {
        return rowIndex < 0 || seatIndex < 0 || rowIndex >= seatMap.size() || seatIndex >= seatMap.get(rowIndex).size();
    }

    private static int countOccupiedSeats(List<List<Character>> seatMap) {
        return seatMap.stream()
                .map(row -> row.stream().filter(c -> c == '#').count())
                .reduce(0L, Long::sum)
                .intValue();
    }

}
