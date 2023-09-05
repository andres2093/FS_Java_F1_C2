import e1.Singleton;

public class Application {

    public static void main(String[] args) {
        System.out.println("-----------------E1----------------------");
        Singleton singleton = Singleton.getInstance("Bedu");
        Singleton singleton2 = Singleton.getInstance("Beto");

        System.out.println(singleton.value);
        System.out.println(singleton2.value);
    }
}
