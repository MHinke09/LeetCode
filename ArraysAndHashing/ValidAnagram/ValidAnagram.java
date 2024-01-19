import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 242. Valid Anagram
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {
    public static void main(String[] args) {
        //Test 1: true
        String s1 = "anagram";
        String t1 = "nagaram";
        //Test 2: false
        String s2 = "rat";
        String t2 = "car";
       
        System.out.println(isAnagram(s1,t1));
        System.out.println(isAnagram(s2,t2));
        System.out.println(isAnagramHashMap(s1,t1));
        System.out.println(isAnagramHashMap(s2,t2));
    }
    //Two different solutions
    // Hash map where character is key and num of occurences is value and then compare
    // Or order them both to be the same
    //

    public static boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        String sortedS = new String(charsS);
        String sortedT = new String(charsT);

        return(sortedS.equals(sortedT));
    }

    public static boolean isAnagramHashMap(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Integer> mapS = countCharsInString(s);
        HashMap<Character, Integer> mapT = countCharsInString(t);

        return(mapS.equals(mapT));
    }

    public static HashMap<Character, Integer> countCharsInString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for(char c: arr){
            if(map.containsKey(c)){
                //if character already traversed, increment it
                map.put(c, map.get(c) + 1);
              }else{
                //if character not traversed, add it to hashmap
                map.put(c,1);
              }
        }

        return map;
    }


    
}