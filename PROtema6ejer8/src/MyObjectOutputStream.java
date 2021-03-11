import java.io.*;
 
//Esta clase hereda sus propiedades de ObjectOutputStream
public class MyObjectOutputStream extends ObjectOutputStream  {
 
    //Sobrescribimos el método que crea la cabecera
    protected void writeStreamHeader() throws IOException
    {
        // No hacer nada.
    }

    public MyObjectOutputStream () throws IOException{
        super();
    }
    public MyObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }
}