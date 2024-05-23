import java.util.*;
import java.lang.Math;


class Solution {
    public int solution(int n, int k) {
        List<Integer> indexZero = new LinkedList<>();
        int answer = 0;
        String nNum = changeToNaryNumber(n, k, indexZero);
        
        // Entire Number is P
        if(indexZero.size() == 0 && isPrime(Long.parseLong(nNum))){
            answer++;
        }
        answer += countPrime(nNum, indexZero);
        return answer;
    }
    
    private int countPrime(String nNum, List<Integer> indexZero){
        int result = 0;
        int startIndex = -1;
        int endIndex = -1;
        long partialNum = -1;
        for(int i = 0; i<indexZero.size(); i++){
            if(i == 0){
                startIndex = 0;
                endIndex = indexZero.get(i) - 1;
                partialNum = parseSubStringToLong(nNum, startIndex, endIndex);
                if(isPrime(partialNum))
                    result++;
            }
            else if(i == indexZero.size() - 1){
                startIndex = indexZero.get(i) + 1;
                endIndex = nNum.length() - 1;
                partialNum = parseSubStringToLong(nNum, startIndex, endIndex);
                if(isPrime(partialNum))
                    result++;
                break;
            }
            startIndex = indexZero.get(i) + 1;
            endIndex = indexZero.get(i+1) - 1;
            partialNum = parseSubStringToLong(nNum, startIndex, endIndex);
            if(isPrime(partialNum))
                    result++;
        }
        return result;
    }
    
    private long parseSubStringToLong(String nNum, int start, int end){
        char[] nNumArr = nNum.toCharArray();
        String result = "";
        for(int i = start; i<=end; i++){
            result += nNumArr[i];
        }
        if(result.equals(""))
            return 1;
        return Long.parseLong(result);
    }
    
    private String changeToNaryNumber(int n, int k, List<Integer> indexOfZero){
        String result = "";  
        int i = 0;
        List<Integer> backwardIndexOfZero = new LinkedList<>();
        while(n != 0){
            result = (n%k) + result;
            if(n%k == 0){
                backwardIndexOfZero.add(i);
            }
            i++;
            n /= k;
        }
        int size = backwardIndexOfZero.size();
        int strLength = result.length();
        
        for(int j = size-1; j>=0; j--){
            indexOfZero.add(getIndexFromBackward(strLength, backwardIndexOfZero.get(j)));
        }

        return result;
    } 
    
    private int getIndexFromBackward(int size, int index){
        return size - 1 - index;
    }
    
    private boolean isPrime(long n){
        if(n<2){
            return false;
        }
        int maxIndex = (int)Math.floor(Math.sqrt(n));
        for(int i = 2; i<=maxIndex;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
}