package com.example.amogus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    Randomizer generator;
    HashSet<Button> buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generator = new Randomizer();
        buttons = new HashSet<>();
        buttons.add(findViewById(R.id.button));
        buttons.add(findViewById(R.id.button2));
        buttons.add(findViewById(R.id.button3));
        buttons.add(findViewById(R.id.button4));
        buttons.add(findViewById(R.id.button5));
        buttons.add(findViewById(R.id.button6));
        buttons.add(findViewById(R.id.button7));
        buttons.add(findViewById(R.id.button8));
        buttons.add(findViewById(R.id.button9));
    }
    public void resetColors(){
        for (Button x: buttons) {
            x.setBackground(getResources().getDrawable( R.drawable.button_default));
            x.setEnabled(true);
            x.setText("");
        }
    }
    public void human(Button b){
        b.setText(generator.getCounter() + "");
        b.setEnabled(false);
        b.setTextColor(Color.BLACK);
        b.setBackgroundColor(Color.WHITE);
    }
    public void alien(){
        resetColors();
    }

    public void newGame(View view){
        finish();
        startActivity(getIntent());
        generator.newGame();
    }
    public void onClick(View view){
        Button b = (Button) view;

        switch (b.getId()){

            case R.id.button:  if(generator.correct(0,0)){human(b);} else{ alien();} break;
            case R.id.button2: if(generator.correct(0,1)){human(b);} else{ alien();} break;
            case R.id.button3: if(generator.correct(0,2)){human(b);} else{ alien();} break;
            case R.id.button4: if(generator.correct(1,0)){human(b);} else{ alien();} break;
            case R.id.button5: if(generator.correct(1,1)){human(b);} else{ alien();} break;
            case R.id.button6: if(generator.correct(1,2)){human(b);} else{ alien();} break;
            case R.id.button7: if(generator.correct(2,0)){human(b);} else{ alien();} break;
            case R.id.button8: if(generator.correct(2,1)){human(b);} else{ alien();} break;
            case R.id.button9: if(generator.correct(2,2)){human(b);} else{ alien();} break;

        }
    }
}