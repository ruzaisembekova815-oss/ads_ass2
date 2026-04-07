import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = sortString(str);           // sorted string as key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Sort each group alphabetically
        for (List<String> group : map.values()) {
            Collections.sort(group);
        }

        return new ArrayList<>(map.values());
    }

    // Helper: returns sorted version of string
    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();                     // consume newline

        String[] strs = new String[n];
        System.out.println("Enter " + n + " strings:");

        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine().trim();   // trim spaces
        }

        List<List<String>> result = groupAnagrams(strs);

        System.out.println("\n=== Anagram Groups ===");
        for (List<String> group : result) {
            System.out.println(group);
        }

        sc.close();
    }
}