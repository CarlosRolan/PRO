
public class Almacen {
	private Bebida[][] estanteria;
	 
    public Almacen(int filas, int columnas) {
        estanteria = new Bebida[filas][columnas];
    }
 
    public Almacen() {
        estanteria = new Bebida[5][5];
    }

    public void agregarBebida(Bebida b) {
        boolean encontrado = false;
        for (int i = 0; i < estanteria.length && !encontrado; i++) {
            for (int j = 0; j < estanteria[0].length && !encontrado; j++) {
                if (estanteria[i][j] == null) {
                    estanteria[i][j] = b; 
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            System.out.println("Bebida añadida");
        } else {
            System.out.println("No se ha podido añadir la bebida");
        }
 
    }
 
    public void eliminarBebida(int id) {
        boolean encontrado = false;
        for (int i = 0; i < estanteria.length && !encontrado; i++) {
            for (int j = 0; j < estanteria[0].length && !encontrado; j++) {
                if (estanteria[i][j] != null) {
                    if (estanteria[i][j].getId() == id) {
                        estanteria[i][j] = null; 
                        encontrado = true;
                    }
                }
            }
        }
        if (encontrado) {
            System.out.println("Bebida eliminada");
        } else {
            System.out.println("No existe la bebida");
        }
 
    }
 
    public void mostrarBebidas() {
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {
                    System.out.println("fila " + i + ", columna: " + j + " Bebida: " + estanteria[i][j].toString());
                }
            }
        }
 
    }
 
    public double calcularPrecioBebidas() {
        double precioTotal = 0;
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {
                    precioTotal += estanteria[i][j].getPrecio();
                }
            }
        }
 
        return precioTotal;
 
    }
 
    public double calcularPrecioBebidas(String marca) {
        double precioTotal = 0;
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {
                    if (estanteria[i][j].getMarca().equalsIgnoreCase(marca)) {
                        precioTotal += estanteria[i][j].getPrecio(); 
                    }
                }
            }
        }
        return precioTotal;
    }
 
    public double calcularPrecioBebidas(int columna) {
        double precioTotal = 0;
        if (columna >= 0 && columna < estanteria[0].length) {
            for (int i = 0; i < estanteria.length; i++) {
                if (estanteria[i][columna] != null) { 
                    precioTotal += estanteria[i][columna].getPrecio();
                }
            }
        } else {
            System.out.println("La columna debe estar entre 0 y " + estanteria[0].length);
        }
        return precioTotal;
    }
}
