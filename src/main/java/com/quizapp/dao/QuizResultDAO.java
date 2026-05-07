package com.quizapp.dao;

import com.quizapp.model.QuizResult;
import java.sql.*;
import java.util.*;

public class QuizResultDAO {

    public void saveResult(QuizResult r) throws Exception {
        String sql =
         "INSERT INTO quiz_results(user_id,score,total) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, r.getUserId());
            ps.setInt(2, r.getScore());
            ps.setInt(3, r.getTotal());
            ps.executeUpdate();
        }
    }

    public List<QuizResult> getLeaderboard() throws Exception {
        List<QuizResult> list = new ArrayList<>();
        String sql = 
            "SELECT * FROM quiz_results ORDER BY score DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                QuizResult qr = new QuizResult();
                qr.setUserId(rs.getInt("user_id"));
                qr.setScore(rs.getInt("score"));
                qr.setTotal(rs.getInt("total"));
                list.add(qr);
            }
        }
        return list;
    }

    public List<QuizResult> getResultsByUser(int userId)
                                          throws Exception {
        List<QuizResult> list = new ArrayList<>();
        String sql = 
            "SELECT * FROM quiz_results WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuizResult qr = new QuizResult();
                qr.setUserId(rs.getInt("user_id"));
                qr.setScore(rs.getInt("score"));
                qr.setTotal(rs.getInt("total"));
                list.add(qr);
            }
        }
        return list;
    }
}