package HashMapsAndSets;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByFrequency {
    public static void main(String[] args) {
        String result =frequencySort("tree");
        System.out.println(result);
    }

    public static String frequencySort(String s) {

        Map<Character, Long> frequencyMap = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> SortedMap = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Long> m : SortedMap.entrySet()) {
                sb.repeat(m.getKey(), Math.toIntExact(m.getValue()));
        }
        return sb.toString();

    }
}
