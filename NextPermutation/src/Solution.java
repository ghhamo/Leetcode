class Solution {
    public void nextPermutation(int[] prevPermutation) {
        int sizePrem = prevPermutation.length;
        if (sizePrem == 1) {
            return;
        }
        int candidateIndex = -1;
        int candidate = -1;
        for (int i = sizePrem - 1; i > 0; i--) {
            if (prevPermutation[i] > prevPermutation[i - 1]) {
                candidateIndex = i - 1;
                candidate = prevPermutation[i - 1];
                break;
            }
        }

        if (candidateIndex != -1) {
            int swapCandidateIndex = -1;
            for (int i = sizePrem - 1; i > candidateIndex; --i) {
                if (prevPermutation[i] > candidate) {
                    swapCandidateIndex = i;
                    break;
                }
            }
            prevPermutation[candidateIndex] = prevPermutation[swapCandidateIndex];
            prevPermutation[swapCandidateIndex] = candidate;
        }
        int n = (sizePrem - candidateIndex) / 2;

        for (int i = 0; i < n; ++i) {
            int rightI = sizePrem - 1 - i;
            int leftI = candidateIndex + i + 1;
            int tmp = prevPermutation[rightI];
            prevPermutation[rightI] = prevPermutation[leftI];
            prevPermutation[leftI] = tmp;
        }
    }
}