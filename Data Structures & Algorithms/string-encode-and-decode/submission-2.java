class Solution 
{

    public String encode(List<String> strs) 
    {

        String encoded_string = String.join("\u001F" , strs);

        return encoded_string;
    }

    public List<String> decode(String str) 
    {

        if (str.isEmpty()) 
        {
            return new ArrayList<>();
        }
        List<String> decoded_strs = Arrays.asList(str.split("\u001F"));

        return decoded_strs;
    }
}
