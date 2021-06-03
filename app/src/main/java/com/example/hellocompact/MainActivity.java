package com.example.hellocompact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mHelloTextview;
    private String[] mColorArray = {"white", "yellow", "fuchsia", "red", "silver", "gray", "olive", "purple", "maroon", "aqua",
            "lime", "teal", "green", "blue", "navy", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextview = findViewById(R.id.hello_textview);
        if (savedInstanceState != null) {
            mHelloTextview.setTextColor(savedInstanceState.getInt("color"));

        }
    }

    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(16)];
        int colorResourceName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        mHelloTextview.setTextColor(colorRes);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color", mHelloTextview.getCurrentTextColor());
    }
}