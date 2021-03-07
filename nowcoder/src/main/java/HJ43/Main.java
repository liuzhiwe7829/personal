package HJ43;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/617:53
 */
public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
             int n,m;
             int [][] map = new int[0][];
            n = in.nextInt();
            m = in.nextInt();

            for(int i = 0; i<n;i++){
                for(int j = 0;j <m;j++){
                    map[i][j]= in.nextInt();
                }
            }
            dfs(0,0,n,m,map);
//            display(0,0);
        }
    }

    private static void dfs(int x, int y,int n ,int m,int[][] map) {
        //递归终止条件
        if(x==n-1 && y==m-1){
            return;
        }
        //向下
        if(x+1<n){
            if(map[x+1][y]!=1){
                dfs(x+1,y);
            }
        }
        //向右
        if(y+1<m){
            if(map[x][y+1]!=1){
                dfs(x,y+1);
            }
        }
        //不能向下并且不能向右 ---- 倒数第二行 且
        if(x+1==n&& map[x][y+1]==1){
            map[x][y]=1;
        }
        //不能向下也不能向右，也不在终点
        if(x+1!=n&&y+1!=m){
            if(map[x+1][y]==1&& map[x][y+1]==1){
                map[x][y]=1;
            }
        }
    }

    private static void dfs(int i, int j) {
    }
}
