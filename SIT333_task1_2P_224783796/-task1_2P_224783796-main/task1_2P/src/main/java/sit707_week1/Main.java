package sit707_week1;

public class Main {

    /*
     * Main entry point of a Java program.
     */
    public static void main(String[] args) {

        int choice = 4; // Set choice to 4 to call the open_chrome_loadpage_resize_close method

        switch (choice) {
        case 1:
            SeleniumOperations.open_chrome_and_close(); // Case 1: Open Chrome and Close
            break;
        case 2:
            SeleniumOperations.open_chrome_maximize_close(); // Case 2: Open Chrome, Maximize, and Close
            break;
        case 3:
            SeleniumOperations.load_web_page_close(); // Case 3: Load Web Page and Close
            break;
        case 4:
            SeleniumOperations.open_chrome_loadpage_resize_close(); // Case 4: Open Chrome, Load Google, Resize, and Close
            break;
        default:
            System.out.println("Invalid choice."); // Handle invalid input
            break;
        }
    }
}
