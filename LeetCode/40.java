class Solution {
    private List<List<Integer>> result;

    private void DFS(int[] candidates, int x, List<Integer> list, int index, int k) {
        
        for (int i = k ; i < candidates.length; i++) {
            if (candidates[i] == x) {
                list.add(candidates[i]);
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(list);
                result.add(tmp);
                list.remove(index);
            } else if (x > candidates[i]) {
                list.add(candidates[i]);
                DFS(candidates, x-candidates[i], list, index+1, i+1);
                list.remove(index);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        DFS(candidates ,target, list, 0, 0);
        return this.result;
    }
}