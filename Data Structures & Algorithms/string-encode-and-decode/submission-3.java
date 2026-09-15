class Solution 
{

    public String encode(List<String> strs) 
    {
        StringBuilder encoded_string = new StringBuilder();
        for(int i = 0 ; i < strs.size() ; i ++)
        {
            int length1 = strs.get(i).length();
            encoded_string.append(length1).append("#").append(strs.get(i));

        }
        System.out.println(encoded_string);
        return encoded_string.toString();
    }

    public List<String> decode(String str) 
    {

        List<String> decoded_strs = new ArrayList<>();
        StringBuilder numberbuild = new StringBuilder();

        int i = 0 ;
        while(i < str.length())
        {
            char current = str.charAt(i);

            if (Character.isDigit(current)) 
            {
                numberbuild.append(current);
                i++;
            } 
            else if (current == '#') 
            {
                int length = Integer.parseInt(numberbuild.toString());
                numberbuild.setLength(0); 
            
                // Move past the '#' character
                i++; 
                
                String originalWord = str.substring(i, i + length);
                decoded_strs.add(originalWord);
                
                i += length;
            }
        }

        return decoded_strs;
    }
}
