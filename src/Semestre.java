// import java.util.Scannerr;
import java.util.List;

import java.util.ArrayList;

public class Semestre {

    // ATRIBUTES
    private boolean estadoSemestre = false;
    private int semestreAño;
    private int año;
    private List<Curso> cursos;

    // COSNTRUCTORS

    public Semestre(int año, int semestreAño) {
        this.semestreAño = semestreAño;
        this.año = año;
        estadoSemestre = true;
        this.cursos = new ArrayList<>();
    }

    public Semestre(){}

    // GETTERS
    public int getAño() {return año;}
    public boolean isEstadoSemestre() {return estadoSemestre;}
    public int getSemestreAño() {return semestreAño;}
    public List<Curso> getCursos() {return cursos;}
    
    
    //SETTERS
    public void setEstadoSemestre(boolean estadoSemestre) {this.estadoSemestre = estadoSemestre;}
    public void setSemestreAño(int semestreAño) {this.semestreAño = semestreAño;}
    public void setAño(int año) {this.año = año;}


    // METODOS
    public void cerrar() {estadoSemestre = false;} // CERRAR SEMESTRE

    public void verDetalles() { 
        if (estadoSemestre) {
            System.out.println("\n" + (getSemestreAño() < 2 ? "Primer semestre" : "Segundo semestre") + " del " + getAño());
            // Evaluador ternario
        } else {
            System.out.println("\nNo existe semestre");
        }
    }


    public void agregarCurso(Curso curso){cursos.add(curso);}



}
