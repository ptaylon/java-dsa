package br.com.studies.array.majorityelement;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreMajorityVoteAlgorithmUseCase implements FindMajorityElements {

    @Override
    public List<Integer> findMajority(final int[] nums) {

        int candidate1 = -1;
        int candidate2 = -1;
        int candidateScore1 = 0;
        int candidateScore2 = 0;

        for (int num : nums) {

            if (candidate1 == -1)
                candidate1 = num;
            else if (candidate2 == -1)
                candidate2 = num;

            if (num == candidate1) {
                candidateScore1++;
            } else if (num == candidate2) {
                candidateScore2++;
            } else {

                candidateScore1--;
                candidateScore2--;

                if (candidateScore1 <= 0) {
                    candidate1 = -1;
                    candidateScore1 = 0;
                }
                if (candidateScore2 <= 0) {
                    candidate2 = -1;
                    candidateScore2 = 0;
                }

            }

        }

        candidateScore1 = 0;
        candidateScore2 = 0;

        for (int num : nums) {
            if (num == candidate1) candidateScore1++;
            if (num == candidate2) candidateScore2++;
        }

        List<Integer> majorityElements = new ArrayList<>();
        int oneThirdOfArray = nums.length / 3;

        if (candidateScore1 > oneThirdOfArray) majorityElements.add(candidate1);
        if (candidateScore2 > oneThirdOfArray && candidate1 != candidate2) majorityElements.add(candidate2);

        //Collections.sort(majorityElements);
        swapIfNecessary(candidateScore1, candidateScore2, majorityElements);

        return majorityElements;

    }

    private static void swapIfNecessary(final int candidateScore1, final int candidateScore2, final List<Integer> majorityElements) {
        if (majorityElements.size() > 1 && candidateScore1 > candidateScore2) {
            int temp = majorityElements.get(0);
            majorityElements.set(0, majorityElements.get(1));
            majorityElements.set(1, temp);
        }
    }

    public static void main(String[] args) {

        BoyerMooreMajorityVoteAlgorithmUseCase boyerMooreMajorityVoteAlgorithmUseCase = new BoyerMooreMajorityVoteAlgorithmUseCase();
        boyerMooreMajorityVoteAlgorithmUseCase.findMajority(new int[]{2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6});

    }

}
