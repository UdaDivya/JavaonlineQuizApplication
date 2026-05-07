package com.quizapp.model;

public class Question {
    private int id;
    private String questionText, optionA, optionB,
                   optionC, optionD, correctAnswer;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String q) { this.questionText = q; }
    public String getOptionA() { return optionA; }
    public void setOptionA(String a) { this.optionA = a; }
    public String getOptionB() { return optionB; }
    public void setOptionB(String b) { this.optionB = b; }
    public String getOptionC() { return optionC; }
    public void setOptionC(String c) { this.optionC = c; }
    public String getOptionD() { return optionD; }
    public void setOptionD(String d) { this.optionD = d; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String ca) { 
        this.correctAnswer = ca; 
    }
}