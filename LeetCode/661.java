class Solution {

    public int getAverge(int i, int j, int[][] M) {
        int cnt = 1;
        int tmp = 0;
        tmp += M[i][j];
        if (i-1 >= 0) {
            tmp += M[i-1][j];
            cnt++;
        }
        if (i+1 < M.length) {
            tmp += M[i+1][j];
            cnt++;
        }
        if (j-1 >= 0) {
            tmp += M[i][j-1];
            cnt++;
        }
        if (j+1 < M[i].length) {
            tmp += M[i][j+1];
            cnt++;
        }
        if (i-1 >= 0 && j-1 >= 0) {
            tmp += M[i-1][j-1];
            cnt++;
        }
        if (i+1 < M.length && j-1 >= 0) {
            tmp += M[i+1][j-1];
            cnt++;
        }
        if (i-1 >= 0 && j+1 < M[i].length) {
            tmp += M[i-1][j+1];
            cnt++;
        }
        if (i+1 < M.length && j+1 < M[i].length) {
            tmp += M[i+1][j+1];
            cnt++;
        }
         return (int)Math.floor((tmp*1.0)/cnt);
    }

    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][];
        for (int i = 0; i < M.length; i++) {
            result[i] = new int[M[i].length];
            for (int j = 0; j < M[i].length; j++) {
                result[i][j] = getAverge(i, j, M);
            }
        }
        return result;
    }
}