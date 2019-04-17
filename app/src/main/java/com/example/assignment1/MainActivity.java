package com.example.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity";
    private int score = 0;
    private Button leftButt;
    private Button rightButt;
    private TextView questionTV;
    private TextView scoreTV;
    private boolean isRightAnswer;

    private void generateQuestion(){
        Question question = new Question();
        leftButt.setBackgroundColor(question.getLeftColor());
        rightButt.setBackgroundColor(question.getRightColor());
        questionTV.setText(question.getQuestionLabel());
        isRightAnswer = question.isRightAnswer();
    }

    @Override // 컨스트락쳐 같은...
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // score = 0; 여기에 넣어도 되고 위에 0 넣어도 된다. private int score; 은 위에 넣어준다
        scoreTV = findViewById(R.id.scoreTV);
        scoreTV.setText("Score: " + score);
        //scoreTV.setText(R.string.score_tv); // strings.xml에 스트링 넣어서 사용하면 좋다
        leftButt = findViewById(R.id.leftBtn);
        rightButt = findViewById(R.id.rightBtn);
        questionTV = findViewById(R.id.questionTV);

        generateQuestion();

    }

    public void buttonTapped(View view) {
//        Log.d(LOG_TAG, "Left Button is tapped.");
        // Toast
        //Toast.makeText(this, "Left Button Tapped", Toast.LENGTH_SHORT).show(); // 마지막에 항상 쇼를 넣어줘야한다

        //which button is tapped? left or right?
        Button btn = (Button) view;
        // 1. btn -> identify?
        // 2. check if it's right or wrong
        // 3. update your score textView

        // TextView scoreTV = findViewById(R.id.scoreTV); // findViewById 중요하다 , 위에 넣어준다
//        if (btn.getId() == R.id.leftBtn){
//            scoreTV.setText("Score: 1");
//            toast("Left Button Tapped");
//        }else {
//            scoreTV.setText("Score: 2");
//            toast("Right Button Tapped");
//        }
        if (btn.getId() == R.id.leftBtn){
            // left button tapped
            if (isRightAnswer){
                score--;
                scoreTV.setText("Score: " + score);
                toast("Wrong");
            }else{
                score++;
                toast("Right");
            }
        }else {
            // right button tapped
            if (isRightAnswer){
                score++;
                scoreTV.setText("Score: " + score);
                toast("Right");
            }else {
                score--;
                scoreTV.setText("Score: " + score);
                toast("Wrong");
            }
        }
//        if (btn.getId() == R.id.leftBtn){
//            score++;
//            scoreTV.setText("Score: " + score);
//            toast("Left Button Tapped");
//        }else {
//            score--;
//            scoreTV.setText("Score: " + score);
//            toast("Right Button Tapped");
//        }
        //toast("Left Button Tapped");

        generateQuestion();
    }


    private void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
