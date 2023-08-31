class Solution {
    public int solution(String word) {
        String strMap = "AEIOU";
        int[] increased = {781, 156, 31, 6, 1};
        
        int answer = word.length();
        for(int i = 0; i < word.length(); i++){
            answer += (increased[i] * strMap.indexOf(word.charAt(i)));
        }
        return answer;
    }
}