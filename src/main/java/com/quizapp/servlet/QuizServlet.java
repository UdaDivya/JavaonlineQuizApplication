package com.quizapp.servlet;

import com.quizapp.dao.QuizDAO;
import com.quizapp.dao.QuizResultDAO;
import com.quizapp.model.Question;
import com.quizapp.model.QuizResult;
import com.quizapp.model.User;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null ||
            session.getAttribute("user") == null) {
            resp.sendRedirect(
                req.getContextPath() + "/login.jsp");
            return;
        }

        try {
            QuizDAO dao = new QuizDAO();
            List<Question> questions = 
                dao.getAllQuestions();
            req.setAttribute("questions", questions);
            req.getRequestDispatcher("quiz.jsp")
               .forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null ||
            session.getAttribute("user") == null) {
            resp.sendRedirect(
                req.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        try {
            QuizDAO dao = new QuizDAO();
            List<Question> questions = 
                dao.getAllQuestions();
            int score = 0;

            for (Question q : questions) {
                String answer = req.getParameter(
                    "q" + q.getId());
                if (answer != null &&
                    answer.equals(q.getCorrectAnswer())) {
                    score++;
                }
            }

            QuizResult result = new QuizResult();
            result.setUserId(user.getId());
            result.setScore(score);
            result.setTotal(questions.size());

            QuizResultDAO rdao = new QuizResultDAO();
            rdao.saveResult(result);

            req.setAttribute("score", score);
            req.setAttribute("total", questions.size());
            req.getRequestDispatcher("result.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}