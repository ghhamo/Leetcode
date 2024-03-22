import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        for (int i = 0; i < len; i++) {
            int ith = isConnected[i][i];
            for (int j = 0; j < len; j++) {
                if (ith == 1 && isConnected[i][j] == 1)
                    union(i, j, id);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(id[i]);
        }
        return set.size();
    }
    public void union(int p, int q, int[] id) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) id[i] = id[q];
        }
    }
}