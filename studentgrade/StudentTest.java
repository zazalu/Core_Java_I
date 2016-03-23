package studentgrade;

import java.util.*;

public class StudentTest{
    public static void main(String[] args)
    {
        System.out.println("请输入学生人数：");
        Scanner s = new Scanner(System.in);
        int stu_cout = s.nextInt();
        System.out.println("请输入学生成绩");
        int[] scores = new int[stu_cout];
        int max = 0;
        for(int i = 0; i < scores.length; i++)
        {
            int score = s.nextInt();
            scores[i] = score;
            if(scores[i] > max)
            {
                max = scores[i];
            }
            System.out.println();
        }
        
        System.out.println("最高分是：" + max);
        System.out.println();
        
        for(int i = 0;i < scores.length;i++)
        {
            if(scores[i] >= (max - 10))
            {
                System.out.println("student" + i + " score is " + scores[i] + " grade is A");
            }else if(scores[i] >= (max - 20) && scores[i] < (max - 10))
            {
                System.out.println("student" + i + " score is " + scores[i] + "grade is B");
            }else if(scores[i] >= (max - 30) && scores[i] < (max - 20))
            {
                System.out.println("student" + i + " score is " + scores[i] + "grade is C");
            }else{
                System.out.println("student" + i + " score is " + scores[i] + "grade is D");
            }
            
        }
        
    }
}