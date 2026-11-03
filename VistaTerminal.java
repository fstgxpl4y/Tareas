import java.util.Scanner;

public class VistaTerminal {
    private Scanner scanner;

    private TareaController controlador;

    public VistaTerminal() {
        scanner = new Scanner(System.in);
        controlador = new TareaController();
    }

    public void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Completar tarea");
        System.out.println("3. Salir");
    }
    
}

