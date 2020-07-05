public class RecursiveStaircaseProblem {

    static int getNumberOfSteps(int n){

        if (n==0 || n==1) {
            return 1;
        } else {
           int[] nums = new int[n+1];
           nums[0] = 1;
           nums[1] = 1;
           for (int i=2 ; i <= n ; i++){
               nums[i] = nums[i-1] + nums[i-2];
           }
            return nums[n];
        }
    }

    static int getNumberOfSteps(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<=n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        return res[n-1];
    }

    // Returns number of ways to reach s'th stair
    static int getNumberOfStepsGeneric(int s, int m)
    {
        return getNumberOfSteps(s+1, m);
    }

    public static void main (String args[])
    {
        int s = 4;
        System.out.println("Number of ways = "+ getNumberOfSteps(s));
        System.out.println("Number of ways = "+ getNumberOfStepsGeneric(s,3));
    }
}
