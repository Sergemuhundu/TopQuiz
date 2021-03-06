package com.muhundu.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muhundu.topquiz.model.QuestionBank;
import  com.muhundu.topquiz.model.Question;
import  com.muhundu.topquiz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;
    private String goodResponseText;
    private String questionText;
    private String userResponseText;
    private int numCurrentQuestion;
    ArrayList responseList=new ArrayList();




    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    private boolean mEnableTouchEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate()");

        mQuestionBank = this.generateQuestions();

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 9;
        }

        mEnableTouchEvents = true;

        // Wire widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);


        // Use the tag property to 'name' the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);


        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);


        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        String name="question"+1;


        userResponseText=mCurrentQuestion.getChoiceList().get(responseIndex);

        //String val[]={questionText, goodResponseText, userResponseText};



        responseList.add(responseIndex);






            // Good answer

        mEnableTouchEvents = false;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                // If this is the last question, ends the game.
                // Else, display the next question.
                if (--mNumberOfQuestions == 0) {

                    // End the game
                    endGame();
                } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        }, 2000); // LENGTH_SHORT is usually 2 second long
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // End the activity
                        Intent tent = new Intent();
                        tent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, tent);

                        Intent intent = new Intent(GameActivity.this, CorrectionActivity.class);
                        intent.putExtra("questionList",responseList);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }

    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        questionText=question.getQuestion();
    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("1. Lorsque j???ai du temps de libre, je pr??f??re??? :",
                Arrays.asList("A. Regarder la t??l??, une vid??o ou aller au cin??ma", "B. ??couter de la musique, la radio ou lire un livre.", "C. Faire du sport, une activit?? physique ou manuelle."),
                0);

        Question question2 = new Question("2. Ce que je remarque lorsque je rencontre une personne :",
                Arrays.asList("A. L???apparence et la fa??on dont elle est habill??e.", "B. Comment elle parle ?", "C. Comment elle bouge ?"),
                0);

        Question question3 = new Question("3. J???apprends plus facilement :",
                Arrays.asList("A. En voyant quelqu???un montrer comment faire.", "B. En ??coutant des instructions.", "C. En le faisant moi-m??me."),
                0);

        Question question4 = new Question("4. Lorsque je cherche mon chemin dans une ville que je ne connais pas :",
                Arrays.asList("A. J???utilise une carte ou un plan.", "B. Je demande des indications.", "C. Je fais confiance ?? mon sens de l???orientation."),
                0);

        Question question5 = new Question("5. J???appr??cie les livres et les magazines qui??? :",
                Arrays.asList("A. Ont beaucoup d???illustrations.", "B. D??veloppent des sujets int??ressants.", "C. Concernent le sport, des activit??s physiques ou manuelles."),
                0);

        Question question6 = new Question("6. Lorsque j???ai beaucoup de choses ?? faire :",
                Arrays.asList("A. Je me fais des listes et je m???imagine en train de les faire.", "B. Je me r??p??te en permanence ce que je dois faire.", "C. Je me sens mal jusqu????? ce que tout ou presque tout soit fait."),
                0);

        Question question7 = new Question("7. Lorsque je parle ?? une personne??? :",
                Arrays.asList("A. J???essaye de voir ce qu???elle me dit.", "B. J?????coute attentivement pour bien entendre ce qu???elle me dit.", "C. J???essaye de ressentir pour bien comprendre ce qu???elle me dit."),
                0);

        Question question8 = new Question("8. Lorsque je r??sous des probl??mes??? :",
                Arrays.asList("A. Je cherche des alternatives jusqu????? ce que les pi??ces se mettent en place.", "B. Je parle des diff??rentes approches jusqu????? ce qu???il y ait un d??clic.", "C. J???essaye diff??rentes possibilit??s jusqu????? ce que j???aie un sentiment d?????quilibre."),
                0);

        Question question9 = new Question("9. J???aime un endroit o????? :",
                Arrays.asList("A. Il y a des gens ou des choses ?? voir.", "B. Il y a de la musique, une conversation ou le silence.", "C. Il y a de la place pour bouger."),
                0);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("GameActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("GameActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("GameActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("GameActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("GameActivity::onDestroy()");
    }
}