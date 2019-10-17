/**
 * A class that analyzes words.
 */
public class WordAnalyzer
{
    /**
     * Constructs an analyzer for a given word.
     * @param aWord the word to be analyzed
     */
    public WordAnalyzer(String aWord)
    {

        word = aWord;
    }

    /**
     * Gets the first repeated character. A character is <i>repeated</i>
     * if it occurs at least twice in adjacent positions. For example,
     * 'l' is repeated in "hollow", but 'o' is not.
     * @return the first repeated character, or 0 if none found
     */
    public char firstRepeatedCharacter()
    {
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            //If we dont find a coincidence, the program will send an exception because we are going out of range.
            if((i+1) == word.length()){
                return 0;
            }else{
                if (ch == word.charAt(i + 1))
                    return ch;
            }

        }
        return 0;
    }

    /**
     * Gets the first multiply occuring character. A character is <i>multiple</i>
     * if it occurs at least twice in the word, not necessarily in adjacent positions.
     * For example, both 'o' and 'l' are multiple in "hollow", but 'h' is not.
     * @return the first repeated character, or 0 if none found
     */


    public char firstMultipleCharacter()
    {
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            /**added a second loop in order to work properly and deleted the =.
             *  Did not make any sense, using the method find()
             * and passing the value of i(which is the position of our character).
             * That is why, the program is returning the first character of the word always.
             * Moreover, in order to use correctly the method, we must look for a coincidence in each position of each
             * character of the word. That is why a second loop is demanded and thus
             * the position j is passed instead of the i position inside the method.
             */

            for(int j=i; j< word.length(); j++){   //second loop
                if (find(ch, j) > i)
                    return ch;
            }
        }
        return 0;
    }

    private int find(char c, int pos)
    {
        for (int i = pos; i < word.length(); i++)
        {
            if (word.charAt(i) == c)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Counts the groups of repeated characters. For example, "mississippi!!!" has
     * four such groups: ss, ss, pp and !!!.
     * @return the number of repeated character groups
     */
    public int countGroupsRepeatedCharacters()
    {
        int c = 0;
        boolean flag = true;
        /**
         * Is not working properly because the for loop begins with i = 1 so it does not take care if there is a
         * repeated character between the first two characters.
         */

        for (int i = 1; i < word.length()-1; i++)
        {
                if (word.charAt(i) == word.charAt(i + 1)) // found a repetition
                    if (word.charAt(i - 1) != word.charAt(i)) // it't the start
                        c++;
            }
        //added a new if for i=0. 
        if(word.charAt(0) == word.charAt(1) && word.charAt(1) != word.charAt(2)){
            c++;
        }

        return c;
    }

    private String word;
}