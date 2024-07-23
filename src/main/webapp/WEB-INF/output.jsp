<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>入力内容</title>
    <style>
        :root {
            --primary-color: #4CAF50;
            --secondary-color: #45a049;
            --background-color: #f0f8ff;
            --text-color: #333;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Helvetica Neue', Arial, sans-serif;
            background-color: var(--background-color);
            color: var(--text-color);
            line-height: 1.6;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }

        h2 {
            color: var(--primary-color);
            margin-bottom: 20px;
            text-align: center;
            font-size: 28px;
        }

        .input-item {
            margin-bottom: 15px;
            padding: 10px;
            background-color: #f9f9f9;
            border-radius: 4px;
        }

        .input-label {
            font-weight: bold;
            color: var(--primary-color);
            margin-bottom: 5px;
        }

        .input-value {
            font-size: 16px;
        }

        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: var(--primary-color);
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }

        .back-link:hover {
            color: var(--secondary-color);
        }

        .footer-note {
            margin-top: 30px;
            font-size: 12px;
            color: #777;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>入力内容</h2>
        <div class="input-item">
            <div class="input-label">お名前</div>
            <div class="input-value">${name}</div>
        </div>
        <div class="input-item">
            <div class="input-label">パスワード</div>
            <div class="input-value">${password}</div>
        </div>
        <div class="input-item">
            <div class="input-label">恋愛対象</div>
            <div class="input-value">${gender}</div>
        </div>
        <div class="input-item">
            <div class="input-label">食べていそうな物</div>
            <div class="input-value">${food}</div>
        </div>
        <div class="input-item">
            <div class="input-label">好きな鶏の部位</div>
            <div class="input-value">${hobby}</div>
        </div>
        <a href="/sexyMutsuki" class="back-link">入力フォームへ戻る</a>
        <div class="footer-note">
            これは、JSPで表示しています。
        </div>
    </div>
</body>
</html>