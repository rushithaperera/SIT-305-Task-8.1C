package com.example.task81c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoFrame extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    Button btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_frame);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);
        btnPlay = findViewById(R.id.play);

        Intent i = getIntent();

        youTubePlayerView.initialize(YouTubeAPI.getApiKey(), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    Toast.makeText(VideoFrame.this,"Done Initializing", Toast.LENGTH_SHORT).show();
                    youTubePlayer.cueVideo(i.getStringExtra("url"));
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(VideoFrame.this,"Failed to Initialize", Toast.LENGTH_SHORT).show();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VideoFrame.this,"Initializing", Toast.LENGTH_SHORT).show();
                youTubePlayerView.initialize(YouTubeAPI.getApiKey(), onInitializedListener);
            }
        });

    }
}