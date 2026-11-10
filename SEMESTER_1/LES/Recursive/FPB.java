package SEMESTER_1.LES.Recursive;

public class FPB {

    public static int gcd(int a, int b)
    {
        System.out.println(a + " - " + b);
        if(b == 0)
        {
            return a;
        }
        else {
            return gcd(b,a % b);
        }
    }

    public static int FPBRecursive(int[] arr,int n)
    {
        if(n == 0)
        {
            return arr[0];
        }
        else
        {
            return gcd(arr[n],FPBRecursive(arr,n-1));
        }
    }
    public static void main(String[] args) {
        int[] arr = {12,80,100,72};

        int Batas = 4;

        System.out.println(FPBRecursive(arr,Batas-1));
    }
}
