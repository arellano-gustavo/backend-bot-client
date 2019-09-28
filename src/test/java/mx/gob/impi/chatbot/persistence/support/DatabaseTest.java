package mx.gob.impi.chatbot.persistence.support;

import java.sql.*;

public class DatabaseTest {
    static String login = "sa";
    static String password = "gustavo";
    static String url = "jdbc:h2:tcp://api.kebblar.capital:1521/h2-data";

    public static void main(String[] args) throws Exception
    {
       Connection conn = null;

       try
       {
          Class.forName("org.h2.Driver").newInstance();

          conn = DriverManager.getConnection(url,login,password);

          if (conn != null)
          {
             System.out.println("Conexión a base de datos "+url+" ... Ok");
             conn.close();
          }
       }
       catch(SQLException ex)
       {
          System.out.println(ex);
       }
       catch(ClassNotFoundException ex)
       {
          System.out.println(ex);
       }

    }
}
