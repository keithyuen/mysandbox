package challenges.solutions;

import java.util.HashMap;
import java.util.Stack;

public class mySolution {

    // 5.3 Flip at most one bit 0 to 1 and find the longest sequence of 1s in a binary.
    public int filpBit (int a) {
        if(~a == 0) return Integer.BYTES * 8;

        int currLength = 0;
        int prevLength = 0;
        int maxLength = 1; // there exist at least 1 one

        while (a != 0) {
            if ((a & 1) == 1) {
                currLength++;
            } else if ((a & 1) == 0) {
                // check if the next bit is also 0.
                // if it's also 0, then reset the previous and current length
                // if it's not, we can flip this bit and keep track of the length
                prevLength = (a & 2) == 0? 0 : currLength;
                currLength = 0;
            }
            maxLength = Math.max(prevLength+currLength+1,maxLength);
            a >>>= 1;
        }
        return maxLength;
    }

    //  5.2 Non-integer binary to String
    public String printBinary (double num) {
        if (num >= 1 || num <= 0)
            return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append("0.");
        while (num > 0) {
            /* set a limit on length 32 */
            if(binary.length() >= 32) {
                break;
            }

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }


    public boolean isPalindrome(String text) {

        // Idea here is to take string and stick it in a Stack.
        // Then, depending on whether the string has an old or even length,
        // pop the letters off one stack and push them into another.
        // Once we hit out mid point, we can then pop them off together and see
        // if they match. So long as they do, we potentially have a palindrome.
        // As soon as they don't, we will know we won't.

        Stack<String> original = new Stack<String>();
        Stack<String> reverse = new Stack<String>();

        // build original stack
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            String letterAsString = String.valueOf(letter);
            original.push(letterAsString);
        }

        int midPoint = 0;
        midPoint = text.length() / 2;

        // collect and pop half of them off
        for (int i = 0; i < midPoint; i++) {
            reverse.push(original.pop());
        }

        // pop off middle letter due to odd length string
        if (text.length() % 2 != 0) {
            original.pop();
            System.out.println("Odd...");
        }

        // compare
        for (int i = 0; i < midPoint; i++) {
            String orig = original.pop();
            String rev = reverse.pop();
            System.out.println(i + " " + orig + " " + rev);
            if (!orig.equals(rev)) {
                return false;
            }
        }

        return true;
    }

}
