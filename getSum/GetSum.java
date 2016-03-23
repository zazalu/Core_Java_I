package getSum;

public class GetSum{
    public static void main(String[] args){
        int[][] arr = new int[][]{{3,8,2},{2,7},{9,0,1,6}};
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = 0; j < arr[i].length;j++){
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
        
        int[] x,y[]; //x是一维数组 而y是二维的数组
        y = new int[3][2];
        x = y[0]; //ok
        // x[0] = y[0]; false
        
                 
    }
}