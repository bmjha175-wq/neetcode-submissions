class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) 
        {
            int[] count = new int[26];

            // Count the frequency of each character
            for (char ch : str.toCharArray()) 
            {
                count[ch - 'a']++;
            }

            // Create a unique key from the character frequencies
            StringBuilder keyBuilder = new StringBuilder();

            for (int frequency : count) {
                keyBuilder.append(frequency).append('#');
            }

            String key = keyBuilder.toString();

            // Create a group if the key does not exist
            map.putIfAbsent(key, new ArrayList<>());

            // Add the string to its anagram group
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
