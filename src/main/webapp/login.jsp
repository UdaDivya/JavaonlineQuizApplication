<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Login</title>
    <style>
        body { font-family: Arial; background: #f0f0f0;
               display: flex; justify-content: center;
               align-items: center; height: 100vh; }
        .box { background: white; padding: 30px;
               border-radius: 10px; width: 300px;
               box-shadow: 0 0 10px rgba(0,0,0,0.2); }
        h2 { text-align: center; color: #333; }
        input { width: 100%; padding: 10px;
                margin: 8px 0; border: 1px solid #ccc;
                border-radius: 5px; box-sizing: border-box; }
        button { width: 100%; padding: 10px;
                 background: #4CAF50; color: white;
                 border: none; border-radius: 5px;
                 cursor: pointer; font-size: 16px; }
        button:hover { background: #45a049; }
        .error { color: red; text-align: center; }
    </style>
</head>
<body>
<div class="box">
    <h2>Online Quiz</h2>
    <% if(request.getParameter("error") != null){ %>
        <p class="error">Invalid username or password!</p>
    <% } %>
    <form action="login" method="post">
        <input type="text" name="username"
               placeholder="Username" required/>
        <input type="password" name="password"
               placeholder="Password" required/>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
