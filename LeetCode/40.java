class Solution {
    private List<List<Integer>> result;

    private void DFS(int[] candidates, int x, int k, int index, List<Integer> list) {
        for (int i = k; i < candidates.length; i++) {
            if (i > k && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] == x) {
                list.add(candidates[i]);
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(list);
                result.add(tmp);
                list.remove(index);
            } else if (candidates[i] < x) {
                list.add(candidates[i]);
                DFS(candidates, x-candidates[i], i+1, index+1, list);
                list.remove(index);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        DFS(candidates, target, 0, 0, list);
        return this.result;
    }
}