import com.epam.console.ConsoleManager;
import com.epam.console.ConsoleProvider;
import com.epam.console.IConsoleManager;
import com.epam.controller.FilterController;

public class TDDApplication {
    public static void main(String... args) {
        IConsoleManager consoleManager = new ConsoleManager();
        ConsoleProvider consoleProvider = new ConsoleProvider(consoleManager);
        FilterController filterController = new FilterController(consoleProvider);
        try {
            filterController.readAndVerifyStartDate();
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        try {
            filterController.readAndVerifyEndDate();
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
    }
}
