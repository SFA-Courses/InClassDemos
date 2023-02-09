import javax.lang.model.util.ElementScanner14;

public class TestReview {
    private static int recursiveF(int n) {
        if (n==0)
            return 1;
        else if (n == 1) 
            return 3;
        else 
            return 3*recursiveF(n-2) + 1;
    }

    private static int recursiveG(int n) {
        if (n == 0)
            return -1;
        else if (n==1)
            return 2;
        else 
            return recursiveG(n-1) - recursiveG(n-2);
    }

    private static int iterationG(int n) {
        if (n==0)
            return -1;
        else if(n==1)
            return 2;
        
        int prev0 = -1;
        int prev1 = 2;
        int next = 0;
        for (int i = 2; i <=n; i++) {
            next = prev1 - prev0;
            prev0 = prev1;
            prev1 = next; 
        }
        return next; 

    }


    public static void main(String[] args) {
        System.out.println(iterationG(100000));
    }
}
