package com.basicapplication.ui.application_flow;

import java.util.Arrays;

public class LogicTest {
    public static String twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return Arrays.toString(new int[] { i, j });
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
