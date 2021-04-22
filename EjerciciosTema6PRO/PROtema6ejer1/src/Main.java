import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String file="prueba.txt";
        try(
        	FileReader fr=new FileReader (file)){
            int valor=fr.read();
            while(valor!=-1){
                //Si el caracter es un espacio no lo escribe
                if(valor!=32){
                    System.out.print((char)valor);
                }
                valor=fr.read();
            }
            fr.close();
        }catch(FileNotFoundException e) {
        	System.out.println("El archivo no existe! "+e);
        } catch(IOException e){
            System.out.println("Problemas con la E/S "+e);
        }
    }
}