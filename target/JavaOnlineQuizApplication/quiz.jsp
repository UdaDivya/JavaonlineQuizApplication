<%@page import="com.quizapp.model.Question"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <style>
        body { font-family: Arial; background: #f0f0f0;
               padding: 20px; }
        .container { background: white; padding: 30px;
                     border-radius: 10px; max-width: 700px;
                     margin: auto;
                     box-shadow: 0 0 10px rgba(0,0,0,0.2); }
        h2 { color: #333; text-align: center; }
        .question { margin: 20px 0; padding: 15px;
                    background: #f9f9f9;
                    border-radius: 8px; }
        .question p { font-weight: bold; }
        label { display: block; margin: 5px 0;
                cursor: pointer; }
        button { width: 100%; padding: 12px;
                 background: #2196F3; color: white;
                 border: none; border-radius: 5px;
                 cursor: pointer; font-size: 16px;
                 margin-top: 20px; }
        button:hover { background: #1976D2; }
    </style>
</head>
<body>
<div class="container">
    <h2>Online Quiz</h2>
    <form action="quiz" method="post">
    <%
    List<Question> questions =
        (List<Question>) request.getAttribute("questions");
    int i = 1;
    for(Question q : questions){ %>
        <div class="question">
            <p><%= i++ %>. <%= q.getQuestionText() %></p>
            <label>
                <input type="radio"
                       name="q<%= q.getId() %>"
                       value="A" required/>
                A) <%= q.getOptionA() %>
            </label>
            <label>
                <input type="radio"
                       name="q<%= q.getId() %>"
                       value="B"/>
                B) <%= q.getOptionB() %>
            </label>
            <label>
                <input type="radio"
                       name="q<%= q.getId() %>"
                       value="C"/>
                C) <%= q.getOptionC() %>
            </label>
            <label>
                <input type="radio"
                       name="q<%= q.getId() %>"
                       value="D"/>
                D) <%= q.getOptionD() %>
            </label>
        </div>
    <% } %>
        <button type="submit">Submit Quiz</button>
    </form>
</div>
</body>
</html>
