//4
public class FloodFill_MultiJump{

    public static void main(String[] args) {
        solve();
    }
    public static void solve() {
        floodFillMulti(); 
    }
    public static int floodFillMulti_(int sr, int sc, int er, int ec,boolean[][] visited, int[][] dir,String[] dirS, String ans) {
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }
        visited[sr][sc] = true;
        int count=0;
        for( int jump=1; jump<=Math.max(er,ec);jump++ ){
            for( int d=0; d<4; d++ ){
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];

                if( r >= 0 && c >= 0 && r <= er && c <= ec && visited[r][c] == false ){
                    count += floodFillMulti_(r,c,er,ec,visited,dir,dirS, ans+dirS[d]);
                }
            }
        }
        visited[sr][sc] = false;
        return count;
    }
    public static void floodFillMulti(){
        int sr=0, sc=0, er=3, ec=3;
        int[][] dirFour = {{1,0},{-1,0},{0,1},{0,-1}};
        String[] dirFourS = {"D","U","R","L"};
        boolean[][] visited = new boolean[er+1][ec+1];
    
        System.out.println(floodFillMulti_(sr,sc,er,ec,visited,dirFour,dirFourS,""));
    }
}