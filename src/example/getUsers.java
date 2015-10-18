package example;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Dave on 10/18/2015.
 */
public class getUsers {

// create 2 methods
//    The service should return all users and roles if a specific userid is NOT passed to the service.
//    The service should return all roles for the userid, if a specific userid IS passed to the service.

    //    public void getUsersAndRoles(String userId) {   // have 2 methods, if userId is null, else userId specific sql against

    public ArrayList<String> getAllUsersAndRoles() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> userAndRole = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
              "jdbc:mysql://localhost/sample", "root", "");

            statement = connection.createStatement();

            String queryString = "SELECT user_name, role_name"
                    + " FROM user_roles order by user_name, role_name";

            System.out.println("queryString: " + queryString);

            resultSet = statement.executeQuery(queryString);

            System.out.println();

            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String roleName = resultSet.getString("role_name");
                String Row = "UserName: " + userName + "  UserRole: " + roleName + "\n";
                System.out.println(" Row: " + userName + " " + roleName);
                userAndRole.add(Row);
            }

        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }

        return userAndRole;  // return Arraylist
    }


    public ArrayList<String> getOneUserRoles(String userId) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> userAndRole = new ArrayList<>();


        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sample", "root", "");

            statement = connection.createStatement();

            String name = userId;
            String queryString = "SELECT user_name, role_name"
                    + " FROM user_roles WHERE user_name =  '" + name + "'"
                    + " order by role_name";

            System.out.println("queryString: " + queryString);

            resultSet = statement.executeQuery(queryString);

            System.out.println();

            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String roleName = resultSet.getString("role_name");
                String Row = "UserName: " + userName + "  UserRole: " + roleName + "\n";
                System.out.println(" Row: " + userName + " " + roleName);
                userAndRole.add(Row);
            }

        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }

        return userAndRole;  // return Arraylist
    }

}
