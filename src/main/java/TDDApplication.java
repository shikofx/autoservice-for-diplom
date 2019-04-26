import com.epam.console.ConsoleDataProvider;
import com.epam.console.ConsoleManager;
import com.epam.console.IConsoleManager;
import com.epam.controller.DerbyDataBaseController;
import com.epam.controller.FilterController;
import com.epam.data.RequestToFindOrders;
import com.epam.data.repo.AutoOrderRepository;
import com.epam.domain.AutoOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TDDApplication {
    public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    public static void main(String... args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        IConsoleManager consoleManager = new ConsoleManager();
        RequestToFindOrders request = new RequestToFindOrders();
        ConsoleDataProvider consoleDataProvider = new ConsoleDataProvider(consoleManager);
        FilterController filterController = new FilterController(consoleDataProvider);
        DerbyDataBaseController derbyDataBaseController = new DerbyDataBaseController("db_autoservice");
        AutoOrderRepository orderRepository = new AutoOrderRepository(derbyDataBaseController);
        orderRepository.createTable(new AutoOrder());
        List<AutoOrder> orderList = new ArrayList<AutoOrder>();
        orderList.add(new AutoOrder().withId(1).withDate(new Date()).withOwnerName("Alex"));
        orderList.add(new AutoOrder().withId(2).withDate(new Date()).withOwnerName("Peter"));
        orderList.add(new AutoOrder().withId(3).withDate(new Date()).withOwnerName("Morphey"));
        for (AutoOrder order : orderList) {
            orderRepository.add(order);
        }

        List<AutoOrder> orderListFromDB = orderRepository.findAll();
        for (AutoOrder order : orderListFromDB) {
            System.out.println(order.toString());
        }

//        try {
//            filterController.readAndVerifyStartDate();
//            request.withStartDate(filterController.getStartDate());
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            filterController.readAndVerifyEndDate();
//            request.withEndDate(filterController.getEndDate());
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

    }
}
