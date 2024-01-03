package SortingAlgo;

//Reversing words in an array containing characters, eg. "Sky Blue" to "Blue Sky"
public class ReverseWords {
    public static void main(String[] args)
    {
        char[] words = {'b','l','u','e',' ','s','k','y'};

        reverseWords(words);
        reverseIndividualWords(words);
        System.out.println(words);
    }

    public static void reverseWords(char[] words)
    {
        reverseAllCharacters(0, words.length-1, words);
    }

    public static void reverseAllCharacters(int i, int j, char[] words)
    {
        while(i<j)
        {
            //swapCharacters(i++,j--,words) 'this code works too'
            swapCharacters(i, j, words);
            i++;
            j--;
        }
    }

    public static void swapCharacters(int i, int j, char[] words)
    {
        char temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public static void reverseIndividualWords(char[] words)
    {
        int leftPointer = 0;
        int rightPointer = words.length;

        for(int i = 0; i<words.length; i++)
        {
            //This checking is to make sure the pointer moves to the rightmost character of the word
            if(words[i] != ' ' && (i == rightPointer - 1 || words[i+1] == ' '))
            {
                reverseAllCharacters(leftPointer, i, words);
                //Move the pointer to the starting character of the next word
                leftPointer = i + 2;
            }
        }
    }
}
