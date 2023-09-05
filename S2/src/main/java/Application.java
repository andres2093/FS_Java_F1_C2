import e1.Singleton;
import e2.AnalysisLibrary;
import e2.StockMarketAdapter;
import e2.StockMarketReport;

public class Application {

    public static void main(String[] args) {
        System.out.println("-----------------E1----------------------");
        Singleton singleton = Singleton.getInstance("Bedu");
        Singleton singleton2 = Singleton.getInstance("Beto");

        System.out.println(singleton.value);
        System.out.println(singleton2.value);

        System.out.println(" ");
        System.out.println("-----------------E2----------------------");

        StockMarketReport report = new StockMarketAdapter();
        String json = report.download();

        AnalysisLibrary library = new AnalysisLibrary();
        try {
            library.analyzeInformation(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
