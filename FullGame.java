public class FullGame
{
    //Attributes
    private WordGuessingGame wordGuessingGame;
    private InputReader reader;

    public FullGame()
    {
        wordGuessingGame = new WordGuessingGame();
        reader = new InputReader();
    }

    public void play(){
        wordGuessingGame.play();
        char answer = reader.getChar("Do you want to play again? (y/n)?");
        if (Character.toLowerCase(answer) == 'y'){
            wordGuessingGame.reset();
            play();
        }
        System.out.println("Thank you for playing!");
        return;
    }
}
