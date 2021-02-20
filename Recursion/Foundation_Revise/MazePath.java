// 1
public class MazePath{

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
        if(sc+1<=ec) count+=mazePath(sr,sc+1,er,ec,ans+"H");
        if(sr+1<=er) count+=mazePath(sr+1,sc,er,ec,ans+"V");
        if(sc+1<=ec && sr+1<=er) count+=mazePath(sr+1,sc+1,er,ec,ans+"D");
        
        return count;
    }
}