import java.util.ArrayList;
import java.util.List;

public class Curso extends Semestre{

    private String nombre;
    // private boolean estadoCurso=true;
    private int numeroEstudiantes;
    private Semestre semestre;
    private List<Estudiante> estudiantes;
    // private String codigoSemestre;


    public Curso(String nombre, int numeroEstudiantes, Semestre semestre){
        if (numeroEstudiantes<0&&semestre.isEstadoSemestre()==false) {
            System.out.println("No se puede crear el curso.");            
        } else{
            this.numeroEstudiantes=numeroEstudiantes;
            // this.estadoCurso=true;
            this.semestre=semestre;
            this.nombre=nombre;
            this.estudiantes = new ArrayList<>();
        }

    }

    public Curso(){}

    // GETTERS
    public String getNombre() {return nombre;}
    public int getNumeroEstudiantes() {return numeroEstudiantes;}
    public Semestre getSemestre() {return semestre;}
    
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // SETTERS
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setNumeroEstudiantes(int numeroEstudiantes) {this.numeroEstudiantes = numeroEstudiantes;}
    public void setSemestre(Semestre semestre) {this.semestre = semestre;}
    


    //METODOS
    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }



}
