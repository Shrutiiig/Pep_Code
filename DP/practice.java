public static int fib( int n, int[] dp ){
    if( n <= 1 ) return dp[n] = n;

    if(dp[n] != 0) return dp[n];

    int a = fib(n-1,dp);
    int b = fib(n-2,dp);

    return dp[n] = a + b;
}

public static int fib(int n, int[] dp){
    for( int i=0; i<n; i++ ){
        if( i <= 1 ) {
            dp[i] = i;
            continue;
        }
        int a = dp[i-1];
        int b = dp[i-2];
        dp[i] = a+b;
    }
    return dp[n];
}

public static int fibo_opti(int N){
    int a = 0;
    int b = 1;
    for( int n=2; n<=N; n++ ){
        int sum = a+b;
        a=b;
        b=sum;
    }
    return b;
}

public static int mazePath_HVD(int sr,int sc,int er,int ec,int[][] dp){
    
    if( sr==er && sc==ec ) return dp[sr][sc] = 1;

    if( dp[sr][sc] != 0 ) return dp[sr][sc];

    if(sc+1 <= ec) count += mazePath_HVD( sr,sc+1,er,ec,dp );
    if(sr+1 <= er && sc+1 <= ec) count += mazePath_HVD( sr+1,sc+1,er,ec,dp );
    if( sr+1 <= er ) count += mazePath_HVD( sr+1,sc,er,ec,dp );

    return dp[sr][sc] = count;
}

public static int mazePath_HVD(int sr,int sc,int er,int ec,int[][] dp){
    for( sr=er; sr>=0; sr-- ){
        for( sc=ec; sc>=0; sc-- ){
            if( sr == er && sc == ec ){ 
                dp[sr][sc] = 1;
                continue;
            }
            int count = 0;
            if(sc+1 <= ec) count += dp[sr][sc+1];
            if(sr+1 <= er && sc+1 <= ec) count += dp[sr+1][sc+1];
            if( sr+1 <= er ) count += dp[sr+1];

            dp[sr][sc] = count;
        }
    }return dp[0][0];
}

public static int mazePath_HVDJump_DP(int sr,int sc,int er,int ec,int[][] dp){
    for( sr=er; sr>=0; sr-- ){
        for( sc=ec; sc>=0; sc-- ){
            if( sr == er && sc == ec ){ 
                dp[sr][sc] = 1;
                continue;
            }
            int count = 0;
            for(int jump = 1; sc+jump <= ec; jump++ ) count += dp[sr][sc+jump];
            if(int jump = 1; sr+jump <= er && sc+jump <= ec; jump++ ) count += dp[sr+jump][sc+jump];
            if( int jump = 1; sr+jump <= er ; jump++ ) count += dp[sr+jump];

            dp[sr][sc] = count;
        }
    }return dp[0][0];

}

public static int fib_rec( int n ){
    if( n <= 1 ) return n;

    int nm1 = fib_rec(n-1);
    int nm2 = fib_rec(n-2);

    int fibn = nm1 + nm2;
    return fibn;
}

public static int fib_mem( int n, int[] dp ){
    if( n <= 1 ){
        return n;
    } 
    if( dp[n] != 0 ){
        return dp[n];
    }
    int nm1 = fib_mem(n-1, dp);
    int nm2 = fib_mem(n-2, dp);

    int fibn = nm1 + nm2;
    dp[n] = fibn;
    return fibn;
}