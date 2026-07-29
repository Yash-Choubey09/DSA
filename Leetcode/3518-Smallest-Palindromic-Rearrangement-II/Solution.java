class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int n = s.length();
        int m = n / 2;
        int[] halfCount = new int[26];
        char midChar = 0;

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
        }

        long totalPerms = getPermutations(halfCount, m, k);
        if (totalPerms < k) {
            return "";
        }

        StringBuilder firstHalf = new StringBuilder();
        long currentK = k;

        for (int pos = 0; pos < m; pos++) {
            for (int c = 0; c < 26; c++) {
                if (halfCount[c] > 0) {
                    halfCount[c]--;
                    long cnt = getPermutations(halfCount, m - 1 - pos, currentK);
                    if (cnt >= currentK) {
                        firstHalf.append((char) ('a' + c));
                        break;
                    } else {
                        currentK -= cnt;
                        halfCount[c]++; 
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            result.append(midChar);
        }
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }
    private long getPermutations(int[] count, int rem, long k) {
        if (rem == 0) return 1;

        int maxIdx = 0;
        for (int i = 1; i < 26; i++) {
            if (count[i] > count[maxIdx]) {
                maxIdx = i;
            }
        }

        long ans = 1;
        int currentNum = count[maxIdx] + 1;

        for (int i = 0; i < 26; i++) {
            if (i == maxIdx) continue;
            for (int j = 1; j <= count[i]; j++) {
                ans = ans * currentNum;
                ans = ans / j;
                currentNum++;
                if (ans > k) {
                    return k + 1; 
                }
            }
        }
        return ans;
    }
}