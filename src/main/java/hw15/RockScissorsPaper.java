package hw15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import static hw15.GameChoices.*;

public class RockScissorsPaper {

    private static final Map<GameChoices, GameChoices> BEATS = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    static String baseName = "C:\\Users\\Nataly\\Documents\\Hillel\\Odessa_Java_Introduction" +
            "\\Java_Introduction_homeworks\\src\\main\\java\\hw15";
    static String dirNameForGameResult = baseName + "\\gameResults";
    static String dirNameForGameLogs = baseName + "\\gameLogs";


    static {
        BEATS.put(PAPER, ROCK);
        BEATS.put(ROCK, SCISSORS);
        BEATS.put(SCISSORS, PAPER);
    }

    public static void main(String[] args) throws IOException {

        User computer = new User("Computer");
        User user = createPlayerProfile();

        File dirForGameResult = new File(dirNameForGameResult);
        dirForGameResult.mkdir();
        File dirForGameLogs = new File(dirNameForGameLogs);
        dirForGameLogs.mkdir();
        String fileNameGameResult = "result_" + user.getName().toLowerCase() + "_" +
                new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String createFileGameResult = dirNameForGameResult + "\\" + fileNameGameResult + ".txt";
        File gameResult = new File(createFileGameResult);
        if (!gameResult.exists())
            gameResult.createNewFile();
        OutputStream gameResults = new FileOutputStream(createFileGameResult);
        String fileNameGameLogs = "log_" + user.getName().toLowerCase() + "_" +
                new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String createFileGameLogs = dirNameForGameLogs + "\\" + fileNameGameLogs + ".txt";
        File gameLogsFile = new File(createFileGameLogs);
        if (!gameLogsFile.exists())
            gameLogsFile.createNewFile();
        OutputStream gameLogs = new FileOutputStream(createFileGameLogs, true);

        int numberOfGames = chooseNumberOfGames(user);
        gameLogs.write((user.getName() + " choose to play " + numberOfGames + " games." + "\n")
                .getBytes(StandardCharsets.UTF_8));
        for (int i = 0; i < numberOfGames; i++) {
            gameLogs.write(("Game " + (1 + i)).getBytes(StandardCharsets.UTF_8));
            playGame(user, computer, gameLogs);
            if (i < numberOfGames - 1) {
                if (checkToContinue() == 0) {
                    gameLogs.write(("\n" + user.getName() + " decided to stop the game.")
                            .getBytes(StandardCharsets.UTF_8));
                    break;
                }
            }
        }
        System.out.println(writeFinalResults(user, computer));
        gameResults.write(writeFinalResults(user, computer).getBytes(StandardCharsets.UTF_8));
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
            sc.nextLine();
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

    private static GameChoices userMakesChoice() {

        try {
            System.out.println("Pick: \n * rock \n * scissors  \n * paper.");
            return valueOf(sc.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Please, choose one of the variants below!");
            return userMakesChoice();
        }
    }

    private static void playGame(User user, User computer, OutputStream outputStream) throws IOException {
        GameChoices userChoice = userMakesChoice();
        String userTurn = "\n" + user.getName() + "'s choice is: " + userChoice + "\n";
        System.out.print(userTurn);
        outputStream.write(userTurn.getBytes(StandardCharsets.UTF_8));
        GameChoices computerChoice = generationOfComputerChoice();
        String computerTurn = "Computer's choice is: " + computerChoice + "\n";
        System.out.print(computerTurn);
        outputStream.write(computerTurn.getBytes(StandardCharsets.UTF_8));
        findOneGameResult(userChoice, computerChoice, user, computer, outputStream);

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
            sc.nextLine();
            System.out.println("Please, choose 1 for YES or 0 for NO");
            return checkToContinue();
        }
    }

    private static void findOneGameResult(GameChoices userChoice, GameChoices computerChoice,
                                          User user, User computer, OutputStream outputStream) throws IOException {
        if (userChoice == computerChoice) {
            System.out.println("It's a tie");
            outputStream.write(("It's a tie" + "\n").getBytes(StandardCharsets.UTF_8));
        } else if (BEATS.get(userChoice) == computerChoice) {
            System.out.println("You've won");
            user.setScore(user.getScore() + 1);
            outputStream.write((user.getName() + "'s won" + "\n").getBytes(StandardCharsets.UTF_8));
        } else {
            System.out.println("You've lost");
            computer.setScore(computer.getScore() + 1);
            outputStream.write((user.getName() + "'s lost" + "\n").getBytes(StandardCharsets.UTF_8));
        }

    }

    private static String writeFinalResults(User user, User computer) {
        if (computer.getScore() > user.getScore()) {
            return "========== Game result ==========" + "\n" + "Computer score: " + computer.getScore() +
                    "\n" + user.getName() + "'s score: " + user.getScore() + "\n" + "Computer win!";
        } else if (user.getScore() > computer.getScore()) {
            return "========== Game result ==========" + "\n" + "Computer score: " + computer.getScore() +
                    "\n" + user.getName() + "'s score: " + user.getScore() + "\n" + user.getName() + " win!";
        } else {
            return "========== Game result ==========" + "\n" + "Computer score: " + computer.getScore() +
                    "\n" + user.getName() + "'s score: " + user.getScore() + "\n" + "It's a tie!";
        }
    }

}
