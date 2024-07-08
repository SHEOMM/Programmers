import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.isEmpty())
            return answer;
        answer = recursive(p);
        return answer;
    }
    
    private String recursive(String w){
    
        if(isValid(w)){
            return w;
        }
        
        List<String> div = divide(w);
        String u = div.get(0);
        String v = div.get(1);
        if(isValid(u)){
            return u + recursive(v);
        }else{
            String result = "(" + recursive(v) + ")";
            result += reverse(u);
            
            return result;
        }
    }
    
    private String reverse(String u){
        String a = u.substring(1, u.length() - 1);
        String result = "";
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) == '('){
                result = result +  ')';
            }else{
                result = result + '(';
            }
        }
        
        return result;
    }
    
    private List<String> divide(String w){
        List<String> list = new LinkedList<>();
        char[] wArr = w.toCharArray();
        int left = 0;
        int right = 0;
        int i = 0;
        for(; i<wArr.length; i++){
            if(wArr[i] == '('){
                left++;
            }else if(wArr[i] == ')'){
                right++;
            }
            if(left == right)
                break;
        }
        String u = w.substring(0, i+1);
        String v = w.substring(i+1, w.length());
        list.add(u);
        list.add(v);
        return list;
    }
    
    private boolean isValid(String w){
        Stack<Boolean> stack = new Stack<>();
        char[] wArr = w.toCharArray();
        for(int i = 0; i<wArr.length; i++){
            if(wArr[i] == '('){
                stack.push(true);
            }else if(wArr[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }
}