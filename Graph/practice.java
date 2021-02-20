public class practice{

    public static class Edge{
        int v = 0;
        int w = 0;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static int findEdge(int u,int v){
        int idx = -1;
        for( int i=0; i<graph[u].size(); i++ ){
            Edge e = graph[u].get(i);
            if( e.v == v ){
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void removeEdge(int u,int v){
        int idx = findEdge(u,v);
        graph[u].remove( idx );

        int idx = findEdge(v,u);
        graph[v].remove( idx );
    }

    public static void removeVtx(int u){
        while( graph[u].size() != 0 ){
            Edge e = graph[u].get( graph[u].size()-1 );
            removeEdge(u,e.v);
        }
    }

    public static boolean hasPath(int src,int dest,boolean[] vis){
        if( src == dest ) return true;

        vis[src] = true;
        boolean res = false;
        
        for( Edge e : graph[src] ){
            if( !vis[e.v] )
                res = res || hasPath( e.v,dest,vis );
        }
        return res;
    }

    public static int allPath(int src,int dest,boolean[] vis,int weight,String ans){
        if( src == dest ){
            System.out.println(ans + src + " @ " + weight);
            return 1;
        }

        vis[src] = true;
        for( Edge e : graph[src] ){
            count += allPath(e.v,dest,vis,weight + e.w, ans + src + " ");
        }
        vis[src] = false;
        return count;
    }

    public static pair heavyWeightPath(int src,int dest,boolean[] vis){

    }

    public static void bfs(int src, boolean[] vis){

        LinkedList<Integer> qu = new LinkedList<>();
        qu.addLast(src);

        while( qu.size() != 0 ){
            int vtx = qu.removeFirst();

            if( vis(vtx) ){
                System.out.println( vtx );
                continue;
            }

            vis[vtx] = true;
            for( Edge e : graph[vtx] ){
                if( !vis(e.v) ){
                    qu.addLast[e.v];
                }
            }
        }
    }

    public static void bfs1(int src, boolean[] vis){
        LinkedList<Integer> qu = new LinkedList<>();
        int level = 0;
        qu.addLast(src);
        while( qu.size() != 0 ){
            int size = qu.size();
            while( size != 0 ){

                int vtx = qu.removeFirst();
                if( vis[vtx] ) continue;

                vis[vtx] = true;
                for( Edge e : graph[vtx] ){
                    if( !vis[e.v] ){
                        qu.addLast(e.v);
                    }
                }
                size--;
            }
            level++;
        }
    }

    public static void bfs2(int src, boolean[] vis){
        LinkedList<Integer> qu = new LinkedList<>();
        int level = 0;
        qu.addLast(src);
        vis[src] = true;

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size != 0 ){

                int vtx = qu.removeFirst();
                if( vis[vtx] ) continue;

                
                for( Edge e : graph[vtx] ){
                    if( !vis[e.v] ){
                        qu.addLast(e.v);
                        vis[e.v] = true;
                    }
                }
                size--;
            }
            level++;
        }
    }

    public static void KahnsAlgo(){
        LinkedList<Integer> qu = new LinkedList<>()
        int[] indegree = new int[N];

        for( int i=0; i<N; i++ ){
            for( Edge e : graph[i] ){
                indegree[e.v]++;
            }
        }

        for( int i=0; i<N; i++ ){
            if( indegree[i] == 0 ) qu.addLast(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while( qu.size() != 0 ){
            int rvtx = qu.removeFirst();
            ans.add(rvtx);

            for( Edge e : graph[rvtx] ){
                if( --indegree[e.v] == 0 ) qu.addLast(e.v);
            }
        }

        if( ans.size() != N ) Systm.out.println("Cycle exists");

        for( int ele : ans ) System.out.println(ans);

    }

    public static void KahnsAlgo(){
        int[] indegree = new int[N];
        for( int i=0; i<N; i++ ){
            for( Edge e : graph[i] ){
                indegree[e.v]++;
            }
        }

        LinkedList<Integer> que = new LinkedList<>();
        for( int i=0; i<N; i++ ){
            if( indegree[i] == 0 ){
                que.addLast(i);
            }
        }
        
        LinkedList<Integer> ans = new LinkedList<>();
        while( que.size() != 0 ){
            int rvtx = que.removeFirst();
            ans.addLast(rvtx);

            for( Edge e : graph[rvtx] ){
                if ( --indegree[e.v] == 0 ) que.addLast(e.v);
            }
        }

        if( ans.size() != N ) CYCLE exists
    }

    static int[] par;
    static int[] size;

    public static int findPar(int u){
        if( u == par[u] ) return u;
        return findPar(par[u]);
    }

    public static void addEdge(int u, int v, int w ){
        graph[u].addEdge(v,w);
        graph[v].addEdge(u,w);
    }

    public static void merge(int p1, int p2 ){
        if( size[p1] > size[p2] ){
            par[p2] = p1;
            size[p1] += size[p2];
        }else{

        }
    }

    public static void unionFind(int[][] gp){
        //gp : u,v,w

        for( int i=0; i<n; i++ ) graph[i] = new ArrayList<>();

        for( int i=0; i<n; i++ ){
            par[i] = i;
        }

        for( int a[] : gp ){
            int u = a[0];
            int v = a[1];
            int w = a[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if( p1 != p2 ) {
                addEdge(u,v,w);
                merge(p1,p2);
            }
        }
    }

    public static void kruskal(int[][] gp){
        //gp : u,v,w

        for( int i=0; i<n; i++ ) graph[i] = new ArrayList<>();

        Arrays.sort( gp,(a,b) -> {
            return a[2]-b[2];
        })

        for( int i=0; i<n; i++ ){
            par[i] = i;
        }

        for( int a[] : gp ){
            int u = a[0];
            int v = a[1];
            int w = a[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if( p1 != p2 ) {
                addEdge(u,v,w);
                merge(p1,p2);
            }
        }
    }

    public static class primsPair implements Comparable<primsPair>{
        int vtx = 0;
        int par = 0;
        int wt = 0;

        primsPair( int vtx, int par, int wt ){
            this.vtx = vtx;
            this.par = par;
            this.wt = wt;
        }

        @Override
        public int compareTo(primsPair other){
            return this.wt - other.wt;
        }
    }

    public static void prims(int src,int N,ArrayList<Edge>[] graph){

        ArrayList<Edge>[] primsGraph = new ArrayList<>();
        for( int i=0; i<N; i++ ) primsGraph[i] = new ArrayList<>();

        PriorityQueue<primsPair> pq = new PriorityQueue<>();
        pq.add( src,-1,0 );

        boolean[] vis = new boolean[N];

        int edgeCount = 0;

        while( edgeCount != N-1 ){
            primsPair rpair = pq.remove();

            if( vis[rpair] ) continue;

            if( rpair.par != -1 ){
                addEdge( primsGraph,rpair.vtx, rpair.par, rpair.wt );
                edgeCount++;
            }

            vis[rpair.vtx] = true;

            for(Edge e: graph[rPair.vtx]){
                if(!vis[e.v])
                  pq.add(new primsPair(e.v,rPair.vtx,e.w));
            }
        }
    }.

    public static class pair implements Comparable<pair>{
        int vtx = 0;
        int par = 0;
        int wt = 0;
        int wsf = 0;

        pair( int vtx, int par, int wt, int wsf ){
            this.vtx = vtx;
            this.par = par;
            this.wt = wt;
            this.wsf = wsf;
        }

        @Override
        public int compareTo( pair o ){
            return this.wt - o.wt;
        }
    }
    
    public static void Dijikstra(int src,int N,ArrayList<Edge>[] graph){

        ArrayList<Edge> dijigraph = new ArrayList<>();
        for( int i=0; i<N; i++ ) dijigraph[i] = new ArrayList<>();

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add( new pair( src, -1, 0, 0 ) );

        boolean[] vis = new boolean[N];
        int[] cost = new int[N];
        Arrays.fill( cost, (int)1e8 );
        cost[src] = 0;

        int EdgeCount = 0;
        while( EdgeCount != N-1 ){
            pair rpair = pq.remove();

            if( vis[rpair.vtx] ) continue;

            if( rpair.par != -1 ){
                addEdge( dijigraph, rpair.vtx, rpair.par, rpar.wt );
                EdgeCount++;
            }

            vis[rpair.vtx] = true;

            for(Edge e: graph[rPair.vtx]){
                if(!vis[e.v] && rPair.wsf + e.w < costArray[e.v]){
                    costArray[e.v] = rPair.wsf + e.w;
                    pq.add(new dijiPair(e.v,rPair.vtx,e.w,rPair.wsf + e.w));
                }
            }
        }
    }
}