package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DatabaseUtil;

@WebServlet("/input-servlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        DatabaseUtil.initializeDatabase();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nameStr = request.getParameter("name");
        String passwordStr = request.getParameter("password");
        String genderStr = request.getParameter("gender");
        String[] foodArray = request.getParameterValues("food");
        String foodStr = (foodArray != null) ? String.join("、", foodArray) : "(未選択)";
        String hobbyStr = request.getParameter("hobby");

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                 "INSERT INTO user_inputs (name, password, gender, food, hobby) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nameStr);
            pstmt.setString(2, passwordStr);
            pstmt.setString(3, genderStr);
            pstmt.setString(4, foodStr);
            pstmt.setString(5, hobbyStr);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data successfully inserted into the database.");
            } else {
                System.out.println("Failed to insert data into the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "データの保存中にエラーが発生しました。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("name", nameStr);
        request.setAttribute("password", passwordStr);
        request.setAttribute("gender", genderStr);
        request.setAttribute("food", foodStr);
        request.setAttribute("hobby", hobbyStr);
        
        request.getRequestDispatcher("/WEB-INF/output.jsp").forward(request, response);
    }
}