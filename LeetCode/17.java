class Solution {
    public String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public int[] digit = null;
    public List<String> result;

    public void DFS(int index, String str) {
        if (index == digit.length) {
            result.add(str);
            return;
        } 
        int k = digit[index];
        for (int i = 0; i < map[k].length(); i++) {
            DFS(index+1, str+Character.toString(map[k].charAt(i)));
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        if (digits.length() == 0) return result;
        digit = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) >= '2' && digits.charAt(i) <= '9') {
                digit[i] = digits.charAt(i)-'2';
            } else {
                return result;
            }
        }
        DFS(0, "");
        return result;
    }
}