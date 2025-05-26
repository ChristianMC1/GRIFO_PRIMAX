import java.util.Scanner;

public class VentaGasolina {

    public static void main(String[] args) {
        double total = calcularVentaGasolina();
        System.out.println("Total a pagar por gasolina: S/ " + total);
    }

    public static double calcularVentaGasolina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- VENTA DE GASOLINA ---");
        System.out.print("Ingrese galones: ");
        double galones = sc.nextDouble();
        double precioPorGalon = 20.50;
        return galones * precioPorGalon;
    }
}