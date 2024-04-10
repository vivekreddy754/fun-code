import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean checkAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c2 : s2.toCharArray()) {
            if (!map.containsKey(c2)) {
                return false;
            } else {
                if (map.get(c2) == 1) {
                    map.remove(c2);
                } else {
                    map.put(c2, map.get(c2) - 1);
                }
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram("listen", "silent3"));
    }
}
