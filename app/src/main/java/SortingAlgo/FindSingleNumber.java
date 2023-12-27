package SortingAlgo;

import java.util.ArrayList;
//FIND THE SINGLE NUMBER IF EVERY ELEMENT APPEARS TWICE EXCEPT FOR ONE (technically can be multiples of two, otherwise the XOR function doesnt work)
public class FindSingleNumber {
    public static void main(String[] args)
    {
        //Find a non duplicate number in the array, 1 in this case
        int[] anArray = {1,2,2,3,3,4,4};

        int finalNum = findUsingXOR(anArray);
        int finalNum2 = findUsingArrayList(anArray);
        System.out.println("The answer is (using XOR): "+finalNum);
        System.out.println("The answer is (using ArrayList): "+finalNum2);
    }

    //Using the XOR function to compare the binary representative of the integer
    //This function ONLY works if the multiple values in the array are in the multiples of 2
    public static int findUsingXOR(int[] a)
    {
        int res = 0;

        for(int x: a)
        {
            res = res ^ x;
        }

        return res;
    }

    public static int findUsingArrayList(int[] a)
    {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int x: a)
        {
            nums.add(x);
        }

        for(int i=0; i<nums.size(); i++)
        {
            int temp = nums.get(i);
            for(int j=0; j<nums.size(); j++)
            {
                int count = 0;
                if(temp == nums.get(j))
                {
                    count++;
                }
                //wrong here
                if(count>1)
                {
                    int valueToRemove = nums.get(j);
                    for(int k=0; k<nums.size(); k++)
                    {
                        if(nums.get(k) == valueToRemove)
                        {
                            nums.remove(k);
                        }
                    }
                }
            }
        }

        if(nums.size() != 1)
        {
            System.out.println("Something went wrong!");
            System.out.println(nums);
        }
        int res = nums.get(0);

        return res;
    }
}
