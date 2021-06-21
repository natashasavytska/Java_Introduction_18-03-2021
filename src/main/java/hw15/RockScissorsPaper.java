package hw15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static hw15.GameChoices.*;

public class RockScissorsPaper {

    private static final Map<GameChoices, GameChoices> BEATS = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static {
        BEATS.put(PAPER, ROCK);
        BEATS.put(ROCK, SCISSORS);
        BEATS.put(SCISSORS, PAPER);
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
        String nameOfPlayer = sc.next();
        return new User(nameOfPlayer);
    }

    private static int chooseNumberOfGames(User user) {
        System.out.println(user.getName() + ", lets play rock paper scissors.");
        try {
            System.out.println("How many games do you want to play?");
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please, write the number of games you want to play.");
            return chooseNumberOfGames(user);
        }
    }

    private static GameChoices generationOfComputerChoice() {
        Map<Integer, GameChoices> gameChoices = new HashMap<>();
        gameChoices.put(1, ROCK);
        gameChoices.put(2, SCISSORS);
        gameChoices.put(3, PAPER);
        int computerChoice = (int) (Math.random() * (3 - 1 + 1) + 1);
        return gameChoices.get(computerChoice);
    }

    private static GameChoices userMakesChoice() throws IllegalArgumentException {

        try {
            System.out.println("Pick: \n * rock \n * scissors  \n * paper.");
            return valueOf(sc.next().toUpperCase());
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
                if (checkToContinue() == 0)
                    break;
            }
        }
    }

    private static int checkToContinue() {
        System.out.println("Do you want to continue? (1 - yes, 0 - no)");
        try {
            int answer = sc.nextInt();
            if (answer < 0 || answer > 1) {
                System.out.println("Please, choose 1 for YES or 0 for NO");
                return checkToContinue();
            }
            return answer;
        } catch (InputMismatchException e) {
            System.out.println("Please, choose 1 for YES or 0 for NO");
            return checkToContinue();
        }
    }

    private static void findOneGameResult(GameChoices userChoice, GameChoices computerChoice,
                                          User user, User computer) {
        if (userChoice == computerChoice) {
            System.out.println("Its a tie");
        } else if (BEATS.get(userChoice) == computerChoice) {
            System.out.println("You've won");
            user.setScore(user.getScore() + 1);
        } else {
            System.out.println("You've lost");
            computer.setScore(computer.getScore() + 1);
        }

    }

    private static void writeFinalResults(User user, User computer) {
        System.out.println("========== Game result ==========");
        System.out.println("Computer score: " + computer.getScore());
        System.out.println(user.getName() + "'s score: " + user.getScore());

        if (computer.getScore() > user.getScore()) {
            System.out.println("Computer win!");
        } else if (user.getScore() > computer.getScore()) {
            System.out.println(user.getName() + " win!");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
