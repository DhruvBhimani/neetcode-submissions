class Solution 
{
    private final String[] digitToChar =  { "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) 
    {
        if (digits.isEmpty()) return new ArrayList<>();
        
        return helper("", digits);
    }

    private List<String> helper(String p, String up)
    {
        if (up.isEmpty())
        {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list1 = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        String chars = digitToChar[digit];

        for (int i = 0; i < chars.length(); i++)
        {
            char ch = chars.charAt(i);
            List<String> tmp = helper(p + ch, up.substring(1));
            list1.addAll(tmp);
        }

        return list1;
    }
}
