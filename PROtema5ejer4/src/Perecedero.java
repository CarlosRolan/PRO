
public class Perecedero extends Producto {
	private int dias_a_caducar;

    public Perecedero(int dias_a_caducar, String nombre, double precio) {
        super(nombre, precio);
        this.dias_a_caducar = dias_a_caducar;
    }

    public int getDias_a_caducar() {
        return dias_a_caducar;
    }
 
    public void setDias_a_caducar(int dias_a_caducar) {
        this.dias_a_caducar = dias_a_caducar;
    }
 
    @Override
    public String toString() {
        return super.toString() + " dias_a_caducar=" + dias_a_caducar;
    }
 
    @Override
    public double calcular(int cantidad) {
        double precioFinal = super.calcular(cantidad);
        switch (dias_a_caducar) {
            case 1:
                precioFinal /= 4;
                break;
            case 2:
                precioFinal /= 3;
                break;
            case 3:
                precioFinal /= 2;
                break;
        } 
        return precioFinal;
    }
}
