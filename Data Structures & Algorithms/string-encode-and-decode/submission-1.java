class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length());
            result.append("#");
            result.append(str);
        }
        //System.out.println(result.toString());// calculate each string length add # and then string
       // 5#Hello 5#World
        return result.toString();
    }

    public List<String> decode(String str) 
    {
        List<String> result = new ArrayList<>();// list of each elements
        int i = 0;
        while (i < str.length()) 
        { // Find '#'
            int j = i;
            while (str.charAt(j) != '#') 
            {
                j++;
            } 
            // Get length
            int length = Integer.parseInt(str.substring(i, j)); // 5 
            
            // Move after '#'
            i = j + 1;

            // Extract string
            String strings = str.substring(i, i + length);
            result.add(strings); 
            
            // Move to next encoded string
            i = i + length;
        }
        return result;
    }
}
