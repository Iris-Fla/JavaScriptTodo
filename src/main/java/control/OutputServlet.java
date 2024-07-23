package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//出力サーブレット
@WebServlet("/output-servlet")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 */
	private static final String CSS =
            ":root {\n" +
            "    --primary-color: #4CAF50;\n" +
            "    --secondary-color: #45a049;\n" +
            "    --background-color: #f0f8ff;\n" +
            "    --text-color: #333;\n" +
            "}\n" +
            "\n" +
            "* {\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    box-sizing: border-box;\n" +
            "}\n" +
            "\n" +
            "body {\n" +
            "    font-family: 'Helvetica Neue', Arial, sans-serif;\n" +
            "    background-color: var(--background-color);\n" +
            "    color: var(--text-color);\n" +
            "    line-height: 1.6;\n" +
            "    display: flex;\n" +
            "    justify-content: center;\n" +
            "    align-items: center;\n" +
            "    min-height: 100vh;\n" +
            "    padding: 20px;\n" +
            "}\n" +
            "\n" +
            ".container {\n" +
            "    background-color: white;\n" +
            "    padding: 40px;\n" +
            "    border-radius: 8px;\n" +
            "    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n" +
            "    width: 100%;\n" +
            "    max-width: 500px;\n" +
            "}\n" +
            "\n" +
            "h2 {\n" +
            "    color: var(--primary-color);\n" +
            "    margin-bottom: 20px;\n" +
            "    text-align: center;\n" +
            "    font-size: 28px;\n" +
            "}\n" +
            "\n" +
            ".input-item {\n" +
            "    margin-bottom: 15px;\n" +
            "    padding: 10px;\n" +
            "    background-color: #f9f9f9;\n" +
            "    border-radius: 4px;\n" +
            "}\n" +
            "\n" +
            ".input-label {\n" +
            "    font-weight: bold;\n" +
            "    color: var(--primary-color);\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            "\n" +
            ".input-value {\n" +
            "    font-size: 16px;\n" +
            "}\n" +
            "\n" +
            ".back-link {\n" +
            "    display: inline-block;\n" +
            "    margin-top: 20px;\n" +
            "    color: var(--primary-color);\n" +
            "    text-decoration: none;\n" +
            "    font-weight: bold;\n" +
            "    transition: color 0.3s;\n" +
            "}\n" +
            "\n" +
            ".back-link:hover {\n" +
            "    color: var(--secondary-color);\n" +
            "}\n" +
            "\n" +
            ".footer-note {\n" +
            "    margin-top: 30px;\n" +
            "    font-size: 12px;\n" +
            "    color: #777;\n" +
            "    text-align: center;\n" +
            "}";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストスコープからデータ取得
		String nameStr = (String) request.getAttribute("name");
		String passwordStr = (String) request.getAttribute("password");
		String genderStr = (String) request.getAttribute("gender");
		String foodStr = (String) request.getAttribute("food");
		String hobbyStr = (String) request.getAttribute("hobby");
		
		// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
		response.setContentType("text/html; charset=UTF-8");

		// レスポンス書き出し用オブジェクトの取得
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>入力内容</title>");
		out.println("<style>");
		out.println(CSS);
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <div class=\"container\">");
		out.println("        <h2>入力内容</h2>");
		out.println("        <div class=\"input-item\">");
		out.println("            <div class=\"input-label\">お名前</div>");
		out.println("            <div class=\"input-value\">" + nameStr + "</div>");
		out.println("        </div>");
		out.println("        <div class=\"input-item\">");
		out.println("            <div class=\"input-label\">だだもれパスワード</div>");
		out.println("            <div class=\"input-value\">" + passwordStr + "</div>");
		out.println("        </div>");
		out.println("        <div class=\"input-item\">");
		out.println("            <div class=\"input-label\">性別</div>");
		out.println("            <div class=\"input-value\">" + genderStr + "</div>");
		out.println("        </div>");
		out.println("        <div class=\"input-item\">");
		out.println("            <div class=\"input-label\">すきなごはん</div>");
		out.println("            <div class=\"input-value\">" + foodStr + "</div>");
		out.println("        </div>");
		out.println("        <div class=\"input-item\">");
		out.println("            <div class=\"input-label\">好きな鶏の部位</div>");
		out.println("            <div class=\"input-value\">" + hobbyStr + "</div>");
		out.println("        </div>");
		// 他の入力項目も同様に出力
		out.println("        <a href=\"/sexyMutsuki\" class=\"back-link\">入力フォームへ戻る</a>");
		out.println("        <div class=\"footer-note\">");
		out.println("            これは、OutputServletで書き出しています。");
		out.println("        </div>");
		out.println("    </div>");
		out.println("</body>");
		out.println("</html>");
	}

}

