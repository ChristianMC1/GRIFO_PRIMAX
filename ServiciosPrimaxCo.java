import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ServiciosPrimaxCo {
    static Scanner sc = new Scanner(System.in);
    static final String usuarioAD = "yony";
    static final String contraAD = "1234";
    static ArrayList<String> carrito = new ArrayList<>();
    static ArrayList<Double> carritoPrecios = new ArrayList<>();
    static ArrayList<String> usuarioCLI = new ArrayList<>();
    static ArrayList<String> contraCLI = new ArrayList<>();
    static ArrayList<String> productoTI = new ArrayList<>();
    static ArrayList<Double> preciosTI = new ArrayList<>();
    static ArrayList<String> serviciosAU = new ArrayList<>();
    static ArrayList<Double> preciosAU = new ArrayList<>();
    static ArrayList<String> gasolina = new ArrayList<>();
    static ArrayList<Double> precioGASO = new ArrayList<>();
    static ArrayList<String> usuarioAGRE = new ArrayList<>();
    static ArrayList<String> contraAGRE = new ArrayList<>();

    public static void modificarGASO() {
        System.out.println("Ingrese nombre de la gasolina a modificar");
        String produc = sc.nextLine();
        int indice = gasolina.indexOf(produc);
        if (indice != -1) {
            String nuevoPRO;
            double precioa;
            System.out.println("Ingrese la nueva gasolina");
            nuevoPRO = sc.nextLine();
            System.out.println("Ingrese el precio de la gasolina");
            precioa = sc.nextDouble();
            sc.nextLine();
            gasolina.set(indice, nuevoPRO);
            precioGASO.set(indice, precioa);
        } else {
            System.out.println("No encontrado");
        }
    }

    public static void modificarSER() {
        System.out.println("Ingrese nombre del servicio a modificar");
        String produc = sc.nextLine();
        int indice = serviciosAU.indexOf(produc);
        if (indice != -1) {
            String nuevoPRO;
            double precioa;
            System.out.println("Ingrese el nombre del nuevo servicio");
            nuevoPRO = sc.nextLine();
            System.out.println("Ingrese el precio del servicio");
            precioa = sc.nextDouble();
            sc.nextLine();
            serviciosAU.set(indice, nuevoPRO);
            preciosAU.set(indice, precioa);
        } else {
            System.out.println("Servicio no encontrado");
        }
    }

    public static void modificarPRO() {
        System.out.println("Ingrese nombre del producto a modificar");
        String produc = sc.nextLine();
        int indice = productoTI.indexOf(produc);
        if (indice != -1) {
            String nuevoPRO;
            double precioa;
            System.out.println("Ingrese el nombre del nuevo producto");
            nuevoPRO = sc.nextLine();
            System.out.println("Ingrese el precio del producto");
            precioa = sc.nextDouble();
            sc.nextLine();
            productoTI.set(indice, nuevoPRO);
            preciosTI.set(indice, precioa);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public static void menuMODI() {
        System.out.println("Elija una de estas opciones");
        System.out.println("1.-Modificar producto a la tienda");
        System.out.println("2.-Modificar servicio automotriz");
        System.out.println("3.-Modificar gasolina");
        System.out.println("4.-Salir al menú principal");
        int opci = sc.nextInt();
        sc.nextLine();
        switch (opci) {
            case 1:
                modificarPRO();
                break;
            case 2:
                modificarSER();
                break;
            case 3:
                modificarGASO();
                break;
            case 4:
                menuAD();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    public static void agregagasolina() {
        System.out.print("Ingrese el tipo de gasolina: ");
        String nombre = sc.nextLine();
        double precioss;
        System.out.print("Ingrese el precio de la gasolina: ");
        precioss = sc.nextDouble();
        sc.nextLine();
        gasolina.add(nombre);
        precioGASO.add(precioss);
        System.out.println("Tipo de gasolina agregado correctamente.");
    }

    public static void agregaservicios() {
        System.out.print("Ingrese el servicio: ");
        String nombre = sc.nextLine();
        double precioss;
        System.out.print("Ingrese el precio del servicio: ");
        precioss = sc.nextDouble();
        sc.nextLine();
        serviciosAU.add(nombre);
        preciosAU.add(precioss);
        System.out.println("Servicio agregado correctamente.");
    }

    public static void agregaproducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        double precioss;
        System.out.print("Ingrese el precio del producto: ");
        precioss = sc.nextDouble();
        sc.nextLine();
        productoTI.add(nombre);
        preciosTI.add(precioss);
        System.out.println("Producto agregado correctamente.");
    }

    public static void menudeAGRE() {
        System.out.println("Elija una de estas opciones");
        System.out.println("1.-Agregar producto a la tienda");
        System.out.println("2.-Agregar servicio automotriz");
        System.out.println("3.-Agregar gasolina");
        System.out.println("4.-Salir al menú principal");
        int opci = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        switch (opci) {
            case 1:
                agregaproducto();
                break;
            case 2:
                agregaservicios();
                break;
            case 3:
                agregagasolina();
                break;
            case 4:
                menuAD();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    public static void eliminarGASO() {
        System.out.println("Ingrese el nombre de la gasolina:");
        String nombre = sc.nextLine();
        if (gasolina.contains(nombre)) {
            int indice = gasolina.indexOf(nombre);
            gasolina.remove(indice);
            precioGASO.remove(indice);
            System.out.println("Gasolina eliminada!");
        } else {
            System.out.println("No se encontró el nombre de la gasolina");
        }
    }

    public static void eliminarSER() {
        System.out.println("Ingrese el nombre del servicio a eliminar:");
        String nombre = sc.nextLine();
        if (serviciosAU.contains(nombre)) {
            int indice = serviciosAU.indexOf(nombre);
            serviciosAU.remove(indice);
            preciosAU.remove(indice);
            System.out.println("Servicio eliminado!");
        } else {
            System.out.println("No se encontró el servicio");
        }
    }

    public static void eliminarPro() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = sc.nextLine();
        if (productoTI.contains(nombre)) {
            int indice = productoTI.indexOf(nombre);
            productoTI.remove(indice);
            preciosTI.remove(indice);
            System.out.println("Producto eliminado!");
        } else {
            System.out.println("No se encontró el producto");
        }
    }

    public static void menudeELI() {
        System.out.println("Elija una de estas opciones");
        System.out.println("1.-Eliminar producto a la tienda");
        System.out.println("2.-Eliminar servicio automotriz");
        System.out.println("3.-Eliminar gasolina");
        System.out.println("4.-Salir al menú principal");
        int opci = sc.nextInt();
        sc.nextLine();
        switch (opci) {
            case 1:
                eliminarPro();
                break;
            case 2:
                eliminarSER();
                break;
            case 3:
                eliminarGASO();
                break;
            case 4:
                menuAD();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    public static void mostrarGASO() {
        if (gasolina.size() > 0) {
            for (int i = 0; i < gasolina.size(); i++) {
                System.out.println(gasolina.get(i) + " - " + precioGASO.get(i));
            }
        } else {
            System.out.println("No hay gasolina a mostrar");
        }
    }

    public static void mostrarSER() {
        if (serviciosAU.size() > 0) {
            for (int i = 0; i < serviciosAU.size(); i++) {
                System.out.println((i + 1) + ". " + serviciosAU.get(i) + " - $" + preciosAU.get(i));
            }
        } else {
            System.out.println("No hay servicios que mostrar");
        }
    }

    public static void mostrarPRO() {
        if (productoTI.size() > 0) {
            for (int i = 0; i < productoTI.size(); i++) {
                System.out.println((i + 1) + ". " + productoTI.get(i) + " - $" + preciosTI.get(i));
            }
        } else {
            System.out.println("No hay productos a mostrar");
        }
    }

    public static void agregarUS() {
        System.out.println("Ingrese un nuevo usuario del vendedor");
        String ussu = sc.nextLine();
        System.out.println("Ingrese una nueva contraseña");
        String contraa = sc.nextLine();
        usuarioAGRE.add(ussu);
        contraAGRE.add(contraa);
    }

    public static void menuMOS() {
        System.out.println("Elija una de estas opciones");
        System.out.println("1.-Mostrar producto a la tienda");
        System.out.println("2.-Mostrar servicio automotriz");
        System.out.println("3.-Mostrar gasolina");
        System.out.println("4.-Salir al menú principal");
        int opci = sc.nextInt();
        sc.nextLine();
        switch (opci) {
            case 1:
                mostrarPRO();
                break;
            case 2:
                mostrarSER();
                break;
            case 3:
                mostrarGASO();
                break;
            case 4:
                menuAD();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    public static boolean menuAD() {
        boolean salir = false;
        while (!salir) {
            System.out.println("=== MENÚ DEL ADMINISTRADOR ===");
            System.out.println("Elija una de las opciones ");
            System.out.println("1.-Agregar");
            System.out.println("2.-Modificar");
            System.out.println("3.-Eliminar");
            System.out.println("4.-Mostrar");
            System.out.println("5.-Registrar usuario");
            System.out.println("6.-Salir al menú principal");
            int nume = sc.nextInt();
            sc.nextLine();
            switch (nume) {
                case 1:
                    menudeAGRE();
                    break;
                case 2:
                    menuMODI();
                    break;
                case 3:
                    menudeELI();
                    break;
                case 4:
                    menuMOS();
                    break;
                case 5:
                    agregarUS();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        return true;
    }

    public static boolean iniciarSesionAD() {
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("=== INICIAR SESIÓN ===");
            System.out.print("USUARIO: ");
            String usuario = sc.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = sc.nextLine();
            if (usuario.equals(usuarioAD) && contraseña.equals(contraAD)) {
                System.out.println("Inicio de sesión exitoso.\n");
                return true;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }
        return false;
    }

    public static boolean iniciarSesionVE() {
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("\n=== INICIAR SESIÓN VENDEDOR ===");
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = sc.nextLine();

            boolean correcto = false;
            for (int i = 0; i < usuarioAGRE.size(); i++) {
                if (usuarioAGRE.get(i).equals(usuario) && contraAGRE.get(i).equals(contraseña)) {
                    correcto = true;
                    break;
                }
            }

            if (correcto) {
                System.out.println("Inicio de sesión exitoso.");
                menuVE();
                return true;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }

        System.out.println("Demasiados intentos fallidos. Regresando al menú principal.");
        return false;
    }

    public static void venderGasolina() {
        System.out.println("Gasolinas disponibles:");
        for (int i = 0; i < gasolina.size(); i++) {
            System.out.printf("%d. %s - $%.2f por galón\n", i + 1, gasolina.get(i), precioGASO.get(i));
        }
        System.out.print("Elige el número del tipo de gasolina que deseas comprar: ");
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion >= 1 && opcion <= gasolina.size()) {
                String tipo = gasolina.get(opcion - 1);
                double precio = precioGASO.get(opcion - 1);

                System.out.print("¿Cuántos galones deseas?: ");
                try {
                    double galones = Double.parseDouble(sc.nextLine());
                    if (galones > 0) {
                        double costo = precio * galones;
                        carrito.add(tipo + " (" + galones + " gal)");
                        carritoPrecios.add(costo);

                        System.out.println(tipo + " (" + galones + " gal) agregado al carrito.");
                    } else {
                        System.out.println("Debes ingresar una cantidad mayor a cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Debes ingresar un número para los galones.");
                }
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Escribe un número.");
        }
    }

    public static void venderServicios() {
        mostrarSER();
        System.out.print("Elige el número del servicio que desea: ");
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion >= 1 && opcion <= serviciosAU.size()) {
                String producto = serviciosAU.get(opcion - 1);
                double precio = preciosAU.get(opcion - 1);
                carrito.add(producto);
                carritoPrecios.add(precio);
                System.out.println(producto + " agregado al carrito.");
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Escribe un número.");
        }
    }

    public static void generarBoleta() {
        if (carrito.isEmpty()) {
            System.out.println("\nTu carrito está vacío. Agrega productos antes de pagar.");
            return;
        }
        double total = 0.0;
        for (double precio : carritoPrecios) total += precio;
        double igv = total * 0.18;
        double subtotal = total - igv;

        System.out.println("\n Total a pagar (incluye IGV): S/" + String.format("%.2f", total));
        System.out.println("Seleccione método de pago:\n1. Efectivo\n2. Tarjeta de Crédito/Débito");
        int metodo = sc.nextInt();
        sc.nextLine();

        double pago = 0;
        boolean pagoExitoso = false;

        switch (metodo) {
            case 1:
                System.out.print("Ingrese el monto con el que paga: S/");
                pago = sc.nextDouble();
                sc.nextLine();
                if (pago >= total) {
                    pagoExitoso = true;
                } else {
                    System.out.println("Monto insuficiente. Compra cancelada.");
                }
                break;
            case 2:
                System.out.print("Ingrese número de tarjeta (16 dígitos): ");
                String tarjeta = sc.nextLine();
                System.out.print("Ingrese CVV (3 dígitos): ");
                String cvv = sc.nextLine();
                if (tarjeta.matches("\\d{16}") && cvv.matches("\\d{3}")) {
                    System.out.println("Pago con tarjeta aprobado.");
                    pago = total;
                    pagoExitoso = true;
                } else {
                    System.out.println("Datos de tarjeta inválidos. Compra cancelada.");
                }
                break;
            default:
                System.out.println("Opción de pago no válida.");
        }

        if (pagoExitoso) {
            double vuelto = pago - total;
            System.out.print("Ingrese su nombre para generar la boleta: ");
            String nombreCliente = sc.nextLine();

            System.out.println("--- BOLETA DE VENTA ---");
            System.out.println("Cliente: " + nombreCliente);
            for (int i = 0; i < carrito.size(); i++) {
                System.out.printf("- %s: S/%.2f\n", carrito.get(i), carritoPrecios.get(i));
            }

            System.out.printf("Subtotal: S/%.2f\n", subtotal);
            System.out.printf("IGV (18%%): S/%.2f\n", igv);
            System.out.printf("Total pagado: S/%.2f\n", total);
            if (metodo == 1) {
                System.out.printf("Vuelto: S/%.2f\n", vuelto);
            }
            System.out.println("¡Gracias por su compra!");

            exportarBoleta(nombreCliente, carrito, carritoPrecios, subtotal, igv, total, vuelto, pago, metodo);
            carrito.clear();
            carritoPrecios.clear();
        }
    }

    public static void exportarBoleta(String cliente, ArrayList<String> productos, ArrayList<Double> precios,
                                      double subtotal, double igv, double total, double vuelto, double pago, int metodo) {
        String archivoNombre = "boleta_" + cliente.replaceAll("\\s+", "_") + ".txt";
        try (FileWriter archivo = new FileWriter(archivoNombre)) {
            archivo.write("=== BOLETA DE VENTA ===\n");
            archivo.write("Cliente: " + cliente + "\n");
            archivo.write("Productos:\n");
            for (int i = 0; i < productos.size(); i++) {
                archivo.write(String.format("- %s: S/%.2f\n", productos.get(i), precios.get(i)));
            }

            archivo.write(String.format("Subtotal: S/%.2f\n", subtotal));
            archivo.write(String.format("IGV (18%%): S/%.2f\n", igv));
            archivo.write(String.format("Total: S/%.2f\n", total));
            archivo.write(String.format("Pago realizado: S/%.2f\n", pago));
            if (metodo == 1) {
                archivo.write(String.format("Vuelto: S/%.2f\n", vuelto));
            } else if (metodo == 2) {
                archivo.write("Pago con tarjeta aprobado.\n");
            }

            archivo.write("¡Gracias por su compra!\n");
            System.out.println("Boleta exportada como '" + archivoNombre + "'.");
        } catch (IOException e) {
            System.out.println("Error al exportar la boleta: " + e.getMessage());
        }
    }


    public static void menuVE() {
        boolean salir = false;
        while (!salir) {
            System.out.println("--- MENU DEL VENDEDOR ---");
            System.out.println("Seleccione las siguientes opciones");
            System.out.println("1.- Productos");
            System.out.println("2.- Servicios");
            System.out.println("3.- Gasolina");
            System.out.println("4.- Generar boleta");
            System.out.println("5.- Exportar boleta");
            System.out.println("6.- Cerrar sesión");
            System.out.print("Opción: ");
            int ven = sc.nextInt();
            sc.nextLine();
            switch (ven) {
                case 1:
                    venderProductos();
                    break;
                case 2:
                    venderServicios();
                    break;
                case 3:
                    venderGasolina();
                    break;
                case 4:
                    generarBoleta();
                    break;
                case 5:
                    System.out.println("La boleta se exporta automáticamente al generar.");
                    break;
                case 6:
                    salir = true;
                    System.out.println("Sesión cerrada. Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void venderProductos() {
        mostrarPRO();
        System.out.print("Elige el número del producto que deseas comprar: ");
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion >= 1 && opcion <= productoTI.size()) {
                String producto = productoTI.get(opcion - 1);
                double precio = preciosTI.get(opcion - 1);

                carrito.add(producto);
                carritoPrecios.add(precio);

                System.out.println(producto + " agregado al carrito.");
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Escribe un número.");
        }
    }

    public static void menuCliente() {
        boolean salir = false;
        while (!salir) {
            System.out.println("--BIENVENIDO--");
            System.out.println("Seleccione una de las siguientes opciones");
            System.out.println("1.-Crear Cuenta");
            System.out.println("2.-Iniciar sesión");
            System.out.println("3.-Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    if (iniciarSesion()) {
                        salir = true;
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static boolean iniciarSesion() {
        System.out.println("\n=== INICIAR SESIÓN ===");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();
        if (usuarioCLI.contains(usuario)) {
            int index = usuarioCLI.indexOf(usuario);
            String contraGuardada = contraCLI.get(index);
            if (contraseña.equals(contraGuardada)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario + "!");
                menuCLIENTE(usuario);
                return true;
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            System.out.println("El usuario no existe.");
        }
        return false;
    }

    public static void crearCuenta() {
        System.out.println("=== CREAR CUENTA ===");
        System.out.print("Elige un nombre de usuario: ");
        String usuario = sc.nextLine();
        if (usuarioCLI.contains(usuario)) {
            System.out.println("El usuario ya existe. Intenta con otro nombre.");
            return;
        }
        System.out.print("Elige una contraseña: ");
        String contraseña = sc.nextLine();
        usuarioCLI.add(usuario);
        contraCLI.add(contraseña);
        System.out.println("Cuenta creada con éxito.");
    }

    public static void menuCLIENTE(String usuario) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n-- MENÚ DE SERVICIOS PARA " + usuario.toUpperCase() + " --");
            System.out.println("1.- Tienda");
            System.out.println("2.- Automotriz");
            System.out.println("3.- Gasolina");
            System.out.println("4.- Generar Boleta");
            System.out.println("5.- Cerrar sesión y volver al menú principal");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    venderProductos();
                    break;
                case 2:
                    venderServicios();
                    break;
                case 3:
                    venderGasolina();
                    break;
                case 4:
                    generarBoleta();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {
        usuarioAGRE.add("yony1");
        contraAGRE.add("4321");

        productoTI.add("Hot Dog");
        preciosTI.add(8.00);
        productoTI.add("Hamburguesa");
        preciosTI.add(12.00);
        productoTI.add("Gaseosa");
        preciosTI.add(5.00);
        productoTI.add("Galletas");
        preciosTI.add(1.00);
        productoTI.add("Dulces");
        preciosTI.add(0.50);
        productoTI.add("Helado");
        preciosTI.add(3.00);
        productoTI.add("Agua Mineral");
        preciosTI.add(1.00);

        serviciosAU.add("Alineamiento");
        preciosAU.add(80.00);
        serviciosAU.add("Cambio de Aceite");
        preciosAU.add(50.00);
        serviciosAU.add("Lavado Premium");
        preciosAU.add(30.00);

        gasolina.add("Regular");
        precioGASO.add(19.50);
        gasolina.add("Premium");
        precioGASO.add(22.00);

        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("---BIENVENIDO A SERVICIOS PRIMAX---");
            System.out.println("Elija las siguientes opciones");
            System.out.println("1.-Soy administrador");
            System.out.println("2.-Soy vendedor");
            System.out.println("3.-Soy cliente");
            System.out.println("4.-SALIR");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    if (iniciarSesionAD()) {
                        menuAD();
                    }
                    break;
                case 2:
                    iniciarSesionVE();
                    break;
                case 3:
                    menuCliente();
                    break;
                case 4:
                    System.out.println("SALIENDO");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
            }
        }
    }
}