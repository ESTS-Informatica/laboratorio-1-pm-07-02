public class WordGuessingGame {
    // Attributes
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    private WordGenerator wordGenerator;

    // Constructors
    public WordGuessingGame() {
        wordGenerator = new WordGenerator();
        reader = new InputReader();

        hiddenWord = wordGenerator.generateWord();
        initializeGuessedWord();
        numberOfTries = 0;
    }

    // Methods
    public void play() {
        showWelcome();
        while (!hiddenWord.equals(guessedWord)) {
            showGuessedWord();
            System.out.println();
            char letter = reader.getChar("Enter a letter: ");
            guess(letter);
        }

        showResult();
    }

    private void initializeGuessedWord() {
        guessedWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            guessedWord += "_";
        }
    }

    private void showWelcome() {
        System.out.println("Welcome to the Word Guessing Game!");
    }

    private void guess(char letter) {
        boolean correctGuess = false;

        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                guessedWord = guessedWord.substring(0, i) + letter + guessedWord.substring(i + 1);
                correctGuess = true;
            }
        }

        if (correctGuess) {
            System.out.println("Correct! " + guessedWord);
        } else {
            System.out.println("Incorrect!");
        }
        numberOfTries++;
    }

    private void showResult() {
        System.out.println("Congratulations! You guessed the word!");
        System.out.println("The word is: " + hiddenWord);
        System.out.println("Tries: " + getNumberOfTries());
    }

    // Selectors
    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    private void showGuessedWord() {
        System.out.print(guessedWord);
    }

    public void reset() {
        hiddenWord = wordGenerator.generateWord();
        initializeGuessedWord();
        numberOfTries = 0;
    }
}