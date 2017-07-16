package com.example.jari.transition;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (ViewGroup) findViewById(R.id.layout);
        layout.setOnTouchListener(new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Toast.makeText(getApplicationContext(), "I was touched", Toast.LENGTH_SHORT).show();
                        moveButton();
                        return true;
                    }
                }
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void moveButton(){
        View button = findViewById(R.id.button);

        // Remove this and @RequiresApi, if does not work //
        TransitionManager.beginDelayedTransition(layout);

        // Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        button.setLayoutParams(positionRules);

        // Change the size of the button
        ViewGroup.LayoutParams sizeRules = button.getLayoutParams();
        sizeRules.height = 450;
        sizeRules.width = 300;
        button.setLayoutParams(sizeRules);
    }
}
