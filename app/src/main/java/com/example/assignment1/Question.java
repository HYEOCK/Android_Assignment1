package com.example.assignment1;

import android.graphics.Color;

import java.util.Random;

public class Question {
    private final int[] colors = {Color.BLACK, Color.GRAY,
            Color.BLUE, Color.RED, Color.GREEN,
            Color.CYAN, Color.MAGENTA, Color.YELLOW};
    private final String[] colorsStr = {"BLACK", "GRAY", "BLUE",
            "RED", "GREEN", "CYAN", "MAGENTA", "YELLOW"};
    private int leftColor;
    private int rightColor;
    private String questionLabel;
    //private int answer; // 불리언으로 할수도 있다
    private boolean isRightAnswer;

    // 컨스트락트
    public Question() {
        generateQuestion();

    }

    public void generateQuestion(){
        // random question
//        int[] colors = {Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.YELLOW, Color.CYAN, Color.RED, Color.MAGENTA};
//        String[] colorsStr = {"BLACK", "BLUE", "GRAY", "GREEN", "YELLOW", "CYAN", "RED", "MAGENTA"};
//        int[] colors = {Color.BLACK, Color.GRAY,
//                Color.BLUE, Color.RED, Color.GREEN,
//                Color.CYAN, Color.MAGENTA, Color.YELLOW
//        };
        // Color.rgb(100, 200, 100); to get a color from rgb values
//        String[] colorsStr = {"Black", "Gray", "Blue",
//                "Red", "Green", "Cyan", "Magenta", "Yellow"};
        // 1. pick random color for left button
        Random rand = new Random();
        int leftRand = rand.nextInt(colors.length);
        leftColor = colors[leftRand];

        // 2. pick random color for right button but cannot be the same as left btn
        int rightRand = rand.nextInt(colors.length);
        while (rightRand == leftRand){
            rightRand = rand.nextInt(colors.length);
        }
        rightColor = colors[rightRand];

        // 3. pick the answer(randomly)
        int[] choices = {leftRand, rightRand};
        int answerRand = rand.nextInt(choices.length);
        isRightAnswer = answerRand != 0;
//        if (answerRand == 0){
//            isRightAnswer = false;
//        }else
//            isRightAnswer = true; // 이것을 한줄로 만든것이 위에 것.
        int choice = choices[answerRand];
        //String answer = colorsStr[answerRand];
        questionLabel = colorsStr[choice];

    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    public int getLeftColor() {
        return leftColor;
    }

    public int getRightColor() {
        return rightColor;
    }

    public String getQuestionLabel() {
        return questionLabel;
    }





}
