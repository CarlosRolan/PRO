
public class Main {
	public static void main(String[] args) {
		 
        Comercial c1 = new Comercial(250, "DRM", 45, 1500);
        Repartidor r1 = new Repartidor("Zona 3", "Lucas", 23, 1200);
 
        c1.plus();
        r1.plus();
 
        System.out.println(c1);
        System.out.println(r1);
    }
}
