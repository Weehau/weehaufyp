package com.example.toshiba.weehaufyp;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
    List<String> question = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    List<String> opta = new ArrayList<>();
    List<String> optb = new ArrayList<>();
    List<String> optc = new ArrayList<>();
    List<String> optd = new ArrayList<>();

    int score = 0;
    int currentQuestionCount = 1, totalQuestionsCount;
    public String tag;
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
        checkAnswerButton.setBackgroundResource(android.R.drawable.btn_default);
        checkAnswerButton.setTextColor(Color.BLACK);
        answerResponse = (TextView) findViewById(R.id.answer_response_text_view);
        checkResultButton = (Button) findViewById(R.id.check_result_button);
        checkResultButton.setEnabled(false);
        checkResultButton.setBackgroundResource(android.R.drawable.btn_default);
        checkResultButton.setTextColor(Color.parseColor("#cccccc"));
        nextButton=(ImageButton)findViewById(R.id.next_question_button);
        nextButton.setEnabled(false);
        nextButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint

        setQuestionView();
        Toast.makeText(getApplicationContext(), "Choose your answer & check it before you proceed to the next one", Toast.LENGTH_LONG).show();
    }

    public void nextQuestion(View view){
        RadioButton choice = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        //Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
        Log.d("yourans", answer.get(currentQuestionIndex) +" "+ choice.getText());
        Log.d("question count", currentQuestionIndex + " " + totalQuestionsCount);
        //if there's more questions
        if(currentQuestionIndex < (totalQuestionsCount - 1)){
            //currentQ=quesList.get(qid);
            currentQuestionIndex++;
            setQuestionView();
            currentQuestionCount++;
            currentQuestion.setText(String.valueOf(currentQuestionCount));
            checkAnswerButton.setEnabled(true);
            checkAnswerButton.setTextColor(Color.BLACK);
            nextButton.setEnabled(false);
            nextButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint
            answerResponse.setText("");
            //enable all radio buttons
            for (int i = 0; i < grp.getChildCount(); i++) {
                grp.getChildAt(i).setEnabled(true);
            }
        }
        //if it's the last question
        else{
            checkResultButton.setEnabled(true);
            /*Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            b.putInt("totalQuestionsCount", totalQuestionsCount);
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();*/
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
        checkAnswerButton.setBackgroundResource(android.R.drawable.btn_default);
        checkAnswerButton.setTextColor(Color.parseColor("#cccccc"));
        if(currentQuestionIndex != (totalQuestionsCount - 1)){ //if it's not the last question
            nextButton.setEnabled(true);
            nextButton.clearColorFilter();
        }
        else{
            checkResultButton.setEnabled(true);
            checkResultButton.setTextColor(Color.BLACK);
            Toast.makeText(getApplicationContext(), "Click 'Check Overall Result' to see how well you did", Toast.LENGTH_LONG).show();
        }
        RadioButton choice = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        Log.d("yourans", answer.get(currentQuestionIndex) +" "+ choice.getText());
        if(answer.get(currentQuestionIndex).equals(choice.getText())){
            score++;
            answerResponse.setText("Correct!");
            answerResponse.setTextColor(Color.BLUE);
        }
        else{
            answerResponse.setText("Oops!\nThe correct answer: " + answer.get(currentQuestionIndex));
            answerResponse.setTextColor(Color.parseColor("#cc0000"));
        }
        //disable all radio buttons after checking answer
        for (int i = 0; i < grp.getChildCount(); i++) {
            grp.getChildAt(i).setEnabled(false);
        }
    }

    public void checkResult(View view){
        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.layout_result_popup, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //Update TextView in PopupWindow dynamically
        TextView textOut = (TextView) popupView.findViewById(R.id.score_output);
        String stringOut = String.valueOf(score) + "/" + String.valueOf(totalQuestionsCount);
        if (!stringOut.equals("")) {
            textOut.setText(stringOut);
        }

        ImageView popupImage = (ImageView)popupView.findViewById(R.id.popup_image);

        if(((double)score / totalQuestionsCount) == 1){
            popupImage.setImageResource(R.drawable.grade_a_plus_2nd_resize);
        }
        else if (((double)score / totalQuestionsCount) < 1 && ((double)score / totalQuestionsCount) >= 0.8){
            popupImage.setImageResource((R.drawable.grade_a_2nd_resize));
        }
        else if(((double)score / totalQuestionsCount) < 0.8 && ((double)score / totalQuestionsCount) >= 0.5 ){
            popupImage.setImageResource((R.drawable.grade_b_2nd_resize));
        }
        else if(((double)score / totalQuestionsCount) < 0.5 && ((double)score / totalQuestionsCount) > 0){
            popupImage.setImageResource((R.drawable.grade_c_2nd_resize));
        }
        else if(((double)score / totalQuestionsCount) == 0){
            popupImage.setImageResource((R.drawable.grade_f_2nd_resize));
        }

        TextView btnDismiss = (TextView) popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        TextView homeButton = (TextView)popupView.findViewById(R.id.home_button);
        homeButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                //clears all previous activities and returns to home
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        popupWindow.showAtLocation(checkResultButton, Gravity.CENTER, 0, 0); //show at center of screen no matter what
        popupWindow.setFocusable(true);
        popupWindow.update();
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
        //currentQuestionIndex++;
    }
}
