import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HangMan {

    private static final String API_BASE_URL = "https://random-word-api.herokuapp.com/word";
    private static final RestTemplate restTemplate = new RestTemplate();
    //private static final String[] WORDS = {"java", "programming", "computer", "algorithm", "software", "developer"};
    private static final int MAX_TRIES = 6;

    private static final Scanner keyboard = new Scanner(System.in);
    // Takes in account the length of words array, and randomly generates the index of the word to choose from the array.
    private static String wordToGuess = "test";
    private static Map<Character, Boolean> guessedLetters = new HashMap<>();
    private static final char[] letterArr = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static int tries = 0;
    private static boolean wordGuessed = false;

    public static void main(String[] args) {
        HangMan.gameLogic();
    }

    public static void gameLogic() {

        char[] guessedWord;
        boolean gameOver;
        String word;

        //Old Way
        //wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];

        //API Way
        try {
            word = restTemplate.getForObject(API_BASE_URL, String.class);
            if (word != null) {
                wordToGuess = word.substring(2, word.length() - 2);
            }
        } catch (RestClientResponseException e) {
            System.out.println(e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        guessedWord = new char[wordToGuess.length()];

        // Populating Map with every letter initially false
        for (int i = 0; i < 26; i++) {
            guessedLetters.put(letterArr[i], false);
        }

        // Initialize guessedWord with dashes
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '_';
        }

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("          Welcome to Hangman!          ");
        System.out.println("---------------------------------------");
        System.out.println();

        while (tries < MAX_TRIES) {

            gameOver = false;

            if (tries == 5) {
                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||             ^^^^^");
                System.out.println("         ||            ( 0_0 )");
                System.out.println("         ||              | |");
                System.out.println("         ||          (-       -)");
                System.out.println("         ||          | |     | |");
                System.out.println("         ||          | |     | |");
                System.out.println("         ||          ( )=====( )");
                System.out.println("         ||            | |");
                System.out.println("         ||            | |");
                System.out.println("         ||            | |");
                System.out.println("         ||            | |");
                System.out.println("         ||            (_)");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
            } else if (tries == 4) {
                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||             ^^^^^");
                System.out.println("         ||            ( 0_0 )");
                System.out.println("         ||              | |");
                System.out.println("         ||          (-       -)");
                System.out.println("         ||          | |     | |");
                System.out.println("         ||          | |     | |");
                System.out.println("         ||          ( )=====( )");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
            } else if (tries == 3) {
                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||             ^^^^^");
                System.out.println("         ||            ( 0_0 )");
                System.out.println("         ||              | |");
                System.out.println("         ||          (-      |");
                System.out.println("         ||          | |     |");
                System.out.println("         ||          | |     |");
                System.out.println("         ||          ( )=====(");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
            } else if (tries == 2) {
                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||             ^^^^^");
                System.out.println("         ||            ( 0_0 )");
                System.out.println("         ||              | |");
                System.out.println("         ||            |     |");
                System.out.println("         ||            |     |");
                System.out.println("         ||            |     |");
                System.out.println("         ||            )=====(");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
            } else if (tries == 1) {
                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||             ^^^^^");
                System.out.println("         ||            ( 0_0 )");
                System.out.println("         ||              | |");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
            } else {
                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
            }

            System.out.println("\nCurrent word: " + new String(guessedWord));
            System.out.println("Tries left: " + (MAX_TRIES - tries));
            System.out.print("Enter a letter: ");
            String guessString = keyboard.nextLine();
            System.out.println();
            char guess;

            if (!guessString.isEmpty()) {
                guess = guessString.toLowerCase().charAt(0);
                boolean validLetter = false;
                for (char c : letterArr) {
                    if (guess == c) {
                        validLetter = true;
                        break;
                    }
                }

                if (!validLetter) {
                    System.out.println("Please enter a valid letter.\n");
                    continue;
                }
            } else {
                System.out.println("\nPlease guess a letter or the entire word.\n");
                continue;
            }

            if (guessString.equals(wordToGuess)) {
                wordGuessed = true;
            }

            if (guessedLetters.get(guess) && !guessString.equals(wordToGuess) && guessString.length() == 1) {
                System.out.println("You've already guessed this letter. Try another one.\n");
            }

            boolean found = false;

            if (!guessString.equals(wordToGuess) && guessString.length() > 1) {
                System.out.println("Please guess one letter at a time unless you're ready to guess the full word.");
            } else {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        found = true;
                    }
                }
            }

            if (!found && !guessedLetters.get(guess)) {
                tries++;
                System.out.println();
                System.out.println("Incorrect guess.");
                System.out.println();
            }

            guessedLetters.put(guess, true);

            if (wordToGuess.equals(new String(guessedWord))) {
                wordGuessed = true;
            }

            if (wordGuessed) {

                // Populating Map with every letter initially false
                for (int i = 0; i < 26; i++) {
                    guessedLetters.put(letterArr[i], false);
                }

                // Initialize guessedWord with dashes
                for (int i = 0; i < wordToGuess.length(); i++) {
                    guessedWord[i] = '_';
                }

                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);

                while (!gameOver) {
                    System.out.print("\nWould you like to play again? (Y/N): ");

                    String choice = keyboard.nextLine();

                    if (choice.equalsIgnoreCase("Y")) {
                        wordGuessed = false;
                        tries = 0;
                        guessedLetters = new HashMap<>();

                        //Old Way
                        //wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];

                        //API Way
                        try {
                            word = restTemplate.getForObject(API_BASE_URL, String.class);
                            if (word != null) {
                                wordToGuess = word.substring(2, word.length() - 2);
                            }
                        } catch (RestClientResponseException e) {
                            System.out.println(e.getStatusText());
                        } catch (ResourceAccessException e) {
                            System.out.println(e.getMessage());
                        }

                        guessedWord = new char[wordToGuess.length()];

                        // Populating Map with every letter initially false
                        for (int i = 0; i < 26; i++) {
                            guessedLetters.put(letterArr[i], false);
                        }

                        // Initialize guessedWord with dashes
                        for (int i = 0; i < wordToGuess.length(); i++) {
                            guessedWord[i] = '_';
                        }

                        System.out.println();
                        gameOver = true;
                    } else if (choice.equalsIgnoreCase("N")) {
                        System.out.println("\nThank you for playing!");
                        System.exit(0);
                    } else {
                        System.out.println("Please enter 'Y' or 'N' to make a choice.");
                    }
                }

            } else if (tries == 6) {
                tries = 0;
                guessedLetters = new HashMap<>();

                //Old Way
                //wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];

                System.out.println("         -------------------");
                System.out.println("         -------------------");
                System.out.println("         ||               |");
                System.out.println("         ||               |");
                System.out.println("         ||             ^^^^^");
                System.out.println("         ||            ( 0_0 )");
                System.out.println("         ||              | |");
                System.out.println("         ||          (-       -)");
                System.out.println("         ||          | |     | |");
                System.out.println("         ||          | |     | |");
                System.out.println("         ||          ( )=====( )");
                System.out.println("         ||            | |  | |");
                System.out.println("         ||            | |  | |");
                System.out.println("         ||            | |  | |");
                System.out.println("         ||            | |  | |");
                System.out.println("         ||            (_)  (_)");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("------------------");
                System.out.println("------------------");
                System.out.println("\nSorry, you've run out of tries. The word was: " + wordToGuess);

                while (!gameOver) {
                    System.out.print("\nWould you like to play again? (Y/N): ");

                    String choice = keyboard.nextLine();

                    if (choice.equalsIgnoreCase("Y")) {
                        // Populating Map with every letter initially false

                        //API Way
                        try {
                            word = restTemplate.getForObject(API_BASE_URL, String.class);
                            if (word != null) {
                                wordToGuess = word.substring(2, word.length() - 2);
                            }
                        } catch (RestClientResponseException e) {
                            System.out.println(e.getStatusText());
                        } catch (ResourceAccessException e) {
                            System.out.println(e.getMessage());
                        }

                        guessedWord = new char[wordToGuess.length()];

                        for (int i = 0; i < 26; i++) {
                            guessedLetters.put(letterArr[i], false);
                        }

                        // Initialize guessedWord with dashes
                        for (int i = 0; i < wordToGuess.length(); i++) {
                            guessedWord[i] = '_';
                        }

                        gameOver = true;

                    } else if (choice.equalsIgnoreCase("N")) {
                        System.out.println("\nThank you for playing!");
                        System.exit(0);
                    } else {
                        System.out.println("Please enter 'Y' or 'N' to make a choice.");
                    }
                }
            }
        }
    }
}