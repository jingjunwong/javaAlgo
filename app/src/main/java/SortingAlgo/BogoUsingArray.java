/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package SortingAlgo;

import java.util.Random;
import java.util.Arrays;

public class BogoUsingArray {

    //the main code
    public static void main(String[] args) {
        int arrayOfNum[] = {5,1,3,2,6,4};

        System.out.println("Before sort:"+Arrays.toString(arrayOfNum));

        int numOfTries = 0;
        while(isSorted(arrayOfNum) == false)
        {
            numOfTries++;
            System.out.println(Arrays.toString(arrayOfNum));
            shuffle(arrayOfNum);
        }

        System.out.println("After Sort:"+Arrays.toString(arrayOfNum));
        System.out.println("Number of tries: "+numOfTries);

}

//checks if the passed array is sorted properly
//NOTE: i cannot be zero because the index will be [-1]
public static boolean isSorted(int[] anArray)
    {
        for(int i=1; i < anArray.length; i++)
        {
            if(anArray[i] < anArray[i-1])
            {
                return false;
            }
        }
        return true;
    }


//randomly shuffles the passed array by swapping values in random indexes
public static void shuffle(int[] anArray)
{
    Random random = new Random();
    for(int i =0; i<anArray.length; i++)
    {
        int randomIndex = random.nextInt(anArray.length);
        swap(anArray, i, randomIndex);
    }

    
}

//swaps the values in two different indexes
public static void swap(int[] anArray, int i, int j)
{
    int temp = anArray[i];
    anArray[i] = anArray[j];
    anArray[j] = temp;
}
}

