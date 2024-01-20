import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task2 {

    public static void countLightsSwitchedOn(List<int[]> events) {
        // Create array numbers with values ai's and bi's
        List<int[]> numbers = new ArrayList<>();
        for (int[] event : events) {
            numbers.add(new int[]{event[0], 0}); // entry time
            numbers.add(new int[]{event[1], 1}); // exit time
        }

        // Sort array numbers
        Collections.sort(numbers, Comparator.comparingInt(a -> a[0]));

        int x = 0;
        int count = 0;

        // For each element in numbers
        for (int[] element : numbers) {
            // If element is entry time
            if (element[1] == 0) {
                // If x is 0
                if (x == 0) {
                    count++;
                }
                x++;
            }
            // If element is exit time
            else {
                x--;
            }
        }

        // Display value of count as the number of times the light gets switched on
        System.out.println(count);
    }

    public static void main(String[] args) {
        // Example usage:
        List<int[]> events = List.of(new int[]{1, 3}, new int[]{2, 5}, new int[]{4, 7}, new int[]{6, 8});
        countLightsSwitchedOn(events);
    }
}
