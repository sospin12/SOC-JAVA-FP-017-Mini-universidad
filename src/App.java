// import java.util.Scanner;

//NOMBRE
//   Universidad - Simulación de operación de una Universidad muy simple.

//SINPSIS
//   Java universidad.

//DESCRIPCION
//   Aplicación para gestionar una universidad simple

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner scan = new Scanner(System.in);
        System.out.println("NOMBRE\r\n" + //
                        "   Universidad - Simulación de operación de una Universidad muy simple.\r\n" + //
                        "\r\n" + //
                        "SINPSIS\r\n" + //
                        "   Java universidad.\r\n" + //
                        "\r\n" + //
                        "DESCRIPCION\r\n" + //
                        "   Aplicación para gestionar una universidad simple");

        System.out.println("Código realizado por: Santiago Ospina Cabarcas");

        Menu menu = new Menu();
        menu.menu1();
        
/* 
        boolean control = true;


        // MENU PRINCIPAL.
        while (control) {
            Semestre semestre;
            System.out.println("\n1. Semesstre");
            System.out.println("2. Cursos");
            System.out.println("3. Estudiantes");
            System.out.println("4. Terminar programa");
            System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
            int c = scan.nextInt();
            scan.nextLine();

            switch (c) {
                case 1:
                    submenu1();
                    continue;
                case 2:
                    submenu2();
                    continue;
                case 3:
                    submenu3();
                    continue;
                case 4:
                    control=false;
                    scan.close();
                    System.out.println("El programa a finalizado");
                    return;
                default:
                    System.out.println("Opción seleccionada no esta en la lista.");
            }
        }

    }

    // METODOS
    public static void submenu1() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n1. Crear un semesstre");
        System.out.println("2. Cerrar semestre");
        System.out.println("3. Regresar al menú principal");
        System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
        int c = scan.nextInt();
        scan.nextLine();

        switch (c) {
            case 1:
                if (semestre.isEstadoSemestre()) {
                    System.out.println("No se puede crear un semestre nuevo cuando el actual todavía esta abierto.");
                } else{
                    System.out.println("Ingresa el año del nuevo semestre: ");
                    int año = scan.nextInt();
                    System.out.println("Ingresa el semestre del año (0. primer semestre del año \n1. Segundo semestre del año ): ");
                    boolean semestreAño = scan.nextBoolean();
                    Semestre semestre1 = new Semestre(semestreAño, año);
                }
                break;
            case 2:
                semestre.cerrarSemestre();
            case 3:
                System.out.println("Regresando al menú principal ");
                break;
            default:
                System.out.println("Opción seleccionada no esta en la lista.");
        }

    }

    
    public static void submenu2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n1. Semesstre");
        System.out.println("2. Cursos");
        System.out.println("3. Regresar al menú principal");
        System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
        int c = scan.nextInt();
        scan.nextLine();

        switch (c) {
            case 1:
            case 2:
            case 3:
                System.out.println("Regresando al menú principal ");
                break;
            default:
                System.out.println("Opción seleccionada no esta en la lista.");
        }

    }
    public static void submenu3() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n1. Semesstre");
        System.out.println("2. Cursos");
        System.out.println("3. Regresar al menú principal");
        System.out.println("Escriba el número de la opción deseada y presionar 'Enter': ");
        int c = scan.nextInt();
        scan.nextLine();

        switch (c) {
            case 1:
            case 2:
            case 3:
                System.out.println("Regresando al menú principal ");
                break;
            default:
                System.out.println("Opción seleccionada no esta en la lista.");
        }
*/
    } 

}
