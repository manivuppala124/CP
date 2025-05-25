/*A secret agent receives a list of encrypted codewords. 
Each codeword must follow the same symbol sequence as a given prototype code. 
Your mission is to find which codewords follow the same symbol arrangement.

NOTE:
Matching is not about the actual characters, but how they repeat.
For example, “moon” = m o o n → pattern: first letter, two repeated letters, and a unique last letter.

Input Format:
-------------
Line-1: A space-separated list of words 
Line-2: A string representing the reference pattern

Output Format:
---------------------
Line-1: A list of words that follow the same pattern, if not found print -1


Sample Input-1:
---------------
Leet abcd loot geek cool for peer dear seed meet noon mess loss
moon

Sample Output-1:
----------------
leet loot geek cool peer seed meet


Sample Input-2:
----------------
leet abcd loot geek cool for peer dear
lamp

Sample Output-2:
----------------
abcd dear
 */
import java.util.*;

public class FindWordsFollowGivenPattern {

    // Function to encode a word to its pattern like "moon" -> "0 1 1 2"
    private static String getPattern(String word) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int code = 0;

        for (char ch : word.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, code++);
            }
            pattern.append(map.get(ch)).append(" ");`
        }

        return pattern.toString().trim(); // remove trailing space
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        String[] words = sc.nextLine().split(" ");
        String patternWord = sc.nextLine().trim();

        String patternCode = getPattern(patternWord);
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.length() == patternWord.length() && getPattern(word).equals(patternCode)) {
                result.add(word);
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(String.join(" ", result));
        }
    }
}
