//3
public class FloodFill{

    public static void main(String[] args) {
        solve();
    }
    public static void solve() {
        floodFill(); 
    }
    public static int floodFill_(int sr, int sc, int er, int ec,boolean[][] visited, int[][] dir,String[] dirS, String ans) {
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }
        visited[sr][sc] = true;
        int count=0;
        for( int d=0; d<4; d++ ){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if( r >= 0 && c >= 0 && r <= er && c <= ec && visited[r][c] == false ){
                count += floodFill_(r,c,er,ec,visited,dir,dirS, ans+dirS[d]);
            }
        }
        visited[sr][sc] = false;
        return count;
    }
    public static void floodFill(){
        int sr=0, sc=0, er=3, ec=3;
        int[][] dirFour = {{1,0},{-1,0},{0,1},{0,-1}};
        String[] dirFourS = {"D","U","R","L"};
        boolean[][] visited = new boolean[er+1][ec+1];
    
        System.out.println(floodFill_(sr,sc,er,ec,visited,dirFour,dirFourS,""));
    }
}
