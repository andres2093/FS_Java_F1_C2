import e1.Singleton;
import e2.AnalysisLibrary;
import e2.StockMarketAdapter;
import e2.StockMarketReport;
import e3.TextEditor;
import r1.Motor;
import r1.MotorElectricoAdapter;
import r2.Add10Command;
import r2.Command;
import r2.IncrementCommand;
import r2.MultiplyBy2Command;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

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

        System.out.println(" ");
        System.out.println("-----------------R1----------------------");

        Motor motor = new MotorElectricoAdapter();
        motor.encender();
        motor.acelerar();
        motor.apagar();

        System.out.println(" ");
        System.out.println("-----------------E3----------------------");

        TextEditor editor = new TextEditor();
        editor.onPressSaveButton();
        editor.onPressSaveOption();
        editor.onShortcut();

        System.out.println(" ");
        System.out.println("-----------------R2----------------------");

        Scanner sc = new Scanner(System.in);

        Stack<Command> stack = new Stack<>();

        Command add10Command = new Add10Command();
        Command multiplyBy2Command = new MultiplyBy2Command();
        Command incrementCommand = new IncrementCommand();

        int counter = 0;

        int option = 0;

        while (option != 5) {
            System.out.println("\nValor actual: " + counter);
            System.out.println("Elige alguna opción:");
            System.out.println("1. Incrementa en uno el contador");
            System.out.println("2. Multiplica por 2 el contador");
            System.out.println("3. Añade 10 al contador");
            System.out.println("4. Deshacer último cambio");
            System.out.println("5. Salir");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    counter = incrementCommand.execute(counter);
                    stack.add(incrementCommand);
                    break;
                case 2:
                    counter = multiplyBy2Command.execute(counter);
                    stack.add(multiplyBy2Command);
                    break;
                case 3:
                    counter = add10Command.execute(counter);
                    stack.add(add10Command);
                    break;
                case 4:
                    try {
                        Command undo = stack.pop();
                        if (undo != null) {
                            counter = undo.unexecute(counter);
                        }
                    } catch (EmptyStackException e) {
                        System.out.println("No hay más operaciones por deshacer");
                    }
                    break;
            }
        }

    }
}
