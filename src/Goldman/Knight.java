package Goldman;

import java.util.Arrays;
import java.util.List;

/**
 * Created by baiwe on 2017/12/11.
 */
public class Knight {

    //Probability of Knight to remain in the chessboard

    class Solution {
        public double knightProbability(int N, int K, int r, int c) {
            int [][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
            double [][] dp0 = new double[N][N];
            for(double [] row : dp0){
                Arrays.fill(row, 1);
            }

            for(int step = 0; step<K; step++){
                double [][] dp1 = new double[N][N];
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<N; j++){
                        for(int [] move : moves){
                            int row = i + move[0];
                            int col = j + move[1];
                            if(isIllegal(row, col, N)){
                                dp1[row][col] += dp0[i][j];
                            }
                        }
                    }
                }
                dp0 = dp1;
            }
            return dp0[r][c]/Math.pow(8,K);
        }

        private boolean isIllegal(int row, int col, int len){
            return row>=0 && row<len && col>=0 && col<len;
        }
    }


    public int[][] multiply(int[][] A, int[][] B){
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = 0; k < t; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
}

class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

interface WeightedGraph{
    int size();
    int[] neighbors(int n);
    int getWeight(int a, int v);
}

class Dijkstra {
    public static int[] dijkstra (WeightedGraph G, int s){
        final int[] dist = new int[G.size()]; //
        final int[] pred = new int[G.size()]; // predeeding node in path
        final boolean[] visited = new boolean[G.size()];
        // initilize
        for (int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;

        for (int i = 0; i < dist.length; i++){
            final int next = minVertex(dist, visited);
            visited[next] = true;

            // The shprtest path to next is dist[next]  and via pred[next].

            final int[] n = G.neighbors(next);
            for (int j = 0; j < n.length; j++){
                final int v = n[j];
                final int d = dist[next] + G.getWeight(next, v);
                if (dist[v] > d){
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }
        return pred;
    }

    private static int minVertex (int[] dist, boolean[] v){
        int x = Integer.MAX_VALUE;
        int y = -1;
        for (int i = 0; i < dist.length; i++){
            if(!v[i] && dist[i] < x){
                y = i;
                x= dist[i];
            }
        }
        return y;
    }
}
