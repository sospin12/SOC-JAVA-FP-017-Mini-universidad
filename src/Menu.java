
// import java.rmi.ConnectIOException;
// import java.security.PublicKey;
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    // se declara semestre pero sin incializar la variable por lo que no apunta a un objeto y su valor es null por defecto.
    private Semestre semestre;
    private Curso curso; //declara curso como variable de clase.
    private Scanner scan; //declara Scaneer, ayuda a no incilizarlo en cada funcion GPT.
    private boolean control = true; // varaibles de control de ciclo.
    int c; // Para checkear el ingreso de la opcion para los menú
    final int MINIMO_ESTUDIANTES=24;
    final int DELAY=3;

    public Menu() { // CONSTRUCTOR inicializa scaner.
        this.scan = new Scanner(System.in);
    }

    ////////////////// FUNCIONES MENU ///////////////////////////
    // 
    // MENU PRINCIPAL
    // Esta funcion muestra el menu principal, entre sus lececciones esta 
    // 1. Semestre, 2. Cursos, 3. Estudiantes, 4. Terminar programa.
    // 
    // implementa:
    // Control de código: switch case, para controlar cual opcion ejecutar. 
    // Control de flujo: while, con un una variable booleana para terminar el ciclo cuando se ejecute seleccione la opcion numero 4.
    // - La función verificarEntrada(), verifica si el valor ingresado si es un número.

    public void menu1() {
        while (control) {
            System.out.println("\nMENÚ PRINCIPAL\nAcontinuacion muestra las opciones de este menú, puedes seleccionar\nde la opción 1 a la 4, sí seleccionas otro caracter diferente a\neste rango no será valido y el menú se reinicia:");
            System.out.println("\n1. Semestre");
            System.out.println("2. Cursos");
            System.out.println("3. Estudiantes");
            System.out.println("4. Terminar programa");
            System.out.print("Escriba el número de la opción deseada y presionar 'Enter': ");
            c = verificaEntrada();

            switch (c) {
                case 1:
                    retrasoTiming("1. Semestre");
                    submenu1(); // SUBMENU DE SEMESTRE.
                    break;
                case 2:
                    retrasoTiming("2. Cursos");
                    submenu2(); // SUBMENU DE CURSOS.
                    break;
                case 3:
                    retrasoTiming("3. Estudiantes");
                    submenu3(); // SUBMENU DE ESTUDIANTES.
                    break;
                case 4: // FINALIZA EL PROGRAMA.
                    retrasoTiming("4. Terminar programa");
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

    // 
    // MENU DE SEMESTRE
    //
    // Esta funcion muestra el menu principal, entre sus lececciones esta 
    // 1. Crear semestre, 2. Cerrar semestre, 3. Ver detalles del semestre, 4. Regresar al menú principal.
    // 
    // Implementa:
    // Control de código: switch case, para controlar cual opcion ejecutar. 
    // - La función verificarEntrada(), verifica si el valor ingresado si es un número.

    public void submenu1() {
            System.out.println("\nSUBMENÚ SEMESTRE\nAcontinuacion muestra las opciones de este menú, puedes seleccionar\nde la opción 1 a la 4, sí seleccionas otro caracter diferente a\n este rango no será valido y el menú se reinicia:");
            System.out.println((semestre == null) ? "\n1. Crear un semestre" : "\n1. *Ya existe un semestre* "); //EVALUADOR TERNARIO 
            System.out.println(
                    (semestre == null) ? "2. Cerrar semestre (primero crea un semestre)" : "2. Cerrar semestre ");
            System.out.println((semestre == null) ? "3. Ver detalles del semestre (primero crea un semestre)"
                    : "3. Ver detalles del semestre");
            System.out.println("4. Regresar al menú principal");
            System.out.println("Escriba el número d e la opción deseada y presionar 'Enter': ");
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
    //
    // MENU DE CURSO
    //
    // Esta funcion muestra el menu principal, entre sus lececciones esta 
    // 1. Crear un curso, 2. Cerrar un curso, 3. Mostrar los cursos, 4. Regresar al menú principal.
    // 
    // Implementa:
    // Control de código: switch case, para controlar cual opcion ejecutar. 
    // - La función verificarEntrada(), verifica si el valor ingresado si es un número.

    public void submenu2() { 
        System.out.println("\nSUBMENÚ CURSO");
        System.out.println((semestre == null) ? "\n1. Crear un semestre para crear el curso" : "\n1. Crea un curso");
        System.out.println("2. Borrar un curso");
        System.out.println("3. Mostrar lo cursos");
        System.out.println("4. Regresar al menú principal");
        System.out.println("Escriba el número de la opción y presionar 'Enter': ");
        c = verificaEntrada();

        switch (c) {
            case 1: // CREAR CURSO
                if (semestre == null) {//Cerificación de existencia de semestre para crear un curso
                    System.out.println("Regresa al menú principal para crear un semestre");
                    menu1();
                } else {
                    crearCurso();
                    menu1();
                }
                break;
            case 2: // BORRAR CURSO (Verificacion de existencia de semestre para borrar un curso)
                if (semestre != null && semestre.getCursos().size() > 0) {
                    borrarCurso();
                    menu1();
                } else {
                    System.out.println(
                            (semestre == null) ? "Registra un semestre." : "El semestre no tiene cursos creados aún");
                    submenu2();
                }
                break;
            case 3: // MOSTRAR CURSOS (Verificacion de existencia de semestre para borrar un curso)
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
    //
    // MENU DE ESTUDIANTE
    //
    // Esta funcion muestra el menu principal, entre sus lececciones esta 
    // 1. Agrega un estudiante, 2. Borrar estudiante, 3. Mostrar estudiantes, 4. Regresar al menú principal.
    // 
    // Implementa:
    // Control de código: switch case, para controlar cual opcion ejecutar. 
    // - La función verificarEntrada(), verifica si el valor ingresado si es un número.

    public void submenu3() { 
        System.out.println("\nSUBMENÚ ESTUDIANTES");
        System.out.println(
                (semestre == null) ? "\n1. Crear un semestre para agregar un estudiante" : "\n1. Agrega un estudiante");
        System.out.println("2. Borrar estudiante. ");
        System.out.println("3. Mostrar estudiantes");
        System.out.println("4. Regresar al menú principal");
        System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
        c = verificaEntrada();
        switch (c) {
            case 1: // AGREGAR ESTUDIANTE(Cerificación de existencia de semestrepara borrar un curso)
                if (semestre == null) {
                    System.out.println("No se puede agregar estudiante, revisa si creó un semestre y un curso.");
                    menu1();
                } else {
                    agregarEstudiante();
                }
                menu1();
                break;
            case 2: // BORRAR ESTUDIANTE (Cerificación de existencia de semestrepara borrar un curso)
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
            case 3:// MOSTRAR ESTUDIANTES(Cerificación de existencia de semestrepara borrar un curso)
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
        /// Este método se encarga de crear un nuevo semestre. 
        /// Primero verifica si ya existe un semestre activo.
        ///  Si es así, no permite crear uno nuevo. Si no hay un semestre activo, 
        /// solicita al usuario que ingrese el año y el semestre (primer o segundo) y 
        /// crea un nuevo objeto Semestre.
        if (semestre != null && semestre.isEstadoSemestre()) { 
            System.out.println("No se puede crear un semestre nuevo cuando el actual todavía esta abierto.");
            submenu1();
        } else {
            System.out.println("Ingresa el año del semestre que quiere crear: ");
            int anno = scan.nextInt();
            System.out.println(
                    "Ingresa el semestre del añoo \n1. primer semestre del año \n2. Segundo semestre del año: ");
            int semestreAnno = scan.nextInt();
            semestre = new Semestre(anno, semestreAnno);
            System.out.println("Semestre creado");
            menu1();
        }
    }

    public void cerrarSemestre() {
        //Este método cierra el semestre actual si existe y 
        //está activo. Solicita confirmación al usuario antes de 
        //cerrar el semestre. Si el usuario confirma, cierra el 
        //semestre y lo establece como null.
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
        // Este método permite crear un nuevo curso.
        // Primero verifica si hay un semestre activo. 
        // Luego solicita al usuario que ingrese el nombre
        // del curso y el número de estudiantes. Si el nombre 
        // del curso es válido y el número de estudiantes es mayor 
        // o igual a cero, crea un nuevo objeto Curso y lo agrega al semestre.
    
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
                    if (buscarCursoPorNombre(nombreCurso)!=null){
                        System.out.println("El curso con ese nombre ya fué creado.");
                        crearCurso();
                    }
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

    public void borrarCurso() {
        // Este método permite borrar un curso existente.
        // Muestra una lista de cursos y solicita al usuario
        // que seleccione uno para eliminar. Si el usuario selecciona//
        // una opción válida, elimina el curso seleccionado.

        int cont = 0; // contador para utilizar como indicie para la opcion "volver al menú anterior"
        int cursoslength = semestre.getCursos().size();
        boolean control2=true;
        for (int i = 0; i < cursoslength; i++) { // Recorre el arreglo dinámico (con inidice) de cusros obtenidos de la Clase Semestre
            System.out.println((i + 1) + ". " + "Curso: " + semestre.getCursos().get(i).getNombre() + ", Estudiantes:"
                    + semestre.getCursos().get(i).getNumeroEstudiantes());
            cont = i + 2;
        }
        System.out.println(cont + ". Volver al menú anterior"); // se usa variable cont
        System.out.println("Elige una opcion y digita el número, despúes 'Enter': ");
        int d = verificaEntrada();
        do {
    
            if (d == cont) {
                System.out.println("Vuelve al menú anterior");
                submenu2();
                return;
            }else{
                if (d > 0 && d - 1 < cursoslength) {
                    System.out.println("1. ");
                    semestre.getCursos().remove(d - 1);
                    System.out.println("\nCurso eliminado, volviendo al menú principal");
                    control2=false;
                    menu1();
                    return;
                }
                System.out.println("El curso no existe, intenta de nuevo");
                d = verificaEntrada();
            }
        } while (control2);
    }

    public void mostrarCursos() {
        // Este método muestra todos los cursos del semestre actual. 
        // Permite al usuario volver al menú anterior.

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
                submenu2();
            }
            break;
        }
    }

    public void agregarEstudiante() {
        // Este método permite agregar un estudiante a un curso. Primero verifica si hay un semestre activo. Luego solicita al usuario que ingrese el nombre del estudiantey el nombre del curso. Si el curso existe, agrega el estudiante al curso.


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
        // Este método permite borrar un estudiante de un curso. Muestra una 
        // lista de estudiantes y solicita al usuario que seleccione uno para
        // eliminar. Si el usuario selecciona una opción válida, elimina el
        // estudiante seleccionado.

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
        // Este método muestra todos los estudiantes de un curso.
        // Permite al usuario volver al menú anterior.

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

    public int verificaEntrada(){
        // Este método verifica si la entrada del usuario es un número.
        // Si no lo es, solicita al usuario que intente de nuevo hasta
        // que ingrese un número válido.

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
        // Este método busca un curso por su nombre en el semestre actual.
        // Si encuentra el curso, lo devuelve; de lo contrario, devuelve null.

        for (Curso curso : semestre.getCursos()) {
            if (curso.getNombre().equals(nombreCurso)) {
                return curso;
            }
        }
        return null; // Si no se encuentra el curso
    }

    public void retrasoTiming(String texto) {
        System.out.println("\nSELECCIONASTE:\n"+ texto);
        System.out.print("Cargando");
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.print(".");
                Thread.sleep(DELAY*300);
            }
            System.out.println("");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println("El delay fue interrumpido");
        } finally {
        }
    }

}
