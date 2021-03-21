package Offer._29;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int left=0 ,right=matrix[0].length-1,top=0 ,bottom=matrix.length-1;
        int [] res =new int [(right+1)*(bottom+1)] ;
        int index = 0;
        while(true){
            //lefg ->righ
            for(int i = left ;i<=right;i++){
                res[index++] = matrix[top][i];
            }
            if(++top>bottom) {
                break;
            }
            //top->bottom
            for(int i = top; i<=bottom;i++){
                res[index++] =matrix[i][right];
            }
            if(--right<left){
                break;
            }
            //right->left
            for(int i = right; i>=left;i--){
                res[index++] =matrix[bottom][i];
            }
            if(--bottom<top){
                break;
            }
            //bottom->top
            for(int i = bottom; i>=top;i--){
                res[index++] =matrix[i][left];
            }
            if(++left>right){
                break;
            }
        }
        return  res;
    }
}