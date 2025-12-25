import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {
    public static String getLongestSubStringWithoutRepeatingChars(String str) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (result.toString().contains(String.valueOf(c))) {
                set.add(result.toString());
                result = new StringBuilder();
                result.append(c);
            } else {
                result.append(c);
            }
        }
        set.add(result.toString());
        int len = 0;
        String res = "";
        for (String s : set) {
            if (len<s.length()){
                len=s.length();
                res = s;
            }
        }
        return res;
    }

    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }
            charIndexMap.put(currentChar, end);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        //System.out.println(getLongestSubStringWithoutRepeatingChars("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkwewl"));
    }
}
