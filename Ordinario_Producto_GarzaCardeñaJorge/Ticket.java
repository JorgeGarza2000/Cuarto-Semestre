import java.util.Scanner;

/*
    Intergrantes:
    Jorge Garza
    Karen Lopez
    Kevin Hidalgo
    Jose Canul
    Cesar Chuc
*/
public class Ticket {

    public static void main(String[] args) {

        final int CONCEPTOS = 2; // Constante que leera la cantidad de productos a ingresar

        // Variables que serviran para crear el arreglo
        String Codigo;
        String Nombre;
        double precioPorPieza;
        int piezas;

        int opc;

        String Codigo2;
        String Nombre2;
        double precioPorKilo;
        double peso;

        Producto[] productos = new Producto[CONCEPTOS];

        Scanner entrada = new Scanner(System.in);

        // Lee los datos de los productos uno por uno
        // Asigna los elementos del arreglo de productos

        System.out.println("========== Que opcion deseas elegir ============");
        System.out.println("OPCION 1. Ingresar Datos por Pieza");
        System.out.println("OPCION 2. Ingresar Datos por Kilo");
        System.out.println("Ingrese la opcion:");
        opc = entrada.nextInt();
        entrada.nextLine();
        switch (opc) {
            case 1:
                for (int i = 0; i < CONCEPTOS; i++) {

                    System.out.printf("%nlectura de detalles del producto %d%n%n", i + 1);

                    System.out.printf("%nIntroduzca el codigo del producto: ");
                    Codigo = entrada.nextLine();

                    System.out.printf("Introduzca el nombre del producto: ");
                    Nombre = entrada.nextLine();

                    System.out.printf("Introduzca el precio por pieza: ");
                    precioPorPieza = entrada.nextDouble();

                    System.out.printf("Introduzca la cantidad de piezas: ");
                    piezas = entrada.nextInt(); // 2\n

                    entrada.nextLine();// Consume el caracter que quedo en el salto de linea

                    productos[i] = new ProductoPorPieza(Codigo, Nombre, precioPorPieza, piezas);
                }
                break;
            case 2:
                for (int i = 0; i < CONCEPTOS; i++) {
                    System.out.printf("%nlectura de detalles del producto %d%n%n", i + 1);

                    System.out.printf("%nIntroduzca el codigo del producto: ");
                    Codigo2 = entrada.nextLine();

                    System.out.printf("Introduzca el nombre del producto: ");
                    Nombre2 = entrada.nextLine();

                    System.out.printf("Introduzca el precio por kilo: ");
                    precioPorKilo = entrada.nextDouble();

                    System.out.printf("Introduzca el peso: ");
                    peso = entrada.nextDouble(); // 2\n

                    entrada.nextLine();// Consume el caracter que quedo en el salto de linea

                    productos[i] = new ProductoPorKilo(Codigo2, Nombre2, precioPorKilo, peso);
                }
                break;
            default:
        }

        entrada.close();

        double sumaSubtotal = 0;
        double sumaIva = 0;
        double granTotal = 0;

        System.out.printf("%nNOTA DE VENTA%n%n");

        System.out.println("Codigo\tNombre\t\tCantidad\tPrecio\tSubtotal\tIVA\tTotal");

        // Impresion de los datos
        for (Producto productoIndice : productos) {
            System.out.printf("%s\t", productoIndice.obtenerCodigo());
            System.out.printf("%s\t\t", productoIndice.obtenerNombre());
            // System.out.prinft("%.2f\", productoIndice.obtenerPiezas());

            if (productoIndice instanceof ProductoPorPieza) {
                ProductoPorPieza producto = (ProductoPorPieza) productoIndice;
                System.out.printf("%d\t\t", producto.obtenerCantidad());
                System.out.printf("%.2f\t", producto.obtenerPrecioPieza());
                System.out.printf("%.2f\t\t", producto.calcularSubtotal());
                System.out.printf("%.2f\t", producto.calcularIva());
                System.out.printf("%.2f\t\n", producto.calcularTotal());

                sumaSubtotal += producto.calcularSubtotal();
                sumaIva += producto.calcularIva();
                granTotal += producto.calcularTotal();

            }

            if (productoIndice instanceof ProductoPorKilo) {
                ProductoPorKilo producto = (ProductoPorKilo) productoIndice;
                System.out.printf("%.2f\t\t", producto.obtenerPeso());
                System.out.printf("%.2f\t", producto.obtenerPrecioPorKilo());
                System.out.printf("%.2f\t", producto.calcularSubtotal());
                System.out.printf("%.2f\t", producto.calcularIva());
                System.out.printf("%.2f\t\n", producto.calcularTotal());
             
                sumaSubtotal += producto.calcularSubtotal();
                sumaIva += producto.calcularIva();
                granTotal += producto.calcularTotal();

            }

        }
        System.out.println("\nSubtotal General \tIVA General \tTotal General");
        System.out.printf("%.2f\t\t\t  %.2f\t\t %.2f\n", sumaSubtotal, sumaIva,granTotal);
        Inventario montoInventario[] = new Inventario[CONCEPTOS];

        double sumaInventario = 0;

        for (int i = 0; i < CONCEPTOS; i++) {
            montoInventario[i] = productos[i];
            sumaInventario += montoInventario[i].CalcularValorInventario();

        }
        System.out.printf("%n%nValor total del inventario = %.2f%n%n", sumaInventario);

    }

}