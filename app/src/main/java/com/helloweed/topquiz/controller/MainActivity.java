package com.helloweed.topquiz.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.helloweed.topquiz.R;
import com.helloweed.topquiz.model.User;

public class MainActivity extends AppCompatActivity {
    private TextView mGreetingTextView;
    private EditText mNameEditText;
    private Button mPlayButton;
    private int score;
    public User mUser = new User();
   // private TextView mNameEtScore;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode){
            score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingTextView = findViewById(R.id.main_textview_greeting);
        mPlayButton = findViewById(R.id.main_button_play);
        mNameEditText = findViewById(R.id.main_edittext_name);
       // mNameEtScore = findViewById(R.id.game_activity_textview_NameEtScore);
        mPlayButton.setEnabled(false);
       // mGreetingTextView.setText(score);
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPlayButton.setEnabled(!editable.toString().isEmpty());


            }
        });
        Intent gameActivityIntent = new Intent( MainActivity.this, GameActivity.class);
        onActivityResult(GAME_ACTIVITY_REQUEST_CODE,RESULT_OK, gameActivityIntent);
        mGreetingTextView.setText("Le score est de " + score);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUser.setFirstName(mNameEditText.getText().toString());
                mUser.setScore(0);
               // mNameEtScore.setText(mUser.getFirstName().toString());
                Intent gameActivityIntent = new Intent( MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }
}
