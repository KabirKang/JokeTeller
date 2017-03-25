package com.kabirkang.joketellerlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public final static String JOKE_INTENT = "JOKE_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        String joke = getIntent().getStringExtra(JOKE_INTENT);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
        jokeTextView.setText(joke);
    }
}
