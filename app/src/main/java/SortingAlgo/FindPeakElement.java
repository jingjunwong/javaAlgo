package SortingAlgo;

//Given an array of integers, return index and value of peak elements (peak element is those that are greater of its neighbors)
//If there are multiple peaks, can return any of it
//Constraints: the neighbors are not the same value, otherwise it is infinite looping
public class FindPeakElement {
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,555,66,7};

        int res1 = findPeakBruteForce(nums);
        System.out.println("Brute Force Method (unoptimized): "+res1);

        int res2 = findPeakOptimized(nums);
        System.out.println("Optimized Search Method: "+res2);
    }

    public static int findPeakBruteForce(int[] arrayNum)
    {
        int res = 0;
        for(int i=1; i<arrayNum.length - 1; i++)
        {
            if(arrayNum[i-1] < arrayNum[i] && arrayNum[i] > arrayNum[i+1])
            {
                res = i;
            }
        }
        return res;
    }

    public static int findPeakOptimized(int[] arrayNum)
    {
        int left = 0;
        int right = arrayNum.length-1;

        while(left<right)
        {
            //If put (left+(right-left))/2, there appears to be infinite looping (need to find out why)
            int mid = left + (right-left) / 2;
            
            if(arrayNum[mid] > arrayNum[mid+1])
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }
}
