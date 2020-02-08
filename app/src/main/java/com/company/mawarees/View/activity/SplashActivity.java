package com.company.mawarees.View.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.mawarees.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash_activity_lbl_tv)
    TextView lblTV;

    @BindView(R.id.splash_activity_videos_btn)
    Button videosBtn;

    @BindView(R.id.splash_activity_books_btn)
    Button booksBtn;

    @BindView(R.id.splash_activity_new_problem_btn)
    Button newProblemBtn;

    int backClicksCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        new Handler().postDelayed(() -> {
//                startActivity(new Intent(SplashActivity.this, ProblemActivity2.class));
//                finish();

            lblTV.setVisibility(View.VISIBLE);
            videosBtn.setVisibility(View.VISIBLE);
            booksBtn.setVisibility(View.VISIBLE);
            newProblemBtn.setVisibility(View.VISIBLE);
        }, 1000);

        newProblemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    startActivity(new Intent(SplashActivity.this, ProblemActivity2.class));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        videosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.video_link)));
                    startActivity(myIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        booksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.book_link)));
                    startActivity(myIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        backClicksCount++;

        if (backClicksCount == 1) {
            Toast.makeText(this, "اضغط رجوع مرة أخرى للخروج", Toast.LENGTH_SHORT).show();
        } else if (backClicksCount > 1) {
            finish();
            System.exit(0);
        }
    }
}
