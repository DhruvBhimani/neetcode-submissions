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
        if(beginWord.length() != endWord.length()) return 0;

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord,1));

        Set<String> st = new HashSet<>();
        for(String n : wordList)
        {
            st.add(n);
        }

        if (!st.contains(endWord)) return 0;
        
        st.remove(beginWord);

        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if(word.equals(endWord)) return steps;

            char replacedArray[] = word.toCharArray();

            for(int i = 0 ; i < word.length() ; i++)
            {
                char originalChar = replacedArray[i];

                for(char ch = 'a'; ch <= 'z' ; ch++)
                {
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);

                    if(st.contains(replacedWord))
                    {
                        st.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps+1));
                    }
                }
                replacedArray[i] = originalChar;
            }
        }
        return 0;
    }
}
