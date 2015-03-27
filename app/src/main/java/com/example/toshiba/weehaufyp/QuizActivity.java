package com.example.toshiba.weehaufyp;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
    //List<Question> quesList
    List<String> question = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    List<String> opta = new ArrayList<>();
    List<String> optb = new ArrayList<>();
    List<String> optc = new ArrayList<>();
    List<String> optd = new ArrayList<>();

    int score = 0;
    //int qid = 0;
    int currentQuestionCount = 1, totalQuestionsCount;
    public String tag;
    //Question currentQ;
    int currentQuestionIndex;

    TextView lessonName, txtQuestion, answerResponse, currentQuestion, totalQuestions;
    RadioGroup grp;
    RadioButton rda, rdb, rdc, rdd;
    Button checkAnswerButton, checkResultButton;
    ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");

        //DB for quiz
        final QuizDBClass quizDB = new QuizDBClass(this);
        quizDB.open();
        Cursor c = quizDB.getAllQuestionsFromLesson(tag);
        if (c.moveToFirst())
        {
            do {
                question.add(c.getString(0));
                answer.add(c.getString(1));
                opta.add(c.getString(2));
                optb.add(c.getString(3));
                optc.add(c.getString(4));
                optd.add(c.getString(5));
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No quiz found", Toast.LENGTH_SHORT).show();
        }
        quizDB.close();

        totalQuestionsCount = question.size();
        currentQuestionIndex = 0;

        /*ProjectDBHelper db=new ProjectDBHelper(this);
        quesList=db.getAllQuestions();
        totalQuestionsCount = quesList.size();
        currentQ=quesList.get(qid);*/

        lessonName=(TextView)findViewById(R.id.lesson_name_label);
        lessonName.setText(tag + " Quiz");
        currentQuestion = (TextView) findViewById(R.id.current_question);
        currentQuestion.setText(String.valueOf(currentQuestionCount));
        totalQuestions = (TextView) findViewById(R.id.total_questions);
        totalQuestions.setText(String.valueOf(totalQuestionsCount));
        txtQuestion=(TextView)findViewById(R.id.question_text_view);
        grp=(RadioGroup)findViewById(R.id.answer_radio_group);
        rda=(RadioButton)findViewById(R.id.choice_1_button);
        rdb=(RadioButton)findViewById(R.id.choice_2_button);
        rdc=(RadioButton)findViewById(R.id.choice_3_button);
        rdd=(RadioButton)findViewById(R.id.choice_4_button);
        grp.check(rda.getId()); //default choice is A
        checkAnswerButton = (Button) findViewById(R.id.check_answer_button);
        answerResponse = (TextView) findViewById(R.id.answer_response_text_view);
        checkResultButton = (Button) findViewById(R.id.check_result_button);
        checkResultButton.setEnabled(false);
        nextButton=(ImageButton)findViewById(R.id.next_question_button);
        nextButton.setEnabled(false);
        nextButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint

        setQuestionView();
        Toast.makeText(getApplicationContext(), "Choose your answer & check it before you proceed to the next one", Toast.LENGTH_LONG).show();
    }

    public void nextQuestion(View view){
        RadioButton choice = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        //Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
        Log.d("yourans", answer +" "+ choice.getText());
        /*if(currentQ.getANSWER().equals(answer.getText()))
        {
            score++;
            Log.d("score", "Your score" + score);
        }*/
        if(currentQuestionIndex < totalQuestionsCount){
            //currentQ=quesList.get(qid);
            setQuestionView();
            currentQuestionCount++;
            currentQuestion.setText(String.valueOf(currentQuestionCount));
            checkAnswerButton.setEnabled(true);
            nextButton.setEnabled(false);
            nextButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint
            answerResponse.setText("");
            //enable all radio buttons
            for (int i = 0; i < grp.getChildCount(); i++) {
                grp.getChildAt(i).setEnabled(true);
            }
        }
        //else if(qid == totalQuestionsCount){
            //something
        //}
        else{
            checkResultButton.setEnabled(true);
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
    }

    public void lessonNameTips(View view){
        Toast.makeText(getApplicationContext(), "This quiz is about " + tag + "\nChoose your answer & check it before you proceed to the next one", Toast.LENGTH_LONG).show();
    }
    public void progressBarTips(View view){
        if(totalQuestionsCount == currentQuestionCount){
            Toast.makeText(getApplicationContext(), "You are now at question " + currentQuestionCount + "\n" + "This is the final question", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "You are now at question " + currentQuestionCount + "\n" + (totalQuestionsCount - currentQuestionCount) + " more to go", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkAnswer(View view){
        checkAnswerButton.setEnabled(false);
        if(currentQuestionIndex != totalQuestionsCount){ //if it's not the last question
            nextButton.setEnabled(true);
            nextButton.clearColorFilter();
        }
        else{
            checkResultButton.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Click 'Check Overall Result' to see how well you did", Toast.LENGTH_LONG).show();
        }
        RadioButton choice = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        //if(currentQ.getANSWER().equals(answer.getText())){
        if(answer == choice){
            score++;
            answerResponse.setText("Correct!");
            answerResponse.setTextColor(Color.BLUE);
        }
        else{
            //answerResponse.setText("Oops!\nThe correct answer: " + currentQ.getANSWER().toString());
            answerResponse.setText("Oops!\nThe correct answer: " + answer);
            answerResponse.setTextColor(Color.RED);
        }
        //disable all radio buttons
        for (int i = 0; i < grp.getChildCount(); i++) {
            grp.getChildAt(i).setEnabled(false);
        }
    }

    public void checkResult(View view){
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score); //Your score
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
        /*LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.layout_result_popup, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        TextView scorePopup = (TextView)findViewById(R.id.score_popup);
        scorePopup.setText("Your score: " + score + "/" + totalQuestionsCount);

        Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popupWindow.dismiss();
            }});

        popupWindow.showAsDropDown(checkResultButton, 100, -1200);
        popupWindow.setFocusable(true);
        popupWindow.update();*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    public void setQuestionView(){
        txtQuestion.setText(question.get(currentQuestionIndex));
        rda.setText(opta.get(currentQuestionIndex));
        rdb.setText(optb.get(currentQuestionIndex));
        rdc.setText(optc.get(currentQuestionIndex));
        rdd.setText(optd.get(currentQuestionIndex));
        currentQuestionIndex++;
    }
}
