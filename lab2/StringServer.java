import java.io.IOException;
import java.net.URI;


class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String alreadyEntered = "";

    public String handleRequest(URI url) {
        // if the path has the proper syntax for adding messages to the webpage
        if (url.getPath().contains("/add-message?s=")) {
            String[] words = url.getQuery().split("=");
            for (String word : words) {
                alreadyEntered = alreadyEntered + "\n" + word;
            }
            return alreadyEntered;
        } 
        else {
            return "idk bro";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
