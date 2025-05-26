import java.util.Scanner;

public class TiendaListo {

    public static void main(String[] args) {
        double total = calcularComida();
        if (total == 0) {
            System.out.println("Producto no válido.");
        } else {
            System.out.println("Total a pagar en quiosco: S/ " + total);
        }
    }

    public static double calcularComida() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- QUIOSCO DE COMIDA ---");
        System.out.println("1. Hot dog - S/ 8.00");
        System.out.println("2. Hamburguesa - S/ 12.00");
        System.out.println("3. Gaseosa - S/ 5.00");
        System.out.print("Seleccione su producto: ");
        int opcion = sc.nextInt();

        return switch (opcion) {
            case 1 -> 8.00;
            case 2 -> 12.00;
            case 3 -> 5.00;
            default -> 0.00;
        };
    }
}