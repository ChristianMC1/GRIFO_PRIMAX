import java.util.Scanner;

public class MantenimientoAuto {

    public static void main(String[] args) {
        double total = calcularMantenimiento();
        if (total == 0) {
            System.out.println("Servicio no válido.");
        } else {
            System.out.println("Total a pagar por mantenimiento: S/ " + total);
        }
    }

    public static double calcularMantenimiento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- MANTENIMIENTO AUTOMOTRIZ ---");
        System.out.println("1. Cambio de aceite - S/ 50.00");
        System.out.println("2. Alineamiento - S/ 80.00");
        System.out.println("3. Lavado premium - S/ 30.00");
        System.out.print("Seleccione el servicio: ");
        int opcion = sc.nextInt();

        return switch (opcion) {
            case 1 -> 50.00;
            case 2 -> 80.00;
            case 3 -> 30.00;
            default -> 0.00;
        };
    }
}