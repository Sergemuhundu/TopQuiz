package com.muhundu.topquiz.model;

public class Correction {
    private String mQuestionTxt;
    private String mReponse;
    private String mReponseUser;

    public Correction(String mQuestionTxt, String mReponse, String mReponseUser){
            this.mQuestionTxt=mQuestionTxt;
            this.mReponse=mReponse;
            this.mReponseUser=mReponseUser;
    }

    public String getQuestionTxt() {
        return this.mQuestionTxt;
    }

    public String getReponse() {
        return this.mReponse;
    }

    public String getReponseUser() {
        return this.mReponseUser;
    }

    public void setQuestionTxt(final String questionTxt) {
        this.mQuestionTxt = questionTxt;
    }

    public void setReponse(final String reponse) {
        this.mReponse = reponse;
    }

    public void setReponseUser(final String reponseUser) {
        this.mReponseUser = reponseUser;
    }
}
