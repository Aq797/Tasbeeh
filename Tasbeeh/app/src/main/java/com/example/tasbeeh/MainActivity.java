package com.example.tasbeeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView disp;
    private Button increment;
    private Button reset;
    SharedPreferences sharedPreferences;
    public static final String saved = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disp = (TextView) findViewById(R.id.textView);
        increment = (Button) findViewById(R.id.increment);
        reset = (Button) findViewById(R.id.reset_button);

        sharedPreferences = getSharedPreferences(saved, Context.MODE_PRIVATE);
        disp.setText(sharedPreferences.getString("saved","0"));

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(disp.getText().toString());

                num += 1;
                disp.setText(String.valueOf(num));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("saved",String.valueOf(num));
                editor.commit();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(String.valueOf(0));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("saved","0");
                editor.commit();
            }
        });


    }

}

