package util;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String DB_URL = "jdbc:sqlite:" + Paths.get(System.getProperty("user.dir"), "sexyMutsuki.db").toString();

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("pien");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
        	 System.out.println(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 新しいメソッド: mutsukiKawaiiテーブルにデータを追加する
    public static void addMutsukiKawaii(String value) {
        String sql = "SELECT * FROM mutugaki";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
//            pstmt.setString(1, value);
            pstmt.executeUpdate();
            
            System.out.println("新しい値が mutsukiKawaii テーブルに追加されました: " + value);
        } catch (SQLException e) {
            System.out.println("データの追加中にエラーが発生しました");
            e.printStackTrace();
        }
    }
}