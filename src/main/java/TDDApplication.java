import com.epam.console.ConsoleDataProvider;
import com.epam.console.ConsoleManager;
import com.epam.console.IConsoleManager;
import com.epam.controller.DerbyDataBaseController;
import com.epam.controller.FilterController;
import com.epam.data.RequestToFindOrders;

import java.sql.SQLException;


public class TDDApplication {
    public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    public static void main(String... args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        IConsoleManager consoleManager = new ConsoleManager();
        RequestToFindOrders request = new RequestToFindOrders();
        ConsoleDataProvider consoleDataProvider = new ConsoleDataProvider(consoleManager);
        FilterController filterController = new FilterController(consoleDataProvider);
        DerbyDataBaseController derbyDataBaseController = new DerbyDataBaseController("db_autoservice");
        //        try {
//            filterController.readAndVerifyStartDate();
//            request.withStartDate(filterController.getStartDate());
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }
//        try {
//            filterController.readAndVerifyEndDate();
//            request.withEndDate(filterController.getEndDate());
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

    }
}
