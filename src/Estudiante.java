public class Estudiante extends Curso{

    private String nombre;
    private Curso curso;

    // CONSTRUCTORES
    public Estudiante(String nombre, Curso curso){this.nombre=nombre;this.curso=curso;}
    public Estudiante(){}


    // GETTER
    public String getNombre() { return nombre; }
    public Curso getCurso() { return curso; }


    // SETTER
    public void setNombre(String nombre) {this.nombre = nombre;}
    

}
