import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HangMan {

    private static final String[] WORDS = {"java", "programming", "computer", "algorithm", "software", "developer"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        // Takes in account the length of words array, and randomly generates the index of the word to choose from the array.
        String wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        Map<Character, Boolean> guessedLetters = new HashMap<>();
        char[] letterArr = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int tries = 0;
        boolean wordGuessed = false;

        // Populating Map with every letter initially false
        for (int i = 0; i < 26; i++) {
            guessedLetters.put(letterArr[i], false);
        }

        // Initialize guessedWord with dashes
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Hangman!");

        while (!wordGuessed && tries < MAX_TRIES) {
            System.out.println("\nCurrent word: " + new String(guessedWord));
            System.out.println("Tries left: " + (MAX_TRIES - tries));
            System.out.print("Enter a letter: ");
            String guessString = keyboard.nextLine();
            char guess = guessString.toLowerCase().charAt(0);

            if (guessString.equals(wordToGuess)) {
                wordGuessed = true;
            }
            if (!guessString.equals(wordToGuess) && guessString.length() > 1) {
                System.out.println("Please guess one letter at a time unless you're ready to guess the full word. ");
                continue;
            }

            if (guessedLetters.get(guess)) {
                System.out.println("You've already guessed this letter. Try another one.");
            }

            guessedLetters.put(guess, true);
            boolean found = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                tries++;
                System.out.println("Incorrect guess.");
            }

            if (wordToGuess.equals(new String(guessedWord))) {
                wordGuessed = true;
            }

        }

        if (wordGuessed) {
            System.out.println("\nCongratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nSorry, you've run out of tries. The word was: " + wordToGuess);
        }
    }
}