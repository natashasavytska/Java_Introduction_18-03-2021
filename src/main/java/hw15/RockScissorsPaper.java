package hw15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static hw15.GameChoices.*;

public class RockScissorsPaper {

    static Map<GameChoices, GameChoices> beats = new HashMap<>();

    static {
        beats.put(PAPER, ROCK);
        beats.put(ROCK, SCISSORS);
        beats.put(SCISSORS, PAPER);
    }

    public static void main(String[] args) {

        User computer = new User("Computer");
        User user = createPlayerProfile();
        int numberOfGames = chooseNumberOfGames(user);
        playGame(numberOfGames, user, computer);
        writeFinalResults(user, computer);
    }

    private static User createPlayerProfile() {
        System.out.println("Hello! What is your name?");
        Scanner sc = new Scanner(System.in);
        String nameOfPlayer = sc.next();
        return new User(nameOfPlayer);
    }

    private static int chooseNumberOfGames(User user) {
        System.out.println(user.name + ", lets play rock paper scissors.");
        try {
            System.out.println("How many games do you want to play?");
            Scanner sc1 = new Scanner(System.in);
            return sc1.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Please, write the number of games you want to play.");
            return chooseNumberOfGames(user);
        }
    }

    private static GameChoices generationOfComputerChoice() {
        Map<Integer, GameChoices> gameChoices = new HashMap<>();
        gameChoices.put(1, ROCK);
        gameChoices.put(2, SCISSORS);
        gameChoices.put(3, PAPER);
        int computer_choice = (int) (Math.random() * (3 - 1 + 1) + 1);
        return gameChoices.get(computer_choice);
    }

    private static GameChoices userMakesChoice() throws IllegalArgumentException {

        try {
            System.out.println("Pick: \n * rock \n * scissors  \n * paper.");
            Scanner sc2 = new Scanner(System.in);
            return valueOf(sc2.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Please, choose one of the variants below!");
            return userMakesChoice();
        }
    }

    private static void playGame(int numberOfGames, User user, User computer) {
        for (int i = 0; i < numberOfGames; i++) {
            GameChoices userChoice = userMakesChoice();
            System.out.println("Your choice is: " + userChoice);
            GameChoices computerChoice = generationOfComputerChoice();
            System.out.println("Computer's choice is: " + computerChoice);
            findOneGameResult(userChoice, computerChoice, user, computer);

            if (i < numberOfGames - 1) {
                if (doYouWantToContinue() == 0)
                    break;
            }
        }
    }

    private static int doYouWantToContinue() throws IncorrectAnswer {
        System.out.println("Do you want to continue? (1 - yes, 0 - no)");
        try {
            Scanner sc2 = new Scanner(System.in);
            int answer = sc2.nextInt();
            if (answer < 0 || answer > 1) {
                throw new IncorrectAnswer();
            }
            return answer;
        } catch (IncorrectAnswer | InputMismatchException e) {
            System.out.println("Please, choose 1 for YES or 0 for NO");
            return doYouWantToContinue();
        }
    }

    private static void findOneGameResult(GameChoices userChoice, GameChoices computerChoice, User user, User
            computer) {
        if (userChoice == computerChoice) {
            System.out.println("Its a tie");
        } else if (beats.get(userChoice) == computerChoice) {
            System.out.println("You've won");
            user.score++;
        } else {
            System.out.println("You've lost");
            computer.score++;
        }

    }

    private static void writeFinalResults(User user, User computer) {
        System.out.println("========== Game result ==========");
        System.out.println("Computer score: " + computer.score);
        System.out.println(user.name + "'s score: " + user.score);

        if (computer.score > user.score) {
            System.out.println("Computer win!");
        } else if (user.score > computer.score) {
            System.out.println(user.name + " win!");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
