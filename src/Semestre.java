// import java.util.Scannerr;
import java.util.List;

import java.util.ArrayList;

public class Semestre {

    // ATRIBUTES
    private boolean estadoSemestre = false;
    private int semestreAnno;
    private int anno;
    private List<Curso> cursos;

    // COSNTRUCTORS

    public Semestre(int anno, int semestreAnno) {
        this.semestreAnno = semestreAnno;
        this.anno = anno;
        estadoSemestre = true;
        this.cursos = new ArrayList<>();
    }

    public Semestre(){}

    // GETTERS
    public int getAnno() {return anno;}
    public boolean isEstadoSemestre() {return estadoSemestre;}
    public int getSemestreAnno() {return semestreAnno;}
    public List<Curso> getCursos() {return cursos;}
    
    
    //SETTERS
    public void setEstadoSemestre(boolean estadoSemestre) {this.estadoSemestre = estadoSemestre;}
    public void setSemestreAnno(int semestreAnno) {this.semestreAnno = semestreAnno;}
    public void setAnno(int anno) {this.anno = anno;}


    // METODOS
    public void cerrar() {estadoSemestre = false;} // CERRAR SEMESTRE

    public void verDetalles() { 
        if (estadoSemestre) {
            System.out.println("\n" + (getSemestreAnno() < 2 ? "Primer semestre" : "Segundo semestre") + " del " + getAnno());
            // Evaluador ternario
        } else {
            System.out.println("\nNo existe semestre");
        }
    }


    public void agregarCurso(Curso curso){cursos.add(curso);}



}
