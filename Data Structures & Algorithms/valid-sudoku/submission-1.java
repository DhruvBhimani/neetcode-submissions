class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        
        Set<Character> row = new HashSet<>();
        Set<Character> column = new HashSet<>();
       for(int i=0; i<9; i++)
       {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] != '.')
                {
                    if(!row.contains(board[i][j]))
                    {
                        row.add(board[i][j]);
                    }
                    else
                    {
                        return false;
                    }
                }
                if(board[j][i] != '.')
                {
                    if(!column.contains(board[j][i]))
                    {
                        column.add(board[j][i]);
                    }
                    else
                    {
                        return false;
                    }
                }
                 
            } 
            row.clear();
            column.clear();
       } 

       
        for(int i=0; i<9; i=i+3)
       {
            for(int j=0; j<9; j=j+3)
            {
                for(int a=0; a<3; a++)
                {
                    for(int b=0; b<3; b++)
                    {
                        if(board[i+a][j+b]!= '.')
                        {
                            if(!row.contains(board[i+a][j+b]))
                            {
                                row.add(board[i+a][j+b]);
                            }
                            else if(row.contains(board[i+a][j+b]))
                            {
                                return false;
                            }
                        }
                        
                    } 
                }
                row.clear();
            }
            
       } 


       return true;
    }
}
