package yanghui;

public class TestYanghui{
    public static void main(String[] args){
        int[][] yang = new int[10][];
        for(int i = 0;i < yang.length; i++){
            yang[i] = new int[i+1];
            yang[i][0] = 1;
            yang[i][i] = 1;
        }
        for(int i = 2;i < yang.length;i++){
            for(int j = 1;j < (yang[i].length - 1);j++){
                yang[i][j] = yang[i-1][j-1] + yang[i-1][j];
            }
        }
        
        for(int i = 0;i < yang.length;i++){
            for(int j = 0;j < yang[i].length;j++){
                System.out.print(yang[i][j] + "   ");
            }
            System.out.println();
        }
    }
}