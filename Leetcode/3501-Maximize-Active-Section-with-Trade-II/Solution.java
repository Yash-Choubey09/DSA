import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
        }

        // 1. Extract all '0' segments
        List<int[]> zeroSegments = new ArrayList<>(); // [start, end, len]
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (start == -1) start = i;
            } else {
                if (start != -1) {
                    zeroSegments.add(new int[]{start, i - 1, i - start});
                    start = -1;
                }
            }
        }
        if (start != -1) {
            zeroSegments.add(new int[]{start, n - 1, n - start});
        }

        int m = zeroSegments.size();
        List<Integer> ans = new ArrayList<>(queries.length);

        // If there are fewer than two '0' segments, no trade can be performed
        if (m < 2) {
            for (int i = 0; i < queries.length; i++) {
                ans.add(totalOnes);
            }
            return ans;
        }

        // 2. Precompute gain for all adjacent pairs of '0' segments: V[i] = len(Z_i) + len(Z_{i+1})
        int numPairs = m - 1;
        int[] val = new int[numPairs];
        for (int i = 0; i < numPairs; i++) {
            val[i] = zeroSegments.get(i)[2] + zeroSegments.get(i + 1)[2];
        }

        // 3. Build Sparse Table for Range Maximum Query on val[]
        int LOG = 1;
        while ((1 << LOG) <= numPairs) LOG++;
        int[][] st = new int[LOG][numPairs];
        for (int i = 0; i < numPairs; i++) {
            st[0][i] = val[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i + (1 << j) <= numPairs; i++) {
                st[j][i] = Math.max(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
            }
        }

        int[] logTable = new int[numPairs + 1];
        for (int i = 2; i <= numPairs; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        // 4. Process each query
        for (int[] q : queries) {
            int l = q[0], r = q[1];

            // Find first zero segment that ends >= l
            int iFirst = binarySearchFirst(zeroSegments, l);
            // Find last zero segment that starts <= r
            int iLast = binarySearchLast(zeroSegments, r);

            // Valid pair indices i must satisfy: iFirst <= i <= iLast - 1
            if (iFirst == -1 || iLast == -1 || iFirst >= iLast) {
                ans.add(totalOnes);
                continue;
            }

            int firstPair = iFirst;
            int lastPair = iLast - 1;

            int maxGain = 0;

            // Evaluate boundary pairs with truncation
            maxGain = Math.max(maxGain, getPairGain(firstPair, l, r, zeroSegments));
            if (lastPair != firstPair) {
                maxGain = Math.max(maxGain, getPairGain(lastPair, l, r, zeroSegments));
            }

            // Evaluate interior pairs (neither segment is truncated by l or r) via RMQ
            if (firstPair + 1 <= lastPair - 1) {
                int ql = firstPair + 1;
                int qr = lastPair - 1;
                int k = logTable[qr - ql + 1];
                int rmq = Math.max(st[k][ql], st[k][qr - (1 << k) + 1]);
                maxGain = Math.max(maxGain, rmq);
            }

            ans.add(totalOnes + maxGain);
        }

        return ans;
    }

    private int binarySearchFirst(List<int[]> segs, int l) {
        int low = 0, high = segs.size() - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (segs.get(mid)[1] >= l) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private int binarySearchLast(List<int[]> segs, int r) {
        int low = 0, high = segs.size() - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (segs.get(mid)[0] <= r) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private int getPairGain(int i, int l, int r, List<int[]> segs) {
        int[] z1 = segs.get(i);
        int[] z2 = segs.get(i + 1);

        int len1 = Math.max(0, Math.min(z1[1], r) - Math.max(z1[0], l) + 1);
        int len2 = Math.max(0, Math.min(z2[1], r) - Math.max(z2[0], l) + 1);

        return len1 + len2;
    }
}