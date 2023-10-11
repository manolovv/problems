package book1.Strings;

public class Protocol {
    public static void main(String[] args) {

        // Write a program that parses an URL in following format:
        //[protocol]://[server]/[resource]
        //
        //It should extract from the URL the protocol, server and resource parts.
        // For example, when http://www.devbg.org/forum/index.php is passed, the result is:
        //
        //[protocol]="http"
        //[server]="www.devbg.org"
        //[resource]="/forum/index.php"

        String url = "http://www.devbg.org/forum/index.php";

        int takeProtocolIndx = url.indexOf("//");
        String takeProtocolText = url.substring(0, takeProtocolIndx - 1);

        int startServIndx = takeProtocolIndx + 2;
        int endServIndx = url.indexOf("/", startServIndx);
        String takeServerText = url.substring(startServIndx, endServIndx);

        int startResourceIndx = endServIndx;
        String takeResourceText = url.substring(startResourceIndx);

        System.out.printf("[protocol]= %s%n[server]= %s%n[resource]= %s", takeProtocolText, takeServerText, takeResourceText);

    }
}
