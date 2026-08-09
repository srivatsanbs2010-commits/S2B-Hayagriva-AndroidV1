package com.s2b.hayagriva;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView statusText;
    private TextView actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(2, 11, 20));
        getWindow().setNavigationBarColor(Color.rgb(2, 11, 20));

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(32, 40, 32, 40);
        root.setBackgroundColor(Color.rgb(2, 11, 20));

        TextView logo = new TextView(this);
        logo.setText("S2B");
        logo.setTextSize(42);
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);
        logo.setTextColor(Color.rgb(255, 193, 7));

        TextView title = new TextView(this);
        title.setText("HAYAGRIV AI");
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.rgb(0, 229, 255));

        TextView thinking = new TextView(this);
        thinking.setText("◉\n\nTHINKING");
        thinking.setTextSize(24);
        thinking.setGravity(Gravity.CENTER);
        thinking.setTypeface(Typeface.DEFAULT_BOLD);
        thinking.setTextColor(Color.rgb(0, 229, 255));

        statusText = new TextView(this);
        statusText.setText(
                "SYSTEM STATUS  •  OPTIMAL\n\n" +
                "◉  VISION       ONLINE\n" +
                "◉  VOICE        READY\n" +
                "◉  AI ENGINE    READY\n\n" +
                "HAYAGRIV IS READY"
        );
        statusText.setTextSize(16);
        statusText.setGravity(Gravity.CENTER);
        statusText.setTextColor(Color.rgb(180, 235, 255));

        actionButton = new TextView(this);
        actionButton.setText("🎙  HEY HAYAGRIV");
        actionButton.setTextSize(19);
        actionButton.setTypeface(Typeface.DEFAULT_BOLD);
        actionButton.setGravity(Gravity.CENTER);
        actionButton.setTextColor(Color.WHITE);
        actionButton.setPadding(30, 24, 30, 24);
        actionButton.setBackgroundColor(Color.rgb(0, 120, 170));

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actionButton.setText("🎙  LISTENING...");

                thinking.setText("◉\n\nTHINKING...\n\n● ● ●");

                statusText.setText(
                        "SYSTEM STATUS  •  ACTIVE\n\n" +
                        "◉  VOICE        LISTENING\n" +
                        "◉  VISION       ONLINE\n" +
                        "◉  AI ENGINE    READY\n\n" +
                        "Say: \"Hey Hayagriv\""
                );
            }
        });

        root.addView(logo);

        root.addView(title);

        LinearLayout.LayoutParams thinkingParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                );

        root.addView(thinking, thinkingParams);

        root.addView(statusText);

        LinearLayout.LayoutParams buttonParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        buttonParams.topMargin = 30;

        root.addView(actionButton, buttonParams);

        setContentView(root);
    }
}
