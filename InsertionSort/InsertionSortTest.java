package InsertionSort;

import java.util.*;

public class InsertionSortTest{
    public static void main(String[] args){
      
        
        Insertion za_arr = new Insertion();
        za_arr.getNum();
        za_arr.getNums();
        za_arr.getInsertsion();
        System.out.print("是否想继续插入数据呢？^_^(Y or N)");
        Scanner s = new Scanner(System.in);
        char c = s.next().charAt(0);
        if(c == 'Y'){
            za_arr.getInsert();
        }else{
            System.out.println("bye-bye!");
        }
        s.close();
        
        
        // int[] arr = new int[100];
        
        // System.out.print("请输入你要输入多少元素:");
        
        // int num = s.nextInt();
        
        // System.out.println("请输入一串已排序的序列:（由小到大）");
        
        /* for(int i = 1;i <= num;i++){
            arr[i] = s.nextInt();
        }
        
        System.out.println("请输入你要插入的数字");
        arr[0] = s.nextInt();
        */
        /*for(int j = num;j >= 0;j--){
            if(arr[0] >= arr[j]){
                arr[j+1] = arr[0];
                break;
            }else{
                arr[j+1] = arr[j];
            }
        }*/
        
        /*System.out.print("已完成插入排序，现打印：");
        for(int i = 1;i <= (num + 1);i++){
            System.out.print(arr[i] + "    ");
        } */
    }
}

class Insertion{
    //获得数组元素个数
    int num;
    int[] arr;
    Scanner s = new Scanner(System.in);
    
    
    public void getNum(){
        System.out.print("请输入你要输入多少元素:");
        //Scanner s = new Scanner(System.in);
        num = s.nextInt();
    }
    
    //获得用户输入的元素
    public void getNums(){
        arr = new int[100];
        //Scanner s = new Scanner(System.in);
        System.out.println("请输入一串的序列:");
        
        for(int i = 1;i <= num;i++){
            arr[i] = s.nextInt();
        }
        
    }
    //进行插入排序，首次（带排序）
    public void getInsertsion(){
        for(int j = 2;j < (num+1);j++){
            int key = arr[j];
            int i = j - 1;
            while(i > 0 && arr[i] > key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
        System.out.print("已完成插入排序，现打印：");
        for(int i = 1;i <= num;i++){
            System.out.print(arr[i] + "    ");
        } 
    }
    //接受用户的再次插入
    public void getInsert(){
        System.out.println("请输入你要插入的数字");
        arr[0] = s.nextInt();
        for(int j = num;j >= 0;j--){
            if(arr[0] >= arr[j]){
                arr[j+1] = arr[0];
                break;
            }else{
                arr[j+1] = arr[j];
            }
        }
        System.out.print("已完成插入排序，现打印：");
        for(int i = 1;i <= (num + 1);i++){
            System.out.print(arr[i] + "    ");
        } 
    }
    
}