package learn.the.part;

import java.util.Scanner;

public class Main {
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"
    };

    public static void main(String[] args) {
        // instantiate scanner
        Scanner scan = new Scanner(System.in);

        // Select word
        int random = (int)(Math.random() * (words.length - 1));
        String word = words[random];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("_");
        }
        String placeholders = sb.toString();

        // Print board
        boolean running = true;
        int gallow = 0;
        String misses = "";

        while(running){
            System.out.println("\n" + gallows[gallow]);
            System.out.println("Word: " + placeholders);
            System.out.println("Misses: " + misses);
            System.out.print("Guess: ");
            char guess = scan.next().charAt(0);

            boolean match = false;
            for (int i = 0; i < word.length(); i++) {
                if (guess == word.charAt(i)){
                    placeholders = placeholders.substring(0, i) + guess + placeholders.substring(i + 1);
                    match = true;
                }
            }
            if (!match){
                gallow++;
                misses += guess;
            } else if (placeholders.equalsIgnoreCase(word)) {
                running = false;
                System.out.println("\nThe word was \"" + word + "\"");
                System.out.println("You won :)");
            } else if (gallow == 5){
                running = false;
                System.out.println("\nThe word was \"" + word + "\"");
                System.out.println("You lose :(");
            }
        }
    }
}
