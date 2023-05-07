package sv.edu.udb.www.beans;

public class BitacorasBeans {

    private int id_bitacora;
    private String fecha_limite;
    private int id_caso;
    private String modificaciones;
    private String avance;

    public BitacorasBeans(){
        this.id_bitacora = 0;
        this.id_caso = 0;
        this.fecha_limite = "";
        this.modificaciones = "";
        this.avance = "";
    }

    public int getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(int id_bitacora) {
        this.id_bitacora = id_bitacora;
    }


    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public int getId_caso() {
        return id_caso;
    }

    public void setId_caso(int id_caso) {
        this.id_caso = id_caso;
    }

    public String getModificaciones() {
        return modificaciones;
    }

    public void setModificaciones(String modificaciones) {
        this.modificaciones = modificaciones;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }
}
