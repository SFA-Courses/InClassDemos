public class Recursion {
    private static int[] intArray =  {23, 34, 45, 56, 67, 78};
    public static void main(String[] args) {
        System.out.println(maxByHead(0));
       // int sum = 0;
       // System.out.println(sumByTail(0, sum));
    }
    public static int maxByHead(int index) {
        if (index == intArray.length-1) 
            return intArray[index];
        else {
            return Math.max(intArray[index], maxByHead(index+1));
        }
    }
    public static int sumByHead(int index) {
        if (index == intArray.length-1) {
            return intArray[index];        
        }
        else {
            return intArray[index] + sumByHead(index+1);
        }
    }

    public static int sumByTail(int index, int sum) {
        if (index == intArray.length-1)
            return sum + intArray[index];
        else 
            return sumByTail(index+1, sum+intArray[index]);
    }
    public static void tail(int n) {
        if (n >= 1) {            
            System.out.println(n);
            tail(n-1);
        }
    }

    public static void head(int n) {
        if (n >= 1) {
            head(n-1);
            System.out.println(n);
        }
    }
    public static int fib(int n) {
        if (n==0)
            return 1;
        else if (n==1)
            return 1;
        else 
            return fib(n-2) + fib(n-1);
    }
    public static int factorial(int n) {
        if (n == 0) 
            return 1;
        else
            return n * factorial(n-1);
    }

    public static int sum(int n) {
        if (n==1)
            return 1;
        else
            return n + sum(n-1);
    }
}