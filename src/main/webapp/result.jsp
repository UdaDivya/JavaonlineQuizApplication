<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
    <style>
        body { font-family: Arial; background: #f0f0f0;
               display: flex; justify-content: center;
               align-items: center; height: 100vh; }
        .box { background: white; padding: 40px;
               border-radius: 10px; text-align: center;
               box-shadow: 0 0 10px rgba(0,0,0,0.2); }
        h2 { color: #333; }
        .score { font-size: 48px; font-weight: bold;
                 color: #4CAF50; margin: 20px 0; }
        .total { font-size: 20px; color: #666; }
        a { display: inline-block; margin: 10px;
            padding: 10px 20px; border-radius: 5px;
            text-decoration: none; color: white; }
        .retry { background: #2196F3; }
        .leader { background: #FF9800; }
    </style>
</head>
<body>
<div class="box">
    <h2>Quiz Completed!</h2>
    <div class="score">${score}</div>
    <div class="total">out of ${total}</div>
    <br/>
    <a href="quiz" class="retry">Try Again</a>
    <a href="leaderboard" class="leader">Leaderboard</a>
</div>
</body>
</html>