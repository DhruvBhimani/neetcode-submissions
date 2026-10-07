class Solution {
    public List<String> letterCombinations(String digits) 
    {
        if(digits.isEmpty()) return new ArrayList<>();

        return helper("", digits);
    }
    private List<String> helper(String p, String up)
    {
        if(up.isEmpty())
        {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list1 = new ArrayList<>();

        int digit = up.charAt(0) - '0';

        if(digit == 7)
        {
            for(int i = 15  ; i<= 18 ; i++)
            {
            
                char ch = (char) (i + 'a');
                List<String> tmp = helper(p + ch , up.substring(1));

                list1.addAll(tmp);
            }
                
        }
        else if(digit == 8)
        {
             for(int i = 19  ; i< 22 ; i++)
            {
            
                char ch = (char) (i + 'a');
                List<String> tmp = helper(p + ch , up.substring(1));

                list1.addAll(tmp);
            }   
        }
        else if(digit == 9)
        {
            for(int i = 22  ; i<= 25 ; i++)
            {
            
                char ch = (char) (i + 'a');
                List<String> tmp = helper(p + ch , up.substring(1));

                list1.addAll(tmp);
            }
                
        }
        else
        {
            // 2= a,b,c -> 2 = 0,1,2
            for(int i = (digit-2)*3  ; i< (digit-1)*3 ; i++)
            {
            
                char ch = (char) (i + 'a');
                List<String> tmp = helper(p + ch , up.substring(1));

                list1.addAll(tmp);
            }
        }
        
        

        return list1;
    }
}
