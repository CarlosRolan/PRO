
public class Lavadora extends Electrodomestico {
	private final static int CARGA_DEF=5;
	  
    private int carga;
  
    public int getCarga() {
        return carga;
    }
  
    public double precioFinal(){
        //Invocamos el m�todo precioFinal del m�todo padre
        double plus=super.precioFinal();
        //a�adimos el c�digo necesario
        if (carga>30){
            plus+=50;
        }
        return plus;
    }
  
    public Lavadora(){
        this(PRECIO_BASE_DEF, PESO_DEF, CONSUMO_ENERGETICO_DEF, COLOR_DEF, CARGA_DEF);
    }
  
    public Lavadora(double precioBase, double peso){
        this(precioBase, peso, CONSUMO_ENERGETICO_DEF, COLOR_DEF, CARGA_DEF);
    }
  
    public Lavadora(double precioBase, double peso, char consumoEnergetico, String color, int carga){
        super(precioBase,peso, consumoEnergetico,color);
        this.carga=carga;
    }
}
