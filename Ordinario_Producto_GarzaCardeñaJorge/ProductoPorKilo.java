public class ProductoPorKilo extends Producto {
    // Atributos
    private double PrecioPorKilo;
    private double Peso;

    // Constructor
    public ProductoPorKilo(String Codigo, String Nombre, double PrecioPorKilo, double Peso){
        super(Codigo,Nombre);
        //Crear restriccion 
        if(PrecioPorKilo < 0.0){
            throw new IllegalArgumentException("El precio por kilo debe de ser mayor o igual a cero.");
        }
        this.PrecioPorKilo = PrecioPorKilo;

        if(Peso < 0.0){
            throw new IllegalArgumentException("El precio por peso debe de ser mayor o igual a cero.");
        }
        this.Peso = Peso;
    }

    // Metodos
    public double obtenerPeso() {
        return Peso;
    }

    public double obtenerPrecioPorKilo() {
        return PrecioPorKilo;
    }

    
    public double calcularSubtotal() {
        return Peso * PrecioPorKilo;
    }

    
    public double calcularIva() {
        return PrecioPorKilo * 0.16;
    }

    
    public double calcularTotal() {
       return calcularSubtotal() + calcularIva();
    }

    //Codigo, Nombre, PrecioPorKilo, Peso
    @Override
    public String toString() {
        return String.format("%sPrecio por kilo: %.2f%nPeso: %.2f%n",super.toString(),PrecioPorKilo,Peso);
    }

    @Override
    public double CalcularValorInventario(){
        return PrecioPorKilo * Peso;
    }
}