package com.ricardogwill.seekbarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarMethod();
    }

    private TextView progressTextView;
    private SeekBar seekBar;
    int progressValue;

    public void seekBarMethod() {
        seekBar = findViewById(R.id.seek_Bar);
        progressTextView = findViewById(R.id.progress_textView);


        progressTextView.setText("Covered: " + seekBar.getProgress() + " / " + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                progressTextView.setText("Covered: " + progressValue + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // This Toast is optional and takes time just to show that the SeekBar is still being touched.
                Toast.makeText(MainActivity.this, "Seeking...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Progress: " + progressValue, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
