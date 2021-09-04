package com.muhundu.topquiz.controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.muhundu.topquiz.R;

import java.util.ArrayList;
import java.util.Arrays;

public class CorrectionActivity extends AppCompatActivity {
        GridView gridView;
        TextView A9,B9,C9,A8,B8,C8,A7,B7,C7,A6,B6,C6,A5,B5,C5,A4,B4,C4,A3,B3,C3,A2,B2,C2,A1,B1,C1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correction);
        A1=findViewById(R.id.responseA1);
        B1=findViewById(R.id.responseB1);
        C1=findViewById(R.id.responseC1);

        A2=findViewById(R.id.responseA2);
        B2=findViewById(R.id.responseB2);
        C2=findViewById(R.id.responseC2);

        A3=findViewById(R.id.responseA3);
        B3=findViewById(R.id.responseB3);
        C3=findViewById(R.id.responseC3);

        A4=findViewById(R.id.responseA4);
        B4=findViewById(R.id.responseB4);
        C4=findViewById(R.id.responseC4);

        A5=findViewById(R.id.responseA5);
        B5=findViewById(R.id.responseB5);
        C5=findViewById(R.id.responseC5);

        A6=findViewById(R.id.responseA6);
        B6=findViewById(R.id.response6B);
        C6=findViewById(R.id.responseC6);

        A7=findViewById(R.id.responseA7);
        B7=findViewById(R.id.responseB7);
        C7=findViewById(R.id.response7C);

        A8=findViewById(R.id.responseA8);
        B8=findViewById(R.id.responseB8);
        C8=findViewById(R.id.responseC8);

        A9=findViewById(R.id.responseA9);
        B9=findViewById(R.id.responseB9);
        C9=findViewById(R.id.responseC9);




        Bundle bundle=this.getIntent().getExtras();
        ArrayList responseList=bundle.getStringArrayList("questionList");

        switch (Integer.parseInt(responseList.get(0).toString())){
            case 0:
                A1.setText("A");
                A1.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B1.setText("B");
                B1.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C1.setText("C");
                C1.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(1).toString())){
            case 0:
                A2.setText("A");
                A2.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B2.setText("B");
                B2.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C2.setText("C");
                C2.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(2).toString())){
            case 0:
                A3.setText("A");
                A3.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B3.setText("B");
                B3.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C3.setText("C");
                C3.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(3).toString())){
            case 0:
                A4.setText("A");
                A4.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B4.setText("B");
                B4.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C4.setText("C");
                C4.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(4).toString())){
            case 0:
                A5.setText("A");
                A5.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B5.setText("B");
                B5.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C5.setText("C");
                C5.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(5).toString())){
            case 0:
                A6.setText("A");
                A6.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B6.setText("B");
                B6.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C6.setText("C");
                C6.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(6).toString())){
            case 0:
                A7.setText("A");
                A7.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B7.setText("B");
                B7.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C7.setText("C");
                C7.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(7).toString())){
            case 0:
                A8.setText("A");
                A8.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B8.setText("B");
                B8.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C8.setText("C");
                C8.setBackgroundColor(Color.GREEN);
        }
        switch (Integer.parseInt(responseList.get(8).toString())){
            case 0:
                A9.setText("A");
                A9.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                B9.setText("B");
                B9.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                C9.setText("C");
                C9.setBackgroundColor(Color.GREEN);
        }

    }
}