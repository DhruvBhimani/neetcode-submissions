class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> parti = new ArrayList<>();

        dfs(0, s, parti, ans);
        return ans;
    }

    private void dfs(int index , String s, List<String> parti, List<List<String>> ans)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList<>(parti));
            return;
        }

        for(int i = index ; i < s.length() ; i++)
        {
            if(validPal(s,index,i))
            {
                parti.add(s.substring(index, i+1));
                dfs(i+1, s, parti, ans);
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
