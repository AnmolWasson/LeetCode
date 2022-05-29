package DailyProblems;
import java.util.*;
public class May29 {

  //318. Maximum Product of Word Lengths
  public int maxProduct(String[] words) {
    int n = words.length;
    
    
    
    int[][] freq = new int[n][26];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        char ch = words[i].charAt(j);
        freq[i][ch - 'a'] = 1;
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int count = 0;
        for (int k = 0; k < 26; k++) {
          count += (freq[i][k] & freq[j][k]);
        }

        if (count == 0) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }

    return max;
  }
}
