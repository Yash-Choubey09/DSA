class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        StringBuilder stack = new StringBuilder();
        boolean[] seen = new boolean[26]; 
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (seen[curr - 'a']) {
                continue;
            }
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > curr && 
                   lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                
                seen[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            stack.append(curr);
            seen[curr - 'a'] = true;
        }
        return stack.toString();
    }
}