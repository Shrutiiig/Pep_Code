//2
public class MazePathMulti{

    public static void main(String[] args) {
        solve();
    }
    public static void solve() {
        int sr=0,sc=0,er=2,ec=2;
        System.out.println(mazePath(sr,sc,er,ec,"")); 
    }
    public static int mazePath(int sr, int sc, int er, int ec, String ans) {
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int jump=1; sc + jump <= ec; jump++) count+=mazePath(sr,sc+jump,er,ec,ans+"H"+jump);
        for(int jump=1; sr + jump <= er; jump++) count+=mazePath(sr+jump,sc,er,ec,ans+"V"+jump);
        for(int jump=1; sc + jump <= ec && sr + jump <= er; jump++) count+=mazePath(sr+jump,sc+jump,er,ec,ans+"D"+jump);
        
        return count;
    }
}