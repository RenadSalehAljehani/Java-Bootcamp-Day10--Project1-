import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Be positive! you can do it! good luck Renad <3
        // ****The 2D array is consists of two of the original 1D arrays combined****
        // Create a new 2D array for the grid (3X3=9 positions)
        String[][] grid = new String[3][3]; // [rows] [columns]

        // Initialize the grid with values (1-9)
        resetGrid(grid);

        // Array to check the filled positions
        boolean[][] takenPositions = new boolean[3][3];

        // Scanner object
        Scanner userInput = new Scanner(System.in);

        // To store user object
        String userObject = " ";

        // To store the computer object
        String computerObject = " ";

        // To store the random generated position for the computer
        String computerPosition = "";

        // To store computer position as a number
        int computerPositionInt = 0;

        // To store user chosen position as a string
        String userPosition = "";

        // To store user position as a number
        int userPositionInt = 0;

        // To store number of rounds
        String numOfRounds = "";

        // To store number of rounds (assume that the user will choose 1 round)
        int numOfRoundsInt = 1;

        // To store current number of rounds that will be displayed in the header
        int currentRound = 1;

        // Counters for the final results
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        // To store the winner name
        String winner = "";

        // ************************************************************************************

        // Header for game
        System.out.println("################# Tic-Tac-Toe Game #################");

        // Loop till the user enter a valid object (x or o)
        do {
            // Prompt the user to choose an object (x or o and not empty)
            System.out.print("\nChoose x or o? ");
            userObject = userInput.nextLine();

            // Check if the user haven't entered a value
            if (userObject.isEmpty()) {
                System.out.println("\nPlease enter a value!");
                continue;
            }

            // Check if the user entered wrong value (anything rather than x or o)
            if (userObject.equalsIgnoreCase("x")) {
                computerObject = "o";
            } else if (userObject.equalsIgnoreCase("o")) {
                computerObject = "x";
            } else {
                System.out.println("\nPlease enter x or o!");
                continue;
            }

            // If user input is valid
            break;

        } while (true);

        // Loop till the user enter a valid number of rounds (1 or 3)
        do {
            // Prompt the user to enter number of rounds (1 or 3 and not empty)
            System.out.print("\nHow may rounds you want to play (1 or 3)? ");
            numOfRounds = userInput.nextLine();

            // Check if the user haven't entered a value
            if (numOfRounds.isEmpty()) {
                System.out.println("\nPlease enter a value!");
                continue;
            }

            // Check if the input is a valid number
            try {
                // Convert to integer
                numOfRoundsInt = Integer.parseInt(numOfRounds);
            } catch (NumberFormatException n) {
                System.out.println("\nPlease enter 1 or 3!");
                continue; // Re-prompt for a new input
            }

            // Check if the user entered wrong value (anything rather than 1 or 3)
            if (numOfRoundsInt == 0) {
                System.out.println("\nYou should enter number of rounds!");
                continue;
            } else if (numOfRoundsInt == 2) {
                System.out.println("\nNumber of rounds can be only 1 or 3!");
                continue;
            } else if (numOfRoundsInt > 3) {
                System.out.println("\nNumber of rounds should not exceed 3!");
                continue;
            } else if (numOfRoundsInt < 0) {
                System.out.println("\nNumber of rounds should not be negative!");
                continue;
            }

            // If user input is valid
            break;

        } while (true);

        do { // Loop rounds number (1 or 3)

            // Header for the round number
            System.out.println("\n##################### Round " + currentRound + " #####################");

            // Reset grid
            resetGrid(grid);

            // Reset taken positions
            resetTakenPositions(takenPositions);

            // Display the original grid
            System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                    "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                    "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);


            // Loop till the user enter a valid position (should be a number and in the grid range)
            do {
                // User turn
                // Prompt the user to enter a position
                System.out.print("\nEnter your position(1-9): ");
                userPosition = userInput.nextLine();

                // Check if the input is empty
                if (userPosition.isEmpty()) {
                    System.out.println("Please enter a value!");
                    continue; // Re-prompt for a new input
                }

                // Check if the input is a valid number
                try {
                    // Convert to integer
                    userPositionInt = Integer.parseInt(userPosition);
                } catch (NumberFormatException n) {
                    System.out.println("Please enter a valid number between 1-9!");
                    continue; // Re-prompt for a new input
                }

                // Check all possibilities (in the valid range)
                if (userPositionInt == 0) {
                    System.out.println("Position values should start from 1!");
                    continue;
                } else if (userPositionInt > 9) {
                    System.out.println("Position value should not exceed 9!");
                    continue;
                } else if (userPositionInt < 0) {
                    System.out.println("Position value should not be negative!");
                    continue;
                }

                // Check if the position is taken before updating the grid
                if (isPositionTaken(userPositionInt, takenPositions)) {
                    System.out.println("The selected position is already taken!");
                    continue; // Continue to prompt for a valid position
                }

                // Update the grid based on user selection
                switch (userPositionInt) {
                    case 1:
                        grid[0][0] = userObject;
                        takenPositions[0][0] = true;
                        break;
                    case 2:
                        grid[0][1] = userObject;
                        takenPositions[0][1] = true;
                        break;
                    case 3:
                        grid[0][2] = userObject;
                        takenPositions[0][2] = true;
                        break;
                    case 4:
                        grid[1][0] = userObject;
                        takenPositions[1][0] = true;
                        break;
                    case 5:
                        grid[1][1] = userObject;
                        takenPositions[1][1] = true;
                        break;
                    case 6:
                        grid[1][2] = userObject;
                        takenPositions[1][2] = true;
                        break;
                    case 7:
                        grid[2][0] = userObject;
                        takenPositions[2][0] = true;
                        break;
                    case 8:
                        grid[2][1] = userObject;
                        takenPositions[2][1] = true;
                        break;
                    case 9:
                        grid[2][2] = userObject;
                        takenPositions[2][2] = true;
                        break;
                }

                // Check for a winner or draw after the user's move
                if (haveAWinner(grid, userObject)) {
                    System.out.println("\n#################### Final Grid #####################"
                            + "\nCongratulations, you won round " + currentRound + "!");
                    // Display the final grid
                    System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                            "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                            "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
                    userWins++;
                    break; // Exit the round loop if user wins
                } else if (checkDraw(takenPositions)) {
                    System.out.println("\n#################### Final Grid #####################"
                            + "\nThe game ended in a draw in round " + currentRound + "!");
                    // Display the final grid
                    System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                            "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                            "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
                    draws++;
                    break; // Exit the round loop if it's a draw
                }

                // Computer turn
                do {
                    computerPosition = randomPosition();
                    computerPositionInt = Integer.parseInt(computerPosition);
                } while (isPositionTaken(computerPositionInt, takenPositions));

                // Update the grid with computer's selection
                switch (computerPositionInt) {
                    case 1:
                        grid[0][0] = computerObject;
                        takenPositions[0][0] = true;
                        break;
                    case 2:
                        grid[0][1] = computerObject;
                        takenPositions[0][1] = true;
                        break;
                    case 3:
                        grid[0][2] = computerObject;
                        takenPositions[0][2] = true;
                        break;
                    case 4:
                        grid[1][0] = computerObject;
                        takenPositions[1][0] = true;
                        break;
                    case 5:
                        grid[1][1] = computerObject;
                        takenPositions[1][1] = true;
                        break;
                    case 6:
                        grid[1][2] = computerObject;
                        takenPositions[1][2] = true;
                        break;
                    case 7:
                        grid[2][0] = computerObject;
                        takenPositions[2][0] = true;
                        break;
                    case 8:
                        grid[2][1] = computerObject;
                        takenPositions[2][1] = true;
                        break;
                    case 9:
                        grid[2][2] = computerObject;
                        takenPositions[2][2] = true;
                        break;
                }

                // Check for a winner or draw after the computer's move
                if (haveAWinner(grid, computerObject)) {
                    if(numOfRoundsInt == 1) { // 1 round
                        System.out.println("\n#################### Final Grid #####################"
                                + "\nComputer won round " + currentRound + ", better luck next time!");
                        // Display the final grid
                        System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                                "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                                "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
                    }if(numOfRoundsInt == 3) { // 3 rounds
                        System.out.println("\n#################### Final Grid #####################"
                                + "\nComputer won round " + currentRound + ", better luck next round!");
                        // Display the final grid
                        System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                                "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                                "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
                    }
                    computerWins++;
                    break; // Exit the round loop if computer wins
                } else if (checkDraw(takenPositions)) {
                    System.out.println("\n#################### Final Grid #####################" +
                            "\nThe game ended in a draw in round " + currentRound + "!");
                    // Display the final grid
                    System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                            "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                            "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
                    draws++;
                    break; // Exit the round loop if it's a draw
                }

                // Display the grid after any updates
                System.out.println("\n" + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] +
                        "\n--|---|--" + "\n" + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] +
                        "\n--|---|--" + "\n" + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);

            } while (true);

            // Display the winner name
            if (userWins > computerWins) {
                winner = "the User :)";
            } else if (computerWins > userWins) {
                winner = "the Computer :(";
            } else {
                winner = "No one :(";
            }

            // Increment the current round counter
            currentRound++;

        } while (currentRound <= numOfRoundsInt);

        // Display final results after all rounds and ending the game
        System.out.println("\n###################### X vs O ######################"
                + "\nGame Over! Here are the results:"
                + "\nNumber of rounds played: " + numOfRoundsInt
                + "\nUser object: " + userObject + " | Computer object: " + computerObject
                + "\nUser won " + userWins + " round(s)"
                + "\nComputer won " + computerWins + " round(s)"
                + "\nThere were " + draws + " draw(s)"
                + "\nThe winner is " + winner
                + "\nThanks for playing Tic-Tac-Toe game by Renad <3!"
                + "\n######################## <3 ########################");

        // Close the Scanner
        userInput.close();
    }

    // Method to reset the grid (for 3 rounds game)
    private static void resetGrid(String[][] grid) {
        int position = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = String.valueOf(position++);
    }

    // Method to reset the taken positions (for 3 rounds game)
    public static void resetTakenPositions(boolean[][] takenPositions) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                takenPositions[i][j] = false;
    }

    // Method to generate random positions for the computer
    public static String randomPosition() {
        // To generate the random computer position
        Random randomNumbers = new Random();

        // Convert it to a string and return it
        return String.valueOf(randomNumbers.nextInt(9) + 1);// Generates number 1-9

    }

    // Method to check if a position is taken
    private static boolean isPositionTaken(int position, boolean[][] takenPositions) {
        return switch (position) {
            case 1 -> takenPositions[0][0];
            case 2 -> takenPositions[0][1];
            case 3 -> takenPositions[0][2];
            case 4 -> takenPositions[1][0];
            case 5 -> takenPositions[1][1];
            case 6 -> takenPositions[1][2];
            case 7 -> takenPositions[2][0];
            case 8 -> takenPositions[2][1];
            case 9 -> takenPositions[2][2];
            default -> true; // Invalid position considered "taken" to prompt re-entry
        };
    }

    // Method to check for the winner
    public static boolean haveAWinner(String[][] grid, String winnerObject) {
        return (Objects.equals(grid[0][0], winnerObject) && Objects.equals(grid[0][1], winnerObject) && Objects.equals(grid[0][2], winnerObject))
                || (Objects.equals(grid[0][0], winnerObject) && Objects.equals(grid[1][0], winnerObject) && Objects.equals(grid[2][0], winnerObject))
                || (Objects.equals(grid[0][1], winnerObject) && Objects.equals(grid[1][1], winnerObject) && Objects.equals(grid[2][1], winnerObject))
                || (Objects.equals(grid[0][2], winnerObject) && Objects.equals(grid[1][2], winnerObject) && Objects.equals(grid[2][2], winnerObject))
                || (Objects.equals(grid[1][0], winnerObject) && Objects.equals(grid[1][1], winnerObject) && Objects.equals(grid[1][2], winnerObject))
                || (Objects.equals(grid[2][0], winnerObject) && Objects.equals(grid[2][1], winnerObject) && Objects.equals(grid[2][2], winnerObject))
                || (Objects.equals(grid[0][2], winnerObject) && Objects.equals(grid[1][1], winnerObject) && Objects.equals(grid[2][0], winnerObject))
                || (Objects.equals(grid[0][0], winnerObject) && Objects.equals(grid[1][1], winnerObject) && Objects.equals(grid[2][2], winnerObject));
    }

    // Method to check for a draw
    private static boolean checkDraw(boolean[][] takenPositions) {
        for (boolean[] row : takenPositions) {
            for (boolean pos : row) {
                if (!pos) {
                    return false; // Found an empty position
                }
            }
        }
        return true; // No empty positions left
    }
}