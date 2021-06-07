package com.example.task81c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.youtube.player.YouTubePlayerView;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button btnplay;

    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.url);
        btnplay = findViewById(R.id.play);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);

        btnplay.setBackgroundColor(Color.RED);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoFrame.class);
                String fullUrl = url.getText().toString();
                //Getting the part needed from the video URL
                String half = fullUrl.substring(fullUrl.indexOf("=") + 1, fullUrl.indexOf("&"));//Getting the part needed from the video URL
                System.out.println(half);
                intent.putExtra("url", half);
                startActivity(intent);
            }
        });
    }

}