package lk.sliit.inventorycontrolsystem.projectse2030se.config.server.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class EmbeddedTomcatServerConfig {
    private static final int PORT = 8080;
    private static final String BASE_DIR = "temp";
    private static final String CONTEXT_PATH = "/InventoryControlSystem";
    private static final String DOC_BASE = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();

    public static void start() throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(BASE_DIR);
        tomcat.setPort(PORT);
        tomcat.getConnector();

        tomcat.addWebapp(CONTEXT_PATH, DOC_BASE);

        tomcat.start();
        tomcat.getServer().await();

    }
}
