
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
    private boolean control2 = true; 

    public Menu() { // CONSTRUCTOR inicializa scaner.
        this.scan = new Scanner(System.in);
    }

    public void menu1() {// MENU PRINCIPAL.
        int c = 0;
        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("\n1. Semestre");
            System.out.println("2. Cursos");
            System.out.println("3. Estudiantes");
            System.out.println("4. Terminar programa");
            System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
            c = scan.nextInt();
            scan.nextLine(); // BUFFER PARA LIMPIAR CACHÉ

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
                    control = false;
                    break;
                default: // OPCION INCORRECTA
                    System.out.println("Opción seleccionada no esta en la lista.");
                    menu1();
                    break;
            }

        } while (control);
    }

    public void submenu1() {// GESTION DE SEMESTRE
        control2 = true;
        do {
            System.out.println("\nSUBMENÚ SEMESTRE");
            System.out.println((semestre == null) ? "\n1. Crear un semestre" : "\n1. *Ya existe un semestre* "); //EVALUADOR TERNARIO 
            System.out.println(
                    (semestre == null) ? "2. Cerrar semestre (primero crea un semestre)" : "2. Cerrar semestre ");
            System.out.println((semestre == null) ? "3. Ver detalles del semestre (primero crea un semestre)"
                    : "3. Ver detalles del semestre");
            System.out.println("4. Regresar al menú principal");
            System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
            int c = scan.nextInt();
            scan.nextLine();

            switch (c) {
                case 1: // CREA SEMESTRE
                    crearSemestre();
                    continue;
                case 2: // CIERRA EL SEMESTRE
                    cerrarSemestre();
                    continue;
                case 3: // VER DETALLES DEL SEMESTRE CREADO
                    if (semestre == null) {
                        System.out.println("No existe semestre.");
                    } else {
                        semestre.verDetalles();
                    }
                    continue;
                case 4: // REGRESA AL MENÚ PRINCIPAL
                    System.out.println("Regresando al menú principal ");
                    menu1();
                    break;
                default: // OPCION INCORRECTA
                    System.out.println("Opción seleccionada no esta en la lista.");
                    continue;
            }
        } while (control2);
    }

    public void submenu2() { // SUBMENU CURSO
        System.out.println("\nSUBMENÚ CURSO");
        System.out.println((semestre == null) ? "\n1. Crear un semestre para crear el curso" : "\n1. Crea un curso");// EVALUADOR TERNARIO (ya lo conocía)
        System.out.println("2. Borrar un curso");
        System.out.println("3. Mostrar lo cursos");
        System.out.println("4. Regresar al menú principal");
        System.out.println("Escriba el número de la opción y presionar 'Enter': ");
        int c = scan.nextInt();
        scan.nextLine();

        switch (c) {
            case 1: // CREAR CURSO
                if (semestre == null) {// se AGREGA la verificacion de existencia de semestre para crear un curso
                    System.out.println("Regresa al menú principal para crear un semestre");
                    menu1();
                } else {
                    crearCurso();
                }
                break;
            case 2: // BORRAR CURSO (se AGREGA la verificacion de existencia de semestre para borrar un curso)
                if (semestre != null && semestre.getCursos().size() > 0) {
                    borrarCurso();
                } else {
                    System.out.println(
                            (semestre == null) ? "Registra un semestre." : "El semestre no tiene cursos creados aún");
                    menu1();
                }
                break;
            case 3: // MOSTRAR CURSOS (se AGREGA la verificacion de existencia de semestre para borrar un curso)
                if (semestre != null && semestre.getCursos().size() > 0) {
                    mostrarCursos();
                } else {
                    System.out.println((semestre == null) ? "Registra un semestre." : "Registra un curso");
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
        int c = scan.nextInt();
        scan.nextLine();

        switch (c) {
            case 1: // AGREGAR ESTUDIANTE( se AGREGA la verificacion de existenciade semestrepara borrar un curso)
                if (semestre == null||curso==null) {
                    System.out.println("No se puede agregar estudiante, revisa si creó un semestre y un curso.");
                    menu1();
                } else {
                    agregarEstudiante();
                }
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
        } else {
            System.out.println("Ingresa el año del semestre que quiere crear: ");
            int año = scan.nextInt();
            System.out.println(
                    "Ingresa el semestre del año \n1. primer semestre del año \n2. Segundo semestre del año: ");
            int semestreAño = scan.nextInt();
            semestre = new Semestre(año, semestreAño);
            System.out.println("Semestre creado");
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
            } else if (s == 2) {
                System.out.println("Retornando al menú.");
            } else {
                System.out.println("Opcion no valida, retorna al menú. ");
            }
        } else {
            System.out.println("No se puede cerrar un semestre si no existe uno.");
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
                        System.out.println("Ingresa el numero de estudiantes: ");
                        numeroEstudiantes = scan.nextInt();
                        if (numeroEstudiantes >= 0) {
                            curso = new Curso(nombreCurso, numeroEstudiantes, semestre);
                            semestre.agregarCurso(curso);
                            System.out.println("Curso creado");
                        }
                    } while (numeroEstudiantes < 0);
                    break;
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
        int d = scan.nextInt();

        if (d == cont) {
            System.out.println("Vuelve al menú anterior");
            submenu2();
        }

        while (true) { // verificacion añadida
            if (d > 0 && d - 1 < cursoslength) {
                semestre.getCursos().remove(d - 1);
                System.out.println("");
                System.out.println("Curso eliminado, volviendo al menú principal");
                menu1();
            }
            System.out.println("Opcion incorrecta ");
            d = scan.nextInt();
        }
    }

    public void mostrarCursos() { // MOSTRAR CURSOS ( es similar al anterior pero no teinen indices y )
        int cont = 1;
        for (int i = 0; i < semestre.getCursos().size(); i++) {
            System.out.println("Curso: " + semestre.getCursos().get(i).getNombre() + ", Estudiantes:"
                    + semestre.getCursos().get(i).getNumeroEstudiantes());
        }
        System.out.println(cont + ". Volver al menú anterior");
        System.out.println("Elige una opción y digita el número, despúes 'Enter': ");
        int d = scan.nextInt();
        while (true) { // verificacion añadida
            if (d == cont) {
                System.out.println("Vuelve al menú anterior");
                submenu2();
            }
            System.out.println("Opción incorrecta ");
            d = scan.nextInt();
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
                    estudiante = new Estudiante(nombreEstudiante);
                    curso.agregarEstudiante(estudiante);
                    System.out.println("Estudiante agregado");
                }
                break;
            } else {
                System.out.println("Para crear un curso se debe crear un semestre.");
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
        int d = scan.nextInt();
        if (d == cont) {
            System.out.println("Vuelve al menú anterior");
            submenu3();
        }
        while (true) { // verificacion añadida
            if (d > 0 && d - 1 < estudiantesLength) {
                curso.getEstudiantes().remove(d - 1);
                System.out.println("");
                System.out.println("Curso eliminado, volviendo al menú principal");
                menu1();
            }
            System.out.println("Opcion incorrecta ");
            d = scan.nextInt();
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

    public void pausa() {
        System.out.println("Presiona 'enter' para continuar: ");
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
