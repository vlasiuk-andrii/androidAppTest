
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseSelectExample {

  public static void main(String[] args) {

    Connection conn1 = null;

    try {
      String url1 = "jdbc:mysql://127.0.0.1:3306/schema1";
      String user = "user";
      String password = "user";

      conn1 = DriverManager.getConnection(url1, user, password);
      if (conn1 != null) {
        System.out.println("Connected to the database test1");
      }

      Statement statement1 =  conn1.createStatement();
      ResultSet resultSet = statement1.executeQuery("SELECT * FROM schema1.student;");


//      String[] arr = null;
//      while (resultSet.next()) {
//        String em = resultSet.getString("name");
//        arr = em.split("\n");
//        for (int i =0; i < arr.length; i++){
//          System.out.println(arr[i]);
//        }
//      }

      List allRows = new ArrayList();
      int numberColumns = 4;
      while(resultSet.next()){
        String[] currentRow = new String[numberColumns];
        for(int i = 1;i<=numberColumns;i++){
          currentRow[i-1]=resultSet.getString(i);
          System.out.print(currentRow[i-1] + " ");
        }
        System.out.println();
        allRows.add(currentRow);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn1.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }

}
