package book1.Strings;

import java.util.Arrays;

public class ExtractTheText {
    public static void main(String[] args) {

        // Write a program that extracts all the text without any tags and attribute values from an HTML document.
        //Sample text:
        //
        //<html>
        //    <head><title>News</title></head>
        //    <body><p><a href="https://softuni.bg">Telerik
        //        Academy</a>aims to provide free real-world practical
        //        training for young people who want to turn into
        //        skillful software engineers.</p></body>
        //</html>
        //
        //Sample result:
        // News
        //Telerik Academy aims to provide free real-world practical training for young people who want to turn into skillful software engineers.

        String text = "<html>\n" +
                "\n" +
                "    <head><title>News</title></head>\n" +
                "\n" +
                "    <body><p><a href=\"https://softuni.bg\">Telerik\n" +
                "\n" +
                "        Academy</a>aims to provide free real-world practical\n" +
                "\n" +
                "        training for young people who want to turn into\n" +
                "\n" +
                "        skillful software engineers.</p></body>\n" +
                "\n" +
                "</html>";


        StringBuilder result = new StringBuilder(text.length());

        int k = 0;
        while (k < text.length()) {

            int start = text.indexOf("<", k);
            result.append(text.substring(k, start));

            int end = text.indexOf(">", k);
            k = end + 1;
        }
        String printResult = result.toString();
        System.out.println(printResult.trim());
    }
}
