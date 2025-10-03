package lk.sliit.inventorycontrolsystem.projectse2030se.config.web;

public class WebAppPathConfig {
    private static WebAppPathConfig instance;
    private String basePath;

    private WebAppPathConfig() {}

    public static WebAppPathConfig getInstance() {
        if (instance == null) {
            instance = new WebAppPathConfig();
        }
        return instance;
    }

    public void setBasePath(String path) {
        this.basePath = path;
    }

    public String getBasePath() {
        return this.basePath;
    }
}
