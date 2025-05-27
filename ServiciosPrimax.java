import java.util.*;
import java.util.regex.*;

public class ServiciosPrimax {
    static Scanner sc = new Scanner(System.in);
    static String correo, contraseña;

    public static void main(String[] args) {
        System.out.println("¡Bienvenido a Autoservicio Primax!");
        crearCuenta();
        if (iniciarSesion()) {
            mostrarMenu();
        } else {
            System.out.println("Has excedido el número de intentos.");
        }
    }

    public static void crearCuenta() {
        Pattern patronCorreo = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+com$");
        Pattern patronContraseña = Pattern.compile("^(?=.[a-zA-Z])(?=.\\d).{8,}$");

        while (true) {
            System.out.println("=== CREAR CUENTA ===");
            System.out.print("Ingrese su correo: ");
            correo = sc.nextLine();
            Matcher matchCorreo = patronCorreo.matcher(correo);

            System.out.print("Cree una contraseña (mín. 8 caracteres, letras y números): ");
            contraseña = sc.nextLine();
            Matcher matchContra = patronContraseña.matcher(contraseña);

            if (matchCorreo.matches() && matchContra.matches()) {
                System.out.println("Cuenta creada exitosamente.\n");
                break;
            } else {
                System.out.println("Correo o contraseña no válidos. Intente nuevamente.\n");
            }
        }
    }

    public static boolean iniciarSesion() {
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("=== INICIAR SESIÓN ===");
            System.out.print("Correo: ");
            String correoLogin = sc.nextLine();
            System.out.print("Contraseña: ");
            String contraLogin = sc.nextLine();

            if (correoLogin.equals(correo) && contraLogin.equals(contraseña)) {
                System.out.println("Inicio de sesión exitoso.\n");
                return true;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }
        return false;
    }

    public static void mostrarMenu() {
        boolean salir = false;
        double totalFinal = 0;
        StringBuilder resumenServicios = new StringBuilder();   // Almacena lo de abajo
        String cliente = correo;

        while (!salir) {
            System.out.println("\n=== MENÚ DE SERVICIOS ===");
            System.out.println("1. Venta de Gasolina");
            System.out.println("2. Tienda Listo");
            System.out.println("3. Mantenimiento Automotriz");
            System.out.println("4. Finalizar compra");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            double total = 0;
            String descripcion = "";

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad de galones: ");
                    double galones = sc.nextDouble();
                    sc.nextLine();
                    total = galones * 20.50;
                    descripcion = String.format("Gasolina: %.2f galones x S/20.50 = S/%.2f", galones, total); //Se devuelve dos variables declaradas
                    //Descripcion guardar un resumen textual del servicio o producto
                    break;

                case 2:
                    System.out.println("1. Hot Dog - S/8.00");
                    System.out.println("2. Hamburguesa - S/12.00");
                    System.out.println("3. Gaseosa - S/5.00");
                    System.out.println("4. Galletas - S/1.00");
                    System.out.println("5. Dulces - S/0.50");
                    System.out.println("6. Helado - S/3.00");
                    System.out.println("7. Agua Mineral - S/1.00");
                    System.out.print("Seleccione producto: ");
                    int producto = sc.nextInt();
                    sc.nextLine();

                    switch (producto) {
                        case 1: total = 8.00; descripcion = "Tienda Listo: Hot Dog - S/8.00"; break;
                        case 2: total = 12.00; descripcion = "Tienda Listo: Hamburguesa - S/12.00"; break;
                        case 3: total = 5.00; descripcion = "Tienda Listo: Gaseosa - S/5.00"; break;
                        case 4: total = 1.00; descripcion = "Tienda Listo: Galletas - S/1.00"; break;
                        case 5: total = 0.50; descripcion = "Tienda Listo: Dulces - S/0.50"; break;
                        case 6: total = 3.00; descripcion = "Tienda Listo: Helado - S/3.00"; break;
                        case 7: total = 1.00; descripcion = "Tienda Listo: Agua Mineral - S/1.00"; break;
                        default: System.out.println("Opción inválida."); continue;
                    }
                    break;

                case 3:
                    System.out.println("1. Cambio de Aceite - S/50.00");
                    System.out.println("2. Alineamiento - S/80.00");
                    System.out.println("3. Lavado Premium - S/30.00");
                    System.out.print("Seleccione servicio: ");
                    int mant = sc.nextInt();
                    sc.nextLine();

                    switch (mant) {
                        case 1: total = 50.00; descripcion = "Mantenimiento: Cambio de Aceite - S/50.00"; break;
                        case 2: total = 80.00; descripcion = "Mantenimiento: Alineamiento - S/80.00"; break;
                        case 3: total = 30.00; descripcion = "Mantenimiento: Lavado Premium - S/30.00"; break;
                        default: System.out.println("Opción inválida."); continue;
                    }
                    break;

                case 4:
                    if (totalFinal == 0) {
                        System.out.println("No ha seleccionado ningún servicio aún.");
                        continue;
                    } else {
                        System.out.printf("El costo total de los productos y servicios seleccionados es: S/ %.2f\n", totalFinal);
                        metodoPago(totalFinal);
                        generarBoleta(cliente, resumenServicios.toString(), totalFinal);
                        salir = true;
                        continue;
                    }

                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            resumenServicios.append("- ").append(descripcion).append("\n");  //Se utiliza .append para acumular texto linea por linea de forma ordenada
            totalFinal += total;

            System.out.print("\n¿Desea volver al menú? (s/n): ");
            String volver = sc.nextLine();
            if (volver.equalsIgnoreCase("n")) {
                System.out.printf("El costo total de los productos y servicios seleccionados es: S/ %.2f\n", totalFinal);  //el printf imprime el total en soles pero con 2 decimales
                metodoPago(totalFinal);
                generarBoleta(cliente, resumenServicios.toString(), totalFinal); //el to.String genera cadena de texto de todo lo que se almaceno dentro de resumenServicios
                salir = true;
            }
        }
    }

    public static void generarBoleta(String cliente, String descripcion, double total) {
        System.out.println("\n=== BOLETA DE VENTA ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Servicios seleccionados:\n" + descripcion);
        System.out.printf("Total a pagar: S/ %.2f\n", total);
        System.out.println("Gracias por su compra en Autoservicio Primax.");
    }

    public static void metodoPago(double total) {
        System.out.println("\n=== MÉTODO DE PAGO ===");
        System.out.println("1. Tarjeta");
        System.out.println("2. Efectivo");
        System.out.print("Seleccione opción: ");
        int opcionPago = sc.nextInt();
        sc.nextLine();

        switch (opcionPago) {
            case 1:
                while (true) {
                    System.out.print("Ingrese número de tarjeta (16 dígitos): ");
                    String tarjeta = sc.nextLine();
                    if (tarjeta.matches("\\d{16}")) {
                        System.out.print("Ingrese CVV: ");
                        String cvv = sc.nextLine();
                        System.out.println("Pago con tarjeta exitoso.");
                        break;
                    } else {
                        System.out.println("Número de tarjeta inválido. Debe tener 16 dígitos numéricos.");
                    }
                }
                break;

            case 2:
                System.out.print("Ingrese monto entregado: ");
                double efectivo = sc.nextDouble();
                if (efectivo >= total) {
                    double vuelto = efectivo - total;
                    System.out.printf("Pago en efectivo exitoso. Vuelto: S/ %.2f\n", vuelto);
                } else {
                    System.out.println("Monto insuficiente.");
                }
                break;

            default:
                System.out.println("Método no válido.");
            }
    }
}
