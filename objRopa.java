public class objRopa
{
    private String marca;
    private int referencia;
    private int cantidad;
    private double precio;

    public objRopa(int cantidad, String marca, double precio, int referencia) 
    {
        this.cantidad = cantidad;
        this.marca = marca;
        this.precio = precio;
        this.referencia = referencia;
    }
    public objRopa() {
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}