//Problem 2: Isomorphic Strings

// Approach 1: Using two hashmaps to map characters from one string to another, ensuring one-to-one correspondence.
class Solution {
    /**
     * Determines if two strings are isomorphic using two HashMaps.
     * This approach maintains a bidirectional mapping: one from string 's' characters to 't',
     * and another from string 't' characters back to 's'. This ensures a strict 1:1 relationship (bijection),
     * preventing multiple characters from mapping to the same character.
     *
     * Time Complexity: O(n) - We iterate through the strings once, where n is the length of the strings.
     * Space Complexity: O(1) - While we use HashMaps, the number of possible characters (like ASCII) is fixed,
     *                          resulting in constant auxiliary space.
     */
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if(sl != tl){
            return false;
        }
        HashMap<Character,Character> s_map = new HashMap<>();
        HashMap<Character,Character> t_map = new HashMap<>();

        for(int i = 0 ; i < sl ; i++ ){
            Character s_char = s.charAt(i);
            Character t_char = t.charAt(i);

            if(s_map.containsKey(s_char)){
                if(s_map.get(s_char) != t_char){
                    return false;
                }
            }else{
                s_map.put(s_char, t_char);
            }
            if(t_map.containsKey(t_char)){
                if(t_map.get(t_char) != s_char){
                    return false;
                }
            }else{
                t_map.put(t_char, s_char);
            }
        }
        return true;
    }

    // Approach 2: Using HashMap and a HashSet for one-to-one correspondence

    /**
     * Determines if two strings are isomorphic using one HashMap and one HashSet.
     * This approach maps characters from 's' to 't' using a HashMap. To ensure no two characters
     * from 's' map to the same character in 't', a HashSet is used to keep track of characters
     * in 't' that have already been assigned a mapping.
     *
     * Time Complexity: O(n) - We iterate through the strings once.
     * Space Complexity: O(1) - The space used by the Map and Set is limited by the fixed size of the character set.
     */
    public boolean isIsomorphic_2(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if(sl != tl){
            return false;
        }
        HashMap<Character,Character> s_map = new HashMap<>();
        HashSet<Character> t_set = new HashSet<>();

        for(int i = 0 ; i < sl ; i++ ){
            Character s_char = s.charAt(i);
            Character t_char = t.charAt(i);

            if(s_map.containsKey(s_char)){
                if(s_map.get(s_char) != t_char){
                    return false;
                }
            }else{
                if(t_set.contains(t_char)){
                    return false;
                }else{
                    s_map.put(s_char, t_char);
                    t_set.add(t_char);
                }
            }

        }
        return true;
    }
}