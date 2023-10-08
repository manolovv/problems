package book1.Strings;

import java.util.Scanner;

public class CaseRegister {
    public static void main(String[] args) {

        //A text is given. Write a program that modifies the casing of letters to uppercase at all places
        // in the text surrounded by <upcase> and </upcase> tags. Tags cannot be nested.

        //Example:
        //"We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.";

        // Result:
        //We are living in a YELLOW SUBMARINE. We don't have ANYTHING else.

        String text = "We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.";

        StringBuilder sb = new StringBuilder();

        int k = 0;
        while (k < text.length()) {

            int start = text.indexOf("<upcase>", k);
            if (start < 0) {
                sb.append(text.substring(k));
                break;
            }
            sb.append(text.substring(k, start));
            k = start + 8;

            int end = text.indexOf("</upcase>", k);
            if (end < 0) {
                sb.append(text.substring(k));
                break;
            }
            sb.append(text.substring(k, end).toUpperCase());
            k = end + 9;
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
