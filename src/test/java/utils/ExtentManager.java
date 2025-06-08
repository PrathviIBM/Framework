package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
//            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\097960744\\eclipse-workspace\\API_Framework\\test-output/ExtentReport.html");            
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "REST Assured");
            extent.setSystemInfo("Tester", "Prathviraj");
        }
        return extent;
    }
}
