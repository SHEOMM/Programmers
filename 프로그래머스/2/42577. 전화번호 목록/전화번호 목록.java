import java.util.*;

class Solution {
    
    Map<String, Boolean> phoneBook = new HashMap<>();
    
    
    public boolean solution(String[] phone_book) {
        
        for(String number: phone_book){
            phoneBook.put(number, true);
        }
        
        for(String number: phone_book){
    
            StringBuilder prefix = new StringBuilder();
            for(Character num: number.toCharArray()){
                prefix.append(num);
                if(phoneBook.containsKey(prefix.toString()) && !prefix.toString().equals(number)){
                    return false;
                }
            }
             
        }
        return true;
    }
}