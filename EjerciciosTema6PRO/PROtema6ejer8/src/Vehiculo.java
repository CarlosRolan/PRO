import java.io.Serializable;

public class Vehiculo implements Serializable{
 
    private static final long serialVersionUID = 7695874286508524707L;

    private String matricula;
    private String marca;
    transient private double tama�oDeposito;
    private String modelo;
 
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public double getTama�oDeposito() {
        return tama�oDeposito;
    }

    public String getModelo() {
        return modelo;
    }

    public Vehiculo (String matricula, String marca, double tama�oDeposito, String modelo){
        this.matricula=matricula;
        this.tama�oDeposito=tama�oDeposito;
        this.marca=marca;
        this.modelo=modelo;
    }
}