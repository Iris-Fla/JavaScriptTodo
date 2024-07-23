package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DatabaseUtil;

@WebServlet("/read-data")
public class ReadDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserData> userDataList = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user_inputs");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                UserData userData = new UserData(
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("gender"),
                    rs.getString("food"),
                    rs.getString("hobby")
                );
                userDataList.add(userData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "データの読み取り中にエラーが発生しました。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("userDataList", userDataList);
        request.getRequestDispatcher("/WEB-INF/readData.jsp").forward(request, response);
    }

    // UserDataクラスの定義（内部クラスとして）
    public static class UserData {
        private String name;
        private String password;
        private String gender;
        private String food;
        private String hobby;

        public UserData(String name, String password, String gender, String food, String hobby) {
            this.name = name;
            this.password = password;
            this.gender = gender;
            this.food = food;
            this.hobby = hobby;
        }

        // Getterメソッド
        public String getName() { return name; }
        public String getPassword() { return password; }
        public String getGender() { return gender; }
        public String getFood() { return food; }
        public String getHobby() { return hobby; }
    }
}