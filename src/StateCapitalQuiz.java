import java.util.Scanner;

public class StateCapitalQuiz {
    public static void main(String[] args) {
        // Define the 2D array of state capitals
        String[][] stateCapitals = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
        };

        // Display the current contents of the array
        System.out.println("Current contents of the array:");
        for (String[] stateCapital : stateCapitals) {
            System.out.println(stateCapital[0] + " - " + stateCapital[1]);
        }

        // Sort the array by capital using bubble sort
        for (int i = 0; i < stateCapitals.length - 1; i++) {
            for (int j = 0; j < stateCapitals.length - 1 - i; j++) {
                if (stateCapitals[j][1].compareToIgnoreCase(stateCapitals[j+1][1]) > 0) {
                    String[] temp = stateCapitals[j];
                    stateCapitals[j] = stateCapitals[j+1];
                    stateCapitals[j+1] = temp;
                }
            }
        }

        // Prompt the user to enter answers for all the state capitals
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
        for (String[] stateCapital : stateCapitals) {
            System.out.print("What is the capital of " + stateCapital[0] + "? ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(stateCapital[1])) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The capital of " + stateCapital[0] + " is " + stateCapital[1] + ".");
            }
        }

        // Display the total correct count
        System.out.println("You got " + correctCount + " out of " + stateCapitals.length + " correct.");
    }
}