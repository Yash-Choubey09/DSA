import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                initialOnes++;
            }
        }

        String t = "1" + s + "1";
        
        List<Character> types = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        
        int n = t.length();
        int i = 0;
        while (i < n) {
            char c = t.charAt(i);
            int j = i;
            while (j < n && t.charAt(j) == c) {
                j++;
            }
            types.add(c);
            lengths.add(j - i);
            i = j;
        }

        int maxDelta = 0;
        for (int k = 1; k < types.size() - 1; k++) {
            if (types.get(k) == '1' && types.get(k - 1) == '0' && types.get(k + 1) == '0') {
                int delta = lengths.get(k - 1) + lengths.get(k + 1);
                maxDelta = Math.max(maxDelta, delta);
            }
        }
        return initialOnes + maxDelta;
    }
}