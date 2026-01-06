// Problem 3: word pattern matching

class Solution {

    /**
     * Approach 1: Using two hashmaps to map characters to words and vice versa, ensuring one-to-one correspondence.
     * Determines if a string follows a given word pattern using two HashMaps.
     * This approach maintains a two-way mapping: one from characters to words and another from words to characters.
     * This ensures a strict bijection where each unique character maps to exactly one unique word and vice versa.

     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) where n is the length of the string
     */
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null && s == null) return true;
        if(pattern == null || s == null) return false;
        String[] tString = s.split(" ");
        if(pattern.length() != tString.length)return false;

        HashMap<Character, String> smap = new HashMap<>();
        HashMap<String,Character > tmap = new HashMap<>();

        ArrayList<String> tString1 = new ArrayList<>(Arrays.asList(tString));

        for(int i = 0; i < pattern.length(); i++ ){
            char sChar = pattern.charAt(i);

            if(smap.containsKey(sChar)){
                if(!smap.get(sChar).equals( tString[i])) return false;
            }else{
                smap.put(sChar, tString[i]);
            }
            if(tmap.containsKey(tString[i])){
                if(!tmap.get(tString[i]).equals(sChar)) return false;
            }else{
                tmap.put(tString[i], sChar);
            }

        }
        return true;
    }


    // Approach 2: Using HashMap and HashSet for one-to-one correspondence
    /**
     * Determines if a string follows a given word pattern using a HashMap and a HashSet.
     * The HashMap stores the character-to-word mapping. The HashSet tracks words that have already
     * been assigned to a character. If a new character maps to a word already in the HashSet,
     * it indicates a violation of the bijection.
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) where n is the length of the string
     */

    public boolean wordPattern_2(String pattern, String s) {
        if(pattern == null && s == null) return true;
        if(pattern == null || s == null) return false;
        String[] tString = s.split(" ");
        if(pattern.length() != tString.length)return false;

        HashMap<Character, String> smap = new HashMap<>();
        HashSet<String> tset = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++ ){
            char sChar = pattern.charAt(i);
            String currentWord = tString[i];

            if(smap.containsKey(sChar)){
                if(!smap.get(sChar).equals(currentWord)){
                    return false;
                }
            }else{
                if(tset.contains(currentWord)){
                    return false;
                }
            }
            smap.put(sChar,currentWord);
            tset.add(currentWord);
        }
        return true;
    }
}