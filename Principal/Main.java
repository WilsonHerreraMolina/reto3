

package Principal;
import Vistas.*;
import Modelo.*;

public class Main {

  
    public static void main(String[] args) {
      Conexión conexion = new Conexión();
      conexion.getConnection();
      Login login = new Login();
      login.setVisible(true);
    }
    
}
