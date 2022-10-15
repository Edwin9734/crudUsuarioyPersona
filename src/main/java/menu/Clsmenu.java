
package menu;
import datos.Conexion;
import datos.PersonaJDBC;
import datos.UsuarioJDBC;
import domain.Persona;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Clsmenu {
private static final   Scanner scanner = new Scanner (System.in);   
private static String opcion ;
private static int opcion1 = -1;

public static void insertPersona(){
     Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion);
            Persona cambioPersona = new Persona();
            if (conexion.getAutoCommit()){conexion.setAutoCommit(false);}
            
            System.out.println("Ingrese el nombre");opcion = scanner.nextLine();cambioPersona.setNombre(opcion);//nombre  
            System.out.println("Ingrese el apellido");opcion = scanner.nextLine();cambioPersona.setApellido(opcion);
            System.out.println("Ingrese el Imail");opcion = scanner.nextLine();cambioPersona.setEmail(opcion);
            System.out.println("Ingrese el numero de telefono");opcion = scanner.nextLine();cambioPersona.setTelefono(opcion);
           
            personaJdbc.insert(cambioPersona);
          
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {conexion.rollback();}catch (SQLException ex1) {ex1.printStackTrace(System.out);
                 
            }
        }            
}
   
public static void updatePersona(){
     Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion);
            Persona cambioPersona = new Persona();
            if (conexion.getAutoCommit()){conexion.setAutoCommit(false);}
            
            System.out.println("Ingrese el id");opcion1 = Integer.parseInt(scanner.nextLine());cambioPersona.setId_persona(opcion1);//id
            System.out.println("Ingrese el nombre");opcion = scanner.nextLine();cambioPersona.setNombre(opcion);//nombre  
            System.out.println("Ingrese el apellido");opcion = scanner.nextLine();cambioPersona.setApellido(opcion);
            System.out.println("Ingrese el Imail");opcion = scanner.nextLine();cambioPersona.setEmail(opcion);
            System.out.println("Ingrese el numero de telefono");opcion = scanner.nextLine();cambioPersona.setTelefono("12345678910");
           
            personaJdbc.update(cambioPersona);
          
            conexion.commit();
        } catch (SQLException ex){ ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {conexion.rollback();}catch (SQLException ex1) {ex1.printStackTrace(System.out);}
               
        }
}
    
public static void deletePersona(){
     Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion);
            Persona cambioPersona = new Persona();
            if (conexion.getAutoCommit()){conexion.setAutoCommit(false);}
            
            System.out.println("Ingrese el id");opcion1 = Integer.parseInt(scanner.nextLine());cambioPersona.setId_persona(opcion1);//id

            personaJdbc.delete(cambioPersona);
          
            conexion.commit();
        } catch (SQLException ex){ ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {conexion.rollback();}catch (SQLException ex1) {ex1.printStackTrace(System.out);}
            
        }      
    }

public static void ListadoPersona(){
     Connection conexion = null;
    
        try {
            conexion = Conexion.getConnection();
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion);
            List<Persona> todos =  personaJdbc.select();
            if (conexion.getAutoCommit()){conexion.setAutoCommit(false);} 
             
             
            for (Persona peli : todos){ System.out.println(peli.toString()); }
                
            conexion.commit();
        } catch (SQLException ex) { ex.printStackTrace(System.out);
            
            System.out.println("Entramos al rollback");
            try {conexion.rollback();}catch (SQLException ex1) {ex1.printStackTrace(System.out);}
               
        }           
    }

//el usuario

public static void insertUsuario(){
            Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conexion);
            Usuario varUsuario = new Usuario();
            
            if (conexion.getAutoCommit()) {conexion.setAutoCommit(false);}
              
            System.out.println("Ingrese el nombre");opcion = scanner.nextLine();varUsuario.setUsername(opcion);
            System.out.println("Ingrese la contraseña");opcion = scanner.nextLine();varUsuario.setPassword(opcion);
          
            usuarioJdbc.insert(varUsuario);
            conexion.commit();
        } catch (SQLException ex) { ex.printStackTrace(System.out);
            
            System.out.println("Entramos al rollback");
            try {conexion.rollback();} 
                
            catch (SQLException ex1) {ex1.printStackTrace(System.out);}
                
        }
    }

public static void updateUsuario(){
            Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conexion);
            Usuario varUsuario = new Usuario();
            if (conexion.getAutoCommit()) {conexion.setAutoCommit(false);}
              
            System.out.println("Ingrese el id");opcion1 = Integer.parseInt(scanner.nextLine());varUsuario.setId_usuario(opcion1);
            System.out.println("Ingrese el nombre");opcion = scanner.nextLine();varUsuario.setUsername(opcion);
            System.out.println("Ingrese la contraseña");opcion = scanner.nextLine();varUsuario.setPassword(opcion);
          
            usuarioJdbc.update(varUsuario);
            conexion.commit();
        } catch (SQLException ex) {ex.printStackTrace(System.out);           
            System.out.println("Entramos al rollback");
            try {conexion.rollback();}
                
            catch (SQLException ex1) {ex1.printStackTrace(System.out);}
            
        }
    }

public static void deleteUsuario(){
            Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conexion);
            Usuario varUsuario = new Usuario();
            if (conexion.getAutoCommit()) {conexion.setAutoCommit(false);}
              
            System.out.println("Ingrese el id");opcion1 = Integer.parseInt(scanner.nextLine());varUsuario.setId_usuario(opcion1);
           
            usuarioJdbc.delete(varUsuario);
            conexion.commit();
        } catch (SQLException ex) {ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {conexion.rollback();
            } catch (SQLException ex1) {ex1.printStackTrace(System.out);}                
        }
    }

public static void ListarUsuario(){
            Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conexion);
            List<Usuario> todos =  usuarioJdbc.select();
 
            if (conexion.getAutoCommit()) {conexion.setAutoCommit(false);}
            
            
            for (Usuario usua : todos){ System.out.println(usua.toString()); }
            
            conexion.commit();
        } catch (SQLException ex) {ex.printStackTrace(System.out);
            
            System.out.println("Entramos al rollback");
            try {conexion.rollback();}catch (SQLException ex1) {ex1.printStackTrace(System.out);}
        }
    }


}
