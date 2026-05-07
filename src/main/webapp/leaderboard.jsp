<%@page import="com.quizapp.model.QuizResult"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Leaderboard</title>
    <style>
        body { font-family: Arial; background: #f0f0f0;
               padding: 20px; }
        .container { background: white; padding: 30px;
                     border-radius: 10px; max-width: 600px;
                     margin: auto;
                     box-shadow: 0 0 10px rgba(0,0,0,0.2); }
        h2 { color: #333; text-align: center; }
        table { width: 100%; border-collapse: collapse;
                margin-top: 20px; }
        th { background: #4CAF50; color: white;
             padding: 12px; text-align: left; }
        td { padding: 10px; border-bottom: 1px solid #ddd; }
        tr:hover { background: #f5f5f5; }
        a { display: inline-block; margin-top: 20px;
            padding: 10px 20px; background: #2196F3;
            color: white; border-radius: 5px;
            text-decoration: none; }
    </style>
</head>
<body>
<div class="container">
    <h2>🏆 Leaderboard</h2>
    <table>
        <tr>
            <th>Rank</th>
            <th>User ID</th>
            <th>Score</th>
            <th>Total</th>
        </tr>
        <%
        List<QuizResult> leaderboard =
            (List<QuizResult>) request.getAttribute("leaderboard");
        int rank = 1;
        if(leaderboard != null){
            for(QuizResult r : leaderboard){ %>
                <tr>
                    <td><%= rank++ %></td>
                    <td><%= r.getUserId() %></td>
                    <td><%= r.getScore() %></td>
                    <td><%= r.getTotal() %></td>
                </tr>
        <% }} %>
    </table>
    <a href="quiz">Take Quiz Again</a>
</div>
</body>
</html>
