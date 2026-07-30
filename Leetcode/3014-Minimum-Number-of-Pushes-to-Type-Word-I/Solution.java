class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int totalPushes = 0;
        int pushCost = 1;
        while (n > 0) {
            int charsInCurrentLayer = Math.min(n, 8);
            totalPushes += charsInCurrentLayer * pushCost;
            n -= charsInCurrentLayer;
            pushCost++;
        }
        return totalPushes;
    }
}