
public abstract class Producto implements Inventario{

    // Atributos
    private final String Codigo;
    private final String Nombre;

    // Constructor
    public Producto(String Codigo, String Nombre) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    // Metodos

    public abstract double calcularSubtotal();

    public abstract double calcularIva();

    public abstract double calcularTotal();
    
    public String obtenerCodigo() {
        return Codigo;
    }

    public String obtenerNombre() {
        return Nombre;
    }

    @Override
    public String toString() {//Codigo %Codigo %n Nombre
        return String.format("Codigo: %s%nNombre: %s%n",Codigo,Nombre);
    }

    public abstract double CalcularValorInventario();
   

}