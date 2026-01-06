// Problem 1 : Group Anagrams

//Approach 1:
//Time Complexity: O(n * k log k), where n is the number of strings and k is the average length of a string
//Space Complexity: O(n * k), where n is the number of strings and k is the average length of a string
class Solution {
    /**
     * Groups anagrams by sorting each string to create a unique key.
     * All anagrams will result in the same sorted string, allowing them to be grouped in a HashMap.
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap <String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length ; i++){
            String currentString = strs[i];
            char [] charArray = currentString.toCharArray();
            // Sort characters: Anagrams like "eat" and "tea" both become "aet"
            Arrays.sort(charArray);  // added complexity O(k log k)
            String sortedString = String.valueOf(charArray);
            // Use the sorted string as a key to group original strings
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            List<String> list = map.get(sortedString);
            list.add(currentString);
            map.put(sortedString,list);
        }
        return new ArrayList<>(map.values());
    }

}


// Approach 2:

import java.math.BigInteger;

//Time Complexity: O(n * k) where n is the number of strings and k is the average length of a string
//Space Complexity: O(n * k) where n is the number of strings
class Solution {
    /**
     * Groups anagrams using Prime Factorization (Fundamental Theorem of Arithmetic).
     * Each lowercase letter is mapped to a unique prime number. The product of these primes
     * for a word is unique to its set of characters, regardless of their order.
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap <BigInteger, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length ; i++){
            String currentString = strs[i];
            // Calculate a unique numeric key based on prime products
            BigInteger primeProduct = primeProduct(currentString);

            if(!map.containsKey(primeProduct)){
                map.put(primeProduct, new ArrayList<>());
            }
            List<String> list = map.get(primeProduct);
            list.add(currentString);
            map.put(primeProduct,list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * Calculates the product of primes corresponding to each character in the string.
     * Uses BigInteger to prevent overflow for long strings.
     */
    private BigInteger primeProduct(String s){
        // Mapping 'a' through 'z' to the first 26 prime numbers
        int [] prime =new int [] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,103};
        BigInteger result = BigInteger.ONE;
        for(int i=0;i < s.length();i++){
            char ch = s.charAt(i);
            // Multiply the running total by the prime number associated with the current character
            result = result.multiply(BigInteger.valueOf( prime[ch - 'a']));
        }
        return result;
    }

}
