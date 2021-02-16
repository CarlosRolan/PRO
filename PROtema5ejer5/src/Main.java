
public class Main {
	public static void main(String[] args) {
        Almacen a = new Almacen();
        Bebida b;
        for(int i=0;i<10;i++){
            switch(i%2){
                case 0:
                    b=new AguaMineral("manantial1", 1.5, 5, "bezoya");
                    a.agregarBebida(b);
                    break;
                case 1:
                    b=new BebidaAzucarada(0.2, true, 1.5, 10, "Coca Cola");
                    a.agregarBebida(b);
                    break;
            }
        }
        a.mostrarBebidas();
        System.out.println("Precio de todas las bebidas "+a.calcularPrecioBebidas());
        a.eliminarBebida(4);
        a.mostrarBebidas();  
        System.out.println("Precio de todas las bebidas "+a.calcularPrecioBebidas());        
        System.out.println("Precio de todas las bebidas de la marca Bezoya " +a.calcularPrecioBebidas("bezoya"));        
        System.out.println("Calcular el precio de la columna 0: "+a.calcularPrecioBebidas(0));    
    }
}
