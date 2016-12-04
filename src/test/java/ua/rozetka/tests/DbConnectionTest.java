package ua.rozetka.tests;

import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by AntonKa on 12/4/2016.
 */
public class DbConnectionTest {




        @Test
        public void sendToDb() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/rozetka?user=root&password=");


                // Statement stmt = (Statement) conn.createStatement();
                // method which returns the requested information as rows of data
//            ResultSet result = (ResultSet) stmt.executeQuery("select * from smartphones");
//            while (result.next()) {
//                System.out.println(result.getString(1));
//            }

                //INSERT INTO `smartphones` (`id`, `name`, `price`) VALUES ('04', 'lenovo', '10000')
                String query = "INSERT INTO smartphones (id, name, price)"
                        + " values (?, ?, ? )";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, 04);
                preparedStmt.setString(2, "Nokia1");
                preparedStmt.setString(3, "10001");

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("select * from smartphones");
//            System.out.print(rs.getInt("*"));
//            String query = "select *  from smartphones";
//            ResultSet rs = st.executeQuery( query);
//            while (rs.next()) {
//                String myName = rs.getString(1);
//                String myAge = rs.getString(2);
//                System.out.println(myName + "  " + myAge);
//            }

//            while (rs.next()){
//
//            }
//                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
//                        .withHeader("group_header").withFooter("group_footer"));


//        }catch (SQLException ex){
//            System.out.println("SQLExeption: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("SQLExeption: " + ex.getErrorCode());
//        }
        }
    }

