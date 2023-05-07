package sv.edu.udb.www.beans;

public class TipoUsuarioBeans {
    private int idtipousuario;
    private String tipousuario;

    public TipoUsuarioBeans(){
        this.idtipousuario=0;
        this.tipousuario="";
    }

    public TipoUsuarioBeans(int idtipousuario, String tipousuario) {
        this.idtipousuario = idtipousuario;
        this.tipousuario = tipousuario;
    }

    //Duda
    public TipoUsuarioBeans(String tipousuario){
        this.tipousuario=tipousuario;
    }

    /////////

    public int getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(int idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
}
