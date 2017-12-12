class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength) return -1;
        if (hLength == nLength) return haystack.equals(needle) ? 0 : -1;
        if (nLength == 0) return 0;
        for (int i = 0; i <= hLength-nLength;) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < nLength && haystack.charAt(i+j) == needle.charAt(j)) {
                    j++;
                }
                if (j == nLength) return i;
            }
            i++;
        }
        return result;
    }
}