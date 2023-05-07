package sv.edu.udb.www.beans;

public class EstadoBeans {
    private int idestado;
    private String estado;

    public EstadoBeans(){
        this.idestado=0;
        this.estado="";
    }
    public EstadoBeans(int idestado, String estado) {
        this.idestado = idestado;
        this.estado = estado;
    }

    //Pendiente a comprobar porque creo que es el que se usa para mandar a obtener las cosas
    public EstadoBeans(String estado){
        this.estado=estado;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
