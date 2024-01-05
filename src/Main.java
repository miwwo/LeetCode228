/*
You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
That is, each element of nums is covered by exactly one of the ranges, and there is
no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        int beginIndex, endIndex;
        for (int i = 0; i < nums.length; i++) {
            beginIndex = i;
            while (i!=nums.length - 1 && nums[i + 1] == nums[i] + 1){
                i++;
            }
            endIndex = i;
            if (endIndex-beginIndex==0) {
                output.add(Integer.toString(nums[beginIndex]));
            }else{
                output.add(nums[beginIndex] +"->"+ nums[endIndex]);
            }
        }
        return output;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] nums = {0,2,3,4,6,8,9};
        List<String> output = Arrays.asList("0","2->4","6","8->9");
        System.out.println(Solution.summaryRanges(nums));

        int[] nums_1 = {0,1,2,4,5,7};
        List<String> output_1 = Arrays.asList("0->2","4->5","7");
        System.out.println(Solution.summaryRanges(nums_1));
    }
}