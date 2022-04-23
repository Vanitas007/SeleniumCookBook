package JavaStartSeleniumRozdzial_9.driver;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
