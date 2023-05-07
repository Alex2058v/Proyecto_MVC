package sv.edu.udb.www.beans;

public class DepartamentoBeans {
    private int iddepartamento;
    private String departamento;

    public DepartamentoBeans(){
        this.iddepartamento=0;
        this.departamento="";
    }

    public DepartamentoBeans(int iddepartamento, String departamento) {
        this.iddepartamento = iddepartamento;
        this.departamento = departamento;
    }

    //La duda que tengo
    public DepartamentoBeans(String departamento){
        this.departamento=departamento;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}

