package pritimive;

public class TestPritimive{
    public static void main(String[] args)
    {
        Pritimive d = new Pritimive();
        for(int i = 0;i < d.t.length;i++){
            // d.t[i] = true;
            System.out.println(d.t[i]);
        }
        d.t[0] = true;
        d.t[1] = true;
        d.t[2] = true;
        for(int i = 0;i < d.t.length;i++){
            // d.t[i] = true;
            System.out.println(d.t[i]);
        }
    }
}

class Pritimive{
    boolean[] t = new boolean[3];
}

 