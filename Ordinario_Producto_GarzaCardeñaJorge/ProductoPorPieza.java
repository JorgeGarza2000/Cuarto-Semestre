public class ProductoPorPieza extends Producto {
    // Atributos
    private double precioPorPieza;
    private int piezas;

    // Constructor
    public ProductoPorPieza(String Codigo, String Nombre, double precioPorPieza, int piezas) {
        super(Codigo, Nombre);
        //Creando restricción
        if(precioPorPieza < 0.0){
            throw new IllegalArgumentException("El precio por pieza debe ser mayor o igual a cero.");
        }
        this.precioPorPieza = precioPorPieza;
        if(piezas < 0.0){
            throw new IllegalArgumentException("El numero de pieza debe ser mayor o igual a cero.");
        }
        this.piezas = piezas;
    }

    // Metodos
    public int obtenerCantidad() {
        return piezas;
    }

    public double obtenerPrecioPieza() {
        return precioPorPieza;
    }

    public double calcularSubtotal() {
        return precioPorPieza * piezas;
    }

    public double calcularIva() {
        return calcularSubtotal() * 0.16;
    }

    public double calcularTotal() {
        return calcularIva() + calcularSubtotal();
    }

    // Codigo, Nombre, PrecioPorPieza, Piezas
    @Override
    public String toString() {
        return String.format("%sPrecio por pieza: %.2f%nPiezas: %d%nSubtotal: %.2f%n",super.toString(),precioPorPieza,piezas,calcularSubtotal());
    }

    @Override
    public double CalcularValorInventario(){
        return precioPorPieza * piezas;
    }
}