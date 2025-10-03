package lk.sliit.inventorycontrolsystem.projectse2030se;

import lk.sliit.inventorycontrolsystem.projectse2030se.config.db.ddl.DBTableAndColumnConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.server.tomcat.EmbeddedTomcatServerConfig;
import org.apache.catalina.LifecycleException;

import java.util.List;

public class TomcatServer {
    public static void main(String[] args) throws LifecycleException {

        try {
            // Phase 01 : Checking All the Models with @DBTable and @DBColumn before creating Tables inside the Database
            List<Class<?>> modelClasses = DBTableAndColumnConfig.getAllModelClasses();
            DBTableAndColumnConfig.checkEachModelHaveDBTable(modelClasses);
            DBTableAndColumnConfig.checkEachColumnHaveDBColumn(modelClasses);

            EmbeddedTomcatServerConfig.start();
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
