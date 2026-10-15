class Pair
{
    String first;
    int second;
    Pair(String first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord,1));

        Set<String> st = new HashSet<>();
        for(String n : wordList)
        {
            st.add(n);
        }
        st.remove(beginWord);

        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if(word.equals(endWord)) return steps;

            for(int i = 0 ; i < word.length() ; i++)
            {
                for(char ch = 'a'; ch <= 'z' ; ch++)
                {
                    char replacedArray[] = word.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);

                    if(st.contains(replacedWord))
                    {
                        st.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
