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

        System.out.println("\nCódigo realizado por: Santiago Ospina Cabarcas");

        Menu menu = new Menu();
        menu.menu1();
        
    } 

}
