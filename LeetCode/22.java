class Solution {
    List <String> result;

    public void DFS(int pre,int left, int cnt, String str) {
        if (cnt == 0) {
            result.add(str);
            return;
        }
        if (pre == 0) {
            if (left != 0) {
                DFS(1, left-1, cnt-1, str+"(");
            }
        } else {
            if (left != 0) {
                DFS(pre+1, left-1, cnt-1, str+"(");
                DFS(pre-1, left, cnt-1, str+")");
            } else {
                DFS(pre-1, left, cnt-1, str+")");
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        DFS(0, n, 2*n, "");
        return result;
    }
}