
// import java.rmi.ConnectIOException;
// import java.security.PublicKey;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.List;
import java.util.Scanner;

public class Menu {
    // se declara semestre pero sin incializar la variable porlo que no aputa a un objeto y su valor es null por defecto.
    private Semestre semestre; 

    private Curso curso; //declara curso como variable de clase.
    private Scanner scan; //declara Scaneer, ayuda a no incilizarlo en cada funcion GPT.
    private boolean control = true; // varaibles de control de ciclo.
    int c; // Para checkear el ingreso de la opcion para los menú
    final int MINIMO_ESTUDIANTES=24;

    public Menu() { // CONSTRUCTOR inicializa scaner.
        this.scan = new Scanner(System.in);
    }

    public void menu1() {// MENU PRINCIPAL.
        while (control) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("\n1. Semestre");
            System.out.println("2. Cursos");
            System.out.println("3. Estudiantes");
            System.out.println("4. Terminar programa");
            System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
            c = verificaEntrada();

            switch (c) {
                case 1:
                    submenu1(); // SUBMENU DE SEMESTRE.
                    break;
                case 2:
                    submenu2(); // SUBMENU DE CURSOS.
                    break;
                case 3:
                    submenu3(); // SUBMENU DE ESTUDIANTES.
                    break;
                case 4: // FINALIZA EL PROGRAMA.
                    System.out.println("El programa termina");
                    control=false;
                    break;
                default: // OPCION INCORRECTA
                    System.out.println("Opción seleccionada no esta en la lista.");
                    menu1();
                    break;
            }
        }
    }

    public void submenu1() {// GESTION DE SEMESTRE
            System.out.println("\nSUBMENÚ SEMESTRE");
            System.out.println((semestre == null) ? "\n1. Crear un semestre" : "\n1. *Ya existe un semestre* "); //EVALUADOR TERNARIO 
            System.out.println(
                    (semestre == null) ? "2. Cerrar semestre (primero crea un semestre)" : "2. Cerrar semestre ");
            System.out.println((semestre == null) ? "3. Ver detalles del semestre (primero crea un semestre)"
                    : "3. Ver detalles del semestre");
            System.out.println("4. Regresar al menú principal");
            System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
            c = verificaEntrada();

            switch (c) {
                case 1: // CREA SEMESTRE
                    crearSemestre();
                    break;
                case 2: // CIERRA EL SEMESTRE
                    cerrarSemestre();
                    break;
                case 3: // VER DETALLES DEL SEMESTRE CREADO
                    if (semestre == null) {
                        System.out.println("No existe semestre.");
                    } else {
                        semestre.verDetalles();
                    }
                    menu1();
                    break;
                case 4: // REGRESA AL MENÚ PRINCIPAL
                    System.out.println("Regresando al menú principal ");
                    menu1();
                    break;
                default: // OPCION INCORRECTA
                    System.out.println("Opción seleccionada no esta en la lista.");
                    submenu1();
            }
    }

    public void submenu2() { // SUBMENU CURSO
        System.out.println("\nSUBMENÚ CURSO");
        System.out.println((semestre == null) ? "\n1. Crear un semestre para crear el curso" : "\n1. Crea un curso");// EVALUADOR TERNARIO (ya lo conocía)
        System.out.println("2. Borrar un curso");
        System.out.println("3. Mostrar lo cursos");
        System.out.println("4. Regresar al menú principal");
        System.out.println("Escriba el número de la opción y presionar 'Enter': ");
        c = verificaEntrada();

        switch (c) {
            case 1: // CREAR CURSO
                if (semestre == null) {// se AGREGA la verificacion de existencia de semestre para crear un curso
                    System.out.println("Regresa al menú principal para crear un semestre");
                    menu1();
                } else {
                    crearCurso();
                    menu1();
                }
                break;
            case 2: // BORRAR CURSO (se AGREGA la verificacion de existencia de semestre para borrar un curso)
                if (semestre != null && semestre.getCursos().size() > 0) {
                    borrarCurso();
                    menu1();
                } else {
                    System.out.println(
                            (semestre == null) ? "Registra un semestre." : "El semestre no tiene cursos creados aún");
                    submenu2();
                }
                break;
            case 3: // MOSTRAR CURSOS (se AGREGA la verificacion de existencia de semestre para borrar un curso)
                if (semestre != null && semestre.getCursos().size() > 0) {
                    mostrarCursos();
                } else {
                    System.out.println((semestre == null) ? "Registra un semestre." : "el semestre no tiene cursos creado aún.");
                    menu1();
                }
                break;
            case 4: // REGRESA AL MENÚ PRINCIPAL
                System.out.println("Regresando al menú principal ");
                menu1();
                break;
            default: // LA OPCION NO ESTA EN LA LISTA
                System.out.println("Opción seleccionada no esta en la lista.");
                submenu2();
        }
    }

    public void submenu3() { // SUBMENU DE ESTUDIANTES
        System.out.println("\nSUBMENÚ ESTUDIANTES");
        System.out.println(
                (semestre == null) ? "\n1. Crear un semestre para agregar un estudiante" : "\n1. Agrega un estudiante");
        System.out.println("2. Borar estudiante. ");
        System.out.println("3. Mostrar estudiantes");
        System.out.println("4. Regresar al menú principal");
        System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
        c = verificaEntrada();
        switch (c) {
            case 1: // AGREGAR ESTUDIANTE( se AGREGA la verificacion de existenciade semestrepara borrar un curso)
                if (semestre == null) {
                    System.out.println("No se puede agregar estudiante, revisa si creó un semestre y un curso.");
                    menu1();
                } else {
                    agregarEstudiante();
                }
                menu1();
                break;
            case 2: // BORRAR ESTUDIANTE ( se AGREGA la verificacion de existenciade semestrepara borrar un curso)
                if (semestre != null && curso.getEstudiantes().size() > 0) {
                    borrarEstudiante();
                    break;
                } else {
                    System.out.println(
                            (semestre == null) ? "Registra un semestre."
                                    : "El semestre no tiene estudiantes agregados aún");
                    menu1();
                    break;
                }
            case 3:// MOSTRAR ESTUDIANTES( se AGREGA la verificacion de existenciade semestrepara borrar un curso)
                if (semestre != null && curso.getEstudiantes().size() > 0) {
                    mostrarEstudiantes();
                    break;
                } else {
                    System.out.println((semestre == null) ? "Registra un semestre."
                            : "el semestre no tiene estudiantes matriculados, se debe volver al menú principal");
                    menu1();
                    break;
                }
            case 4:
                System.out.println("Regresando al menú principal ");
                menu1();
                break;
            default:
                System.out.println("Opción seleccionada no esta en la lista.");
                submenu3();
        }
    }

    //////////////////////////// METODOS DE SOPORTE //////////////////////////////
    public void crearSemestre() {
        // si semestre fue inicializado y si el estado del semestre = true, no se crea semestre.
        //  Importante notar primero se evalua si fue inicializado. GPT "semestre != null"
        if (semestre != null && semestre.isEstadoSemestre()) { 
            System.out.println("No se puede crear un semestre nuevo cuando el actual todavía esta abierto.");
            submenu1();
        } else {
            System.out.println("Ingresa el año del semestre que quiere crear: ");
            int año = scan.nextInt();
            System.out.println(
                    "Ingresa el semestre del año \n1. primer semestre del año \n2. Segundo semestre del año: ");
            int semestreAño = scan.nextInt();
            semestre = new Semestre(año, semestreAño);
            System.out.println("Semestre creado");
            menu1();
        }
    }

    public void cerrarSemestre() {
        if (semestre != null && semestre.isEstadoSemestre()) {
            System.out.println("Esta seguro que quiere cerrar el semestre?: \n1. Si \n2. No");
            int s = scan.nextInt();
            if (s == 1) {
                semestre.cerrar();
                semestre = null;
                System.out.println("\nSemestre cerrado. ");
                menu1();
            } else if (s == 2) {
                System.out.println("Retornando al menú anterior.");
                submenu1();
            } else {
                System.out.println("Opcion no valida, retorna al menú anterior. ");
                submenu1();
            }
        } else {
            System.out.println("No se puede cerrar un semestre si no existe uno.");
            submenu1();
        }
    }

    public void crearCurso() {
        String palabraClave = "";
        String nombreCurso;
        int numeroEstudiantes;

        System.out.println("Ingrese el nombre para el curso, \nescribe 'CANCELAR' para volver al menú anterior: ");
        while (!palabraClave.equals("CANCELAR")) {
            if (semestre.isEstadoSemestre()) {
                nombreCurso = scan.nextLine();
                while (nombreCurso.matches("")) {
                    System.out.println("Ingrese el nombre para el curso: ");
                    nombreCurso = scan.nextLine();
                }
                if (nombreCurso.equals("CANCELAR")) {
                    System.out.println("Regresa al menú anterior. ");
                    submenu2();
                    break;
                }
                if (nombreCurso.matches("^[a-zA-Z\\s]+$")) {// expresiones regulares GPT
                    do {
                        System.out.println("Ingresa el número de estudiantes, debe ser mayor a cero: ");
                        numeroEstudiantes = verificaEntrada();
                        if (numeroEstudiantes >= 0) { // verifica si el numero de estudiantes si es mayor a cero.
                            curso = new Curso(nombreCurso, numeroEstudiantes, semestre);
                            semestre.agregarCurso(curso);
                            System.out.println("Curso creado");
                        }
                    } while (numeroEstudiantes < 0);
                    break;
                } else{
                    System.out.println("nombre no valido, intenta de nuevo. ");
                }
            } else {
                System.out.println("Para crear un curso se debe crear un semestre.");
            }
        }

    }

    public void borrarCurso() { // BORRAR CURSO
        int cont = 0; // contador para utilizar como indicie para la opcion "volver al menú anterior"
        int cursoslength = semestre.getCursos().size();
        for (int i = 0; i < cursoslength; i++) { // Recorre el arreglo dinámico (con inidice) de cusros obtenidos de la Clase Semestre
            System.out.println((i + 1) + ". " + "Curso: " + semestre.getCursos().get(i).getNombre() + ", Estudiantes:"
                    + semestre.getCursos().get(i).getNumeroEstudiantes());
            cont = i + 2;
        }
        System.out.println(cont + ". Volver al menú anterior"); // se usa variable cont
        System.out.println("Elige una opcion y digita el número, despúes 'Enter': ");
        int d = verificaEntrada();

        if (d == cont) {
            System.out.println("Vuelve al menú anterior");
            submenu2();
            return;
        }else{
            while (cursoslength-1==semestre.getCursos().size()) { // verificacion añadida
                if (d > 0 && d - 1 < cursoslength) {
                    semestre.getCursos().remove(d - 1);
                    System.out.println("\nCurso eliminado, volviendo al menú principal");
                    return;
                }
                System.out.println("Opcion incorrecta, intenta de nuevo");
                d = scan.nextInt();
                scan.nextLine(); 
            }
        }
    }

    public void mostrarCursos() { // MOSTRAR CURSOS ( es similar al anterior pero no teinen indices y )
        for (int i = 0; i < semestre.getCursos().size(); i++) {
            System.out.println("Curso: " + semestre.getCursos().get(i).getNombre() + ", Estudiantes:"
                    + semestre.getCursos().get(i).getNumeroEstudiantes());
        }
        System.out.println("A. Volver al menú anterior");
        System.out.println("Elige una opción y digita el número, despúes 'Enter': ");
        char d = scan.nextLine().charAt(0);
        while (true) { // verificacion añadida
            if (d == 'A') {
                System.out.println("Vuelve al menú anterior");
                submenu2();
                break;
            }else{
                System.out.println("Opción invalida. *Sale en silla de reudas* ");
                System.out.println("A. Volver al menú anterior");
                d = scan.nextLine().charAt(0);
            }
            break;
        }
    }

    public void agregarEstudiante() {
        String palabraClave = "";
        String nombreEstudiante;
        Estudiante estudiante;

        System.out.println("Ingrese el nombre para el estudiante, \nescribe 'CANCELAR' para volver al menú anterior: ");
        while (!palabraClave.equals("CANCELAR")) {
            if (semestre.isEstadoSemestre()) {
                nombreEstudiante = scan.nextLine();
                while (nombreEstudiante.matches("")) {
                    System.out.println("Ingrese el nombre para el estudiante: ");
                    nombreEstudiante = scan.nextLine();
                }
                if (nombreEstudiante.equals("CANCELAR")) {
                    System.out.println("Regresa al menú anterior. ");
                    submenu3();
                    break;
                }
                if (nombreEstudiante.matches("^[a-zA-Z\\s]+$")) {// expresiones regulares GPT
                    System.out.println("Ingrese el nombre del curso: ");
                    String cursoNombre = scan.nextLine();
                    Curso curso = buscarCursoPorNombre(cursoNombre);
                    
                    if (curso != null) {
                        estudiante = new Estudiante(nombreEstudiante, curso);
                        curso.agregarEstudiante(estudiante);
                        System.out.println("Estudiante agregado");
                    } else {
                        System.out.println("Estudiante no agregado por que el curso no fue encontrado.");
                    }
                }
                break;
            } else {
                System.out.println("Para crear un estudiante se debe crear un semestre.");
            }
        }
    }

    public void borrarEstudiante() {
        int cont = 0;
        int estudiantesLength = curso.getEstudiantes().size();
        for (int i = 0; i < estudiantesLength; i++) {
            System.out.println((i + 1) + ". " + "Estudiante: " + curso.getEstudiantes().get(i).getNombre());
            cont = i + 2;
        }
        System.out.println(cont + ". Volver al menú anterior");
        System.out.println("Elige una opcion y digita el número, despúes 'Enter': ");
        int d = verificaEntrada();

        if (d == cont) {
            System.out.println("Vuelve al menú anterior");
            submenu3();
            return;
        }else{
            while (estudiantesLength-1 != curso.getEstudiantes().size()) { // verificacion añadida
                if (d > 0 && d <= estudiantesLength) {
                    curso.getEstudiantes().remove(d - 1);
                    System.out.println("");
                    System.out.println("Estudiante eliminado, volviendo al menú principal");
                    return;
                }else{
                    System.out.println("Opcion incorrecta ");
                    d = scan.nextInt();
                    scan.nextLine(); 
                }
            }

        }
    }

    public void mostrarEstudiantes() {
        for (int i = 0; i < curso.getEstudiantes().size(); i++) {
            System.out.println("Estudiante: " + curso.getEstudiantes().get(i).getNombre());
        }
        System.out.println("A. Volver al menú anterior");
        System.out.println("Escribe la opción, despúes 'Enter': ");
        while (true) { // verificacion añadida
            String input = scan.nextLine();
            if (input.isEmpty()) {
                System.out.println("Opción incorrecta. Intente de nuevo: ");
                continue;
            }
            char d = input.charAt(0);
            if (d == 'A') {
                System.out.println("Vuelve al menú anterior");
                submenu3();
            }
            System.out.println("Opción incorrecta ");
            d = scan.nextLine().charAt(0);
        }
    }

    // Esta fucnion verifica si se ingresan números, si no, no deja que el programa pare capturando el error
    public int verificaEntrada(){ 
        while (true) {
            try {
                c = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Sólo números porfavor, intenta de nuevo");
            }
        }
        return c;
    }
    public Curso buscarCursoPorNombre(String nombreCurso) {
        for (Curso curso : semestre.getCursos()) {
            if (curso.getNombre().equals(nombreCurso)) {
                return curso;
            }
        }
        return null; // Si no se encuentra el curso
    }





/* 
    public void eliminaEstudiante(List<Estudiante> estudiantes, int d){
        while (true) { // verificacion añadida
            if (d > 0 && d - 1 < estudiantes.size()) {
                estudiantes.remove(d - 1);
                System.out.println("");
                System.out.println("Estudiante eliminado, volviendo al menú principal");
                menu1();
            }
            System.out.println("Opcion incorrecta ");
            d = scan.nextInt();
        }
    }
    public void eliminaClase(List<Curso> cursos, int d){
        while (true) { // verificacion añadida
            if (d > 0 && d - 1 < cursos.size()) {
                cursos.remove(d - 1);
                System.out.println("");
                System.out.println("Curso eliminado, volviendo al menú principal");
                menu1();
            }
            System.out.println("Opcion incorrecta ");
            d = scan.nextInt();
        }
    } */

}
