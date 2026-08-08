class Solution {

    boolean check(int row, int col, int n,List<StringBuilder> board){
        int r = row;
        int c = col;

        // lets check for column

        while(r>=0){
            if(board.get(r).charAt(c)=='Q') return false;
            r--;
        }

        /// lEFT Diagonal:
        r = row;
        c = col;

        while(r>=0 && c>=0){
            if(board.get(r).charAt(c)=='Q') return false;
            r--;
            c--;
        }

        r=row;
        c=col;

        while(r>=0 && c<n){
            if(board.get(r).charAt(c)=='Q') return false;
            r--;
            c++;
        }

        return true;
    }
    void solve(List<List<String>> ans,List<StringBuilder> board, int row, int col, int n){

        if(row>=n){
            List<String> curr = new ArrayList<>();
            for(int i=0;i<n;i++){

                curr.add(board.get(i).toString());
            }
            ans.add(curr);
            return;

        }

        for(int i=0;i<n;i++){
            if(check(row,i,n,board)){
                board.get(row).setCharAt(i,'Q');
                solve(ans,board,row+1,0,n);
                board.get(row).setCharAt(i,'.');
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {

      List<StringBuilder> board = new ArrayList<>();
      List<List<String>> ans = new ArrayList<>();
      for(int i=0;i<n;i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(".");
        }
        board.add(sb);
      }  
      solve(ans,board,0,0,n);
    return ans;  

    }
    
    

    
}