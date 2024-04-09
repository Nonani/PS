import java.util.*;
import java.lang.Math;

class Solution {
    int MAX = 100000001 ;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        int[][] arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            Arrays.fill(arr[i], MAX);
           arr[i][i] = 0; 
        }
        for(int i=0;i<fares.length;i++)
        {
            arr[fares[i][0]][fares[i][1]] = fares[i][2];
            arr[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                for(int k=1;k<=n;k++)
                {
                    arr[j][k] = Math.min(arr[j][i]+arr[i][k], arr[j][k]);
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            answer = Math.min(answer, arr[s][i] + arr[i][a] + arr[i][b]);
        }
        return answer;
    }
    

}