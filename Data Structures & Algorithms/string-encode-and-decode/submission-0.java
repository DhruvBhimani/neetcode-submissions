class Solution 
{

    public String encode(List<String> strs) 
    {

        String encoded_string = String.join("#" , strs);

        return encoded_string;
    }

    public List<String> decode(String str) 
    {
        List<String> decoded_strs = Arrays.asList(str.split("#"));

        return decoded_strs;
    }
}
