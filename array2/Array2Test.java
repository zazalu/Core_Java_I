package array2;

public class Array2Test{
    public static void main(String[] args)
    {
        int[] scores1 = new int[10];
        int[][] scores2;
        String[][] names;
        scores2 = new int[][]{
            {1,2,3},
            {3,4,5},
            {6}
        };
        names = new String[6][5];  // 动态创建数组初始化方式一
        names = new String[6][0];   // 方式二
        names[0] = new String[5];
        names[1] = new String[4];
        names[2] = new String[3];
        names[3] = new String[2];
        names[4] = new String[6];
        names[5] = new String[7];
        
        int[][] i = new int[3][2]; // int[] i[] = new int[3][2];
        
        i[1][0] = 90; //fuzhi
        i[2][1] = 100;
        
        System.out.println(i.length); // 3
        System.out.println(i[0].length); // 2
        System.out.println(names.length); // 6
        System.out.println(names[4].length); //8
        
        for(int m = 0; m < scores2.length; m++){
            for(int n = 0; n < scores2[m].length;n++){
                System.out.print(scores2[m][n] + "    ");
            }
            System.out.println();
        }
    }
}