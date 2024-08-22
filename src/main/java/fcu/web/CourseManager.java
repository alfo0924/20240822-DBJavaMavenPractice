package fcu.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseManager {


    private static final String URL = "jdbc:mariadb://140.134.25.66:3306/D123456_0814";
    private static final String USER = "root";
    private static final String PASSWORD = "pb2024";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[]args) throws SQLException {
        CourseManager courseManager = new CourseManager();
      courseManager.addStudent("Musk","Elon","2000-06-28","ElonMusk@x.com","USA");
    }
    public void addStudent(String firstName, String lastName, String  date_of_birth, String email, String address){
        String sql = "INSERT INTO Student (first_name, last_name, date_of_birth, email, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3,  date_of_birth);
            pstmt.setString(4, email);
            pstmt.setString(5, address);
            pstmt.executeUpdate();
        }catch (SQLException e) {
         e.printStackTrace();
        }
    }

}



