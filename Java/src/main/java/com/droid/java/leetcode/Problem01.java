package com.droid.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Muran Hu on 2019-03-08.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class Problem01 {
  private static final int[] nums = {2,7,11,15};
  private static final int target = 18;

  public static void main(String[] args) {
    twoSums1();
    twoSum2();
    twoSum3();
  }

  /**
   *
   * 计算数组中元素之和等于target的两个元素下标
   *
   * @return
   */
  private static int[] twoSums1() {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          System.out.println("[" + i + "], " + "[" + j + "]");
          System.out.println(nums[i] + ", " + nums[j]);
          return new int[] {i, j};
        }
      }
    }

    throw new IllegalArgumentException("No two sum solution!");
  }

  private static int[] twoSum2() {
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      hashMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
        System.out.println("[" + i + "], " + "[" + hashMap.get(complement) + "]");
        System.out.println(nums[i] + ", " + complement);
        return new int[] {i, hashMap.get(complement)};
      }
    }

    throw new IllegalArgumentException("No two sum solution!");
  }

  private static int[] twoSum3() {
    Map<Integer, Integer> hashmap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (hashmap.containsKey(complement)) {
        System.out.println("[" + hashmap.get(complement) + "], " + "[" + i + "]");
        System.out.println(complement + ", " + nums[i]);
        return new int[]{hashmap.get(complement), i};
      }

      hashmap.put(nums[i], i);
    }

    throw new IllegalArgumentException("No two sum solution!");
  }
}
