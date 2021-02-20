import java.util.HashSet;
import java.util.ArrayList;
public class crossword{
    public static void main(String[] args){
        crossWord();
    }
    public static void crossWord(){
        char[][] board = {
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
            {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};
    
        String[] words = {"agra", "norway", "england", "gwalior"};
        System.out.println(crossWord_(board, words, 0));
    }
    public static void dislayCrossWord(char[][] board){
        for(char[] bo: board){
            for(char b: bo){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static boolean canPlaceH(char[][] board,int r,int c,String word){
        for( int i=0; i<word.length(); i++ ){
            if( c + i >= board[0].length || (board[r][c] != '-' && board[r][c+i] != word.charAt(i) )) return false;
        }
        return true;
    }

    public static boolean[] PlaceH(char[][] board,int r,int c,String word){
        boolean[] loc=new boolean[word.length];
        for(int i=0;i<word.length;i++){
            if(board[r][c+i]=='-'){
                loc[i]=true;
                board[r][c+i]=word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlaceH(char[][] board,int r,int c,String word,boolean[] loc){
        for(int i=0;i<loc.length;i++){
            if(loc[i]){
                board[r][c+i]='-';
            }
        }
    }

    public static boolean canPlaceV(char[][] board,int r,int c,String word){
        for( int i=0; i<word.length(); i++ ){
            if( c + i >= board[0].length || (board[r][c+1] != '-' && board[r][c] != word.charAt(i) )) return false;
        }
        return true;
    }

    public static boolean[] PlaceV(char[][] board,int r,int c,String word){
        boolean[] loc=new boolean[word.length];
        for(int i=0;i<word.length;i++){
            if(board[r+i][c]=='-'){
                loc[i]=true;
                board[r+i][c]=word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlaceV(char[][] board,int r,int c,String word,boolean[] loc){
        for(int i=0;i<loc.length;i++){
            if(loc[i]){
                board[r+i][c]='-';
            }
        }
    }

    public static int crossWord_(char[][] board,String[] words,int vidx){
        if(vidx == words.length){
            dislayCrossWord(board);
            return 1;
        }


        String word = words[vidx];
        int count=0;

        for(int i=0;i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                if(board[i][j]=='-' || board[i][j]==word.charAt(0)){
                    if(canPlaceH(board,i,j,word)){
                        boolean[] loc = PlaceH(board,i,j,word);
                        count+=crossWord_(board,words,vidx + 1);
                        unPlaceH(board,i,j,word,loc);
                    }

                    if(canPlaceV(board,i,j,word)){
                        boolean[] loc = PlaceV(board,i,j,word);
                        count+=crossWord_(board,words,vidx + 1);
                        unPlaceV(board,i,j,word,loc);
                    }
                }
            }
        }
        return count;
    }

}