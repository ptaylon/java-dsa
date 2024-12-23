package br.com.studies.array.majorityelement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Algorithmic complexity: O(n)
 * Space complexity: O(n)
 */

public class UsingDictionaryHashMapUseCase implements FindMajorityElements {

    @Override
    public List<Integer> findMajority(int[] nums) {

        int oneThird = nums.length / 3;
        Map<Integer, Integer> survey = new HashMap<>();
        countOccurrences(nums, survey);

        return filterMajorityElements(survey, oneThird);

    }

    private static List<Integer> filterMajorityElements(final Map<Integer, Integer> survey, final int oneThird) {

        List<Integer> majorityElements = new ArrayList<>();

        for (Map.Entry<Integer, Integer> srv : survey.entrySet()) {
            if (srv.getValue() > oneThird) {
                majorityElements.add(srv.getKey());
            }
        }

        return majorityElements;

    }

    private static void countOccurrences(final int[] nums, final Map<Integer, Integer> survey) {
        for (int num : nums) {
            survey.put(
                num,
                survey.getOrDefault(num, 0) + 1
            );
        }
    }

}