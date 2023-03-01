import java.util.*;

public class StateCapitalQuiz {
    public static void main(String[] args) {

        // PART 1:

        // Defining the 2D array of state capitals
        String[][] stateCapitals = {
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"},
                {"California", "Sacramento"}, {"Colorado", "Denver"}, {"Connecticut", "Hartford"}, {"Delaware", "Dover"},
                {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"}, {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"}, {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"}, {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"}, {"Montana", "Helena"}, {"Nebraska", "Lincoln"}, {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"}, {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, {"New York", "Albany"},
                {"North Carolina", "Raleigh"}, {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"}, {"Texas", "Austin"}, {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"}, {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
        };

        // Displaying the current contents of the array
        System.out.println("US States and their capitals: - Using 2D Array:");
        System.out.println("\n*************************\n");

        // Using a for-each loop, display the contents of the array
        for (String[] stateCapital : stateCapitals) {
            System.out.println(stateCapital[0] + " - " + stateCapital[1]);
        }

        // Sorting the array by capital using bubble sort
        for (int i = 0; i < stateCapitals.length - 1; i++) {
            for (int j = 0; j < stateCapitals.length - 1 - i; j++) {
                // Comparing the current element (state and capital) with the next element, while also ignoring case.
                if (stateCapitals[j][1].compareToIgnoreCase(stateCapitals[j+1][1]) > 0) {
                    String[] temp = stateCapitals[j];
                    stateCapitals[j] = stateCapitals[j+1];
                    stateCapitals[j+1] = temp;
                }
            }
        }

        System.out.println("\n*************************");

        // Prompting the user to enter answers for all the state capitals
        Scanner userInput = new Scanner(System.in);
        int questionCount = 1;
        int correctCount = 0;

        // Using a for-each loop to prompt the user to enter the capital of each state
        for (String[] stateCapital : stateCapitals) {
            System.out.println("\nQuestion " + (questionCount++) + " of " + stateCapitals.length + ":");
            System.out.print("\nWhat is the capital of " + stateCapital[0] + "? (type 'quit' to exit) ");
            String userAnswer = userInput.nextLine();

            // Checking if the user entered 'quit'
            if (userAnswer.equalsIgnoreCase("quit")) {
                System.out.println("Exiting quiz...");
                break;
            }

            // Checking if the user's answer is correct, and displaying the result
            if (userAnswer.equalsIgnoreCase(stateCapital[1])) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The capital of " + stateCapital[0] + " is " + stateCapital[1] + ".");
            }
        }

        // Displaying the total correct answers
        System.out.println("\nYou got " + correctCount + " out of " + stateCapitals.length + " correct.\n\n");


        // ------------------------------------------------------------------------------------------------------------

        // PART 2:

        // HASH MAP
        // Creating a HashMap to store the state capitals
        HashMap<String, String> stateCapitalHashMap = new HashMap<>();

        // Adding each state capital pair to the HashMap
        for (String[] stateCapital : stateCapitals) {
            stateCapitalHashMap.put(stateCapital[0], stateCapital[1]);
        }

        // Displaying the current contents of the HashMap
        System.out.println("Displaying state and capitals into a HashMap: - Using HashMap:");
        System.out.println("\n*************************\n");
        for (String state : stateCapitalHashMap.keySet()) {
            System.out.println(state + " - " + stateCapitalHashMap.get(state));
        }

        // TREE MAP
        // Creating a TreeMap (keys are naturally ordered) to store the state capitals
        TreeMap<String, String> stateCapitalTreeMap = new TreeMap<>();

        // Adding each state capital pair to the TreeMap
        for (String[] stateCapital : stateCapitals) {
            stateCapitalTreeMap.put(stateCapital[0], stateCapital[1]);
        }

        // Displaying the current contents of the TreeMap
        System.out.println("\nUS States and their capitals (sorted by state) - Using TreeMap:");
        System.out.println("\n*************************\n");
        for (String state : stateCapitalTreeMap.keySet()) {
            System.out.println(state + " - " + stateCapitalTreeMap.get(state));
        }

        Scanner userInput2 = new Scanner(System.in);

        while (true) {
            // Prompting the user to enter a state or quit
            System.out.print("\nEnter a state name (or 'quit' to exit): ");
            String input = userInput2.nextLine();

            // Checking if the user wants to quit
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            // Checking if the state is in the TreeMap and displaying the capital
            if (stateCapitalTreeMap.containsKey(input)) {
                System.out.println("The capital of " + input + " is " + stateCapitalTreeMap.get(input) + ".");
            } else {
                System.out.println("Sorry, the state \"" + input + "\" is not in the list.");
            }
        }
    }

}