class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> parti = new ArrayList<>();

        dfs(0, s, parti, ans);
        return ans;
        
    }

    private void dfs(int i , String s, List<String> parti, List<List<String>> ans)
    {
        if(i >= s.length())
        {
            ans.add(new ArrayList<>(parti));
            return;
        }

        for(int j = i ; j<s.length() ; j++)
        {
            if(validPal(s,i,j))
            {
                parti.add(s.substring(i, j+1));
                dfs(j+1, s, parti, ans);
                parti.remove(parti.size()-1);
            }
        }
    }

    private boolean validPal(String s, int left, int right)
    {
        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
