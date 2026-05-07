package com.quizapp.servlet;

import com.quizapp.dao.QuizResultDAO;
import com.quizapp.model.User;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/leaderboard")
public class LeaderboardServlet extends HttpServlet {

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

        User user = (User) session.getAttribute("user");
        QuizResultDAO resultDAO = new QuizResultDAO();

        try {
            req.setAttribute("leaderboard",
                resultDAO.getLeaderboard());
            req.setAttribute("history",
                resultDAO.getResultsByUser(
                    user.getId()));
            req.getRequestDispatcher("leaderboard.jsp")
               .forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error",
                "Could not load leaderboard: "
                + e.getMessage());
            req.getRequestDispatcher("leaderboard.jsp")
               .forward(req, resp);
        }
    }
}