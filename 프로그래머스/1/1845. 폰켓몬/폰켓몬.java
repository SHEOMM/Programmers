import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    public int solution(int[] nums) {
        int answer = 0;
        for(int num: nums){
            set.add(num);
        }
        if(set.size() > nums.length / 2){
            return nums.length / 2;
        }
        return set.size();
    }
}