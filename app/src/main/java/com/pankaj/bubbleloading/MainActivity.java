package com.pankaj.bubbleloading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pankaj.bubble.BubbleLoading;

public class MainActivity extends AppCompatActivity {

    private BubbleLoading bubbleLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleLoading = findViewById(R.id.bubble_loading);

    }
}
