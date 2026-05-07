package com.quizapp.dao;

import com.quizapp.model.Question;
import com.quizapp.model.User;
import java.sql.*;
import java.util.*;

public class QuizDAO {

    public User loginUser(String username, String password)
                                        throws Exception {
        String sql =
          "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                return u;
            }
        }
        return null;
    }

    public List<Question> getAllQuestions() throws Exception {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestionText(rs.getString("question_text"));
                q.setOptionA(rs.getString("option_a"));
                q.setOptionB(rs.getString("option_b"));
                q.setOptionC(rs.getString("option_c"));
                q.setOptionD(rs.getString("option_d"));
                q.setCorrectAnswer(rs.getString("correct_answer"));
                list.add(q);
            }
        }
        return list;
    }
}