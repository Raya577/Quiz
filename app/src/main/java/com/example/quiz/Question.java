package com.example.quiz;

public class Question {
    private String questionText;
    private String questionAnswer;
    private String wrongQuestionAnswer;

    public Question(String questionText, String questionAnswer, String wrongQuestionAnswer) {
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
        this.wrongQuestionAnswer = wrongQuestionAnswer;
    }


    public String getQuestionAnswer() {

        return questionAnswer;
    }

    public String getWrongQuestionAnswer() {

        return wrongQuestionAnswer;
    }

    @Override
    public String toString() {
        return questionText;
    }
}
