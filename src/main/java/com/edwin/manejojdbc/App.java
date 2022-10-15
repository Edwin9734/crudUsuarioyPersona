
package com.edwin.manejojdbc;
import datos.PersonaJDBC;
import java.sql.Connection;
import java.util.Scanner;
import menu.Clsmenu;

public class App {
private static int opcion = -1;
private static final   Scanner scanner = new Scanner (System.in);
private static Clsmenu P;

    public static void main(String[] args) {
        
         
     
        
         while (opcion != 3) {
            try {
                System.out.println("Elija opcion:\n"
                        + "1.- TABLA DE PERSONAS\n"
                        + "2.- TABLA DE USUARIOS\n"
                        + "3.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                       
                        System.out.println("PERSONAS");
                       Mpersona();
                        break;
                    case 2:
                        System.out.println("USUARIOS");
                       Musuario();                   
                        break;
                    case 3:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
    private static void Mpersona(){
         Connection conexion = null;
         
        PersonaJDBC personaJdbc = new PersonaJDBC(conexion);
        while (opcion != 0) {
            try {
                System.out.println("Elija opcion:\n"
                        + "1.- Visualizar la lista del personal\n"
                        + "2.- Agregar una persona\n"
                        + "3.- Modificar datos de las personas\n"
                        + "4.- Borrar personal\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                       
                        System.out.println("Lista");
                        personaJdbc.select();
                         P.ListadoPersona();
                        break;
                    case 2:
                        System.out.println("Ingrese los datos");
                        P.insertPersona();                    
                        break;
                    case 3:
                        System.out.println("Digite los nuevos atributos");
                        P.updatePersona();
                        break;
                    case 4:
                        System.out.println("Ingrese los datos");                       
                        P.deletePersona();
                        break;
                    case 0:
                        System.out.println("Cerrada");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
        
    }  
    private static void Musuario(){
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n"
                        + "1.- Visualizar el catalogo de Usuarios\n"
                        + "2.- Agregar Usuario\n"
                        + "3.- Modificar datos de Usuarios\n"
                        + "4.- borrar Usuario\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        System.out.println("Lista");
                       P.ListarUsuario();
                        break;
                    case 2:
                       P.insertUsuario();                     
                        break;
                    case 3:
                       P.updateUsuario();
                        break;
                    case 4:
                       P.deleteUsuario();
                        break;
                    case 0:
                        System.out.println("Cerrada");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
        
    } 
    
}
