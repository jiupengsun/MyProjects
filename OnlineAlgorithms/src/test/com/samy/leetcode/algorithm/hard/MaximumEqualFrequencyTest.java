package com.samy.leetcode.algorithm.hard;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MaximumEqualFrequencyTest {

  @DataProvider
  private Object[][] myData() {
    return new Object[][]{
      {new int[]{1, 2, 3, 1, 2, 3, 4, 4, 4, 4, 1, 2, 3, 5, 6}, 13}
    };
  }

  @Test(dataProvider = "myData")
  public void test(int[] nums, int expectResult) {
    MaximumEqualFrequency m = new MaximumEqualFrequency();
    Assert.assertEquals(m.maxEqualFreq(nums), expectResult);
  }
}
