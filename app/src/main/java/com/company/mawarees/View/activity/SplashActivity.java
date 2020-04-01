package com.company.mawarees.View.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.mawarees.R;
import com.company.mawarees.View.activity.webview.WebActivity;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.splash_activity_lbl_tv)
    TextView lblTV;

    @BindView(R.id.splash_activity_videos_btn)
    Button videosBtn;

    @BindView(R.id.splash_activity_books_btn)
    Button booksBtn;

    @BindView(R.id.splash_activity_new_problem_btn)
    Button newProblemBtn;

    @BindView(R.id.splash_activity_instructions_btn)
    Button mInstructionBtn;

    @BindView(R.id.splash_libraries_btn)
    Button librariesBtn;

    FloatingActionMenu actionMenu;
    int backClicksCount = 0;

    SubActionButton introBtn, videoBtn, bookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        new Handler().postDelayed(this::init, 1000);
    }

    private void init() {

        try {
            librariesBtn.setVisibility(View.VISIBLE);
            videosBtn.setVisibility(View.VISIBLE);
            booksBtn.setVisibility(View.VISIBLE);
            newProblemBtn.setVisibility(View.VISIBLE);

            librariesBtn.setOnClickListener(this);
            videosBtn.setOnClickListener(this);
            booksBtn.setOnClickListener(this);
            newProblemBtn.setOnClickListener(this);
            mInstructionBtn.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public void onClick(View view) {
        if (view.equals(librariesBtn)) {
            handleUrls(getString(R.string.intro_link));
        } else if (view.equals(videosBtn)) {
            handleUrls(getString(R.string.video_link));
        } else if (view.equals(booksBtn)) {
            handleUrls(getString(R.string.book_link));
        }else if (view.equals(newProblemBtn)){
            startActivity(new Intent(SplashActivity.this, ProblemActivity2.class));
        }else if (view.equals(mInstructionBtn)){
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        }
    }

    void handleUrls(String url) {
        try {
            Intent intent = new Intent(SplashActivity.this, WebActivity.class);
            intent.putExtra(getString(R.string.url), url);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
