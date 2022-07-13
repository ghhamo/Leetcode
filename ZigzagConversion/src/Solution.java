class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || numRows >= len) {
            return s;
        }
        char[] result = new char[len];
        int i = 0;
        int maxR = numRows - 1;
        int rr = maxR << 1;
        for (int index = 0; index < len; i++) {
            result[i] = s.charAt(index);
            index += rr;
        }
        int j = i;
        for (i = 1; i < maxR; i++) {
            int prevIndex = i;
            for (int segmentIndex = 1; prevIndex < len; segmentIndex++) {
                result[j++] = s.charAt(prevIndex);
                int shift;
                if (segmentIndex % 2 == 0) {
                    shift = i << 1;
                } else {
                    shift = (maxR - i) << 1;
                }
                prevIndex += shift;
            }
        }
        for (int index = maxR; index < len; ) {
            result[j++] = s.charAt(index);
            index += rr;
        }
        return String.valueOf(result);
    }
}