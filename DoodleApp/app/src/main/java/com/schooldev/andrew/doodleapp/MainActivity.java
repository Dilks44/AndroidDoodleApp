package com.schooldev.andrew.doodleapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import static android.R.attr.id;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    //public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button btn1 = (Button) findViewById(R.id.color_btn1);
        btn1.getBackground().setColorFilter(0xFFFF4545, PorterDuff.Mode.MULTIPLY);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Red");
            }
        });
        Button btn2 = (Button) findViewById(R.id.color_btn2);
        btn2.getBackground().setColorFilter(0xFF49F449, PorterDuff.Mode.MULTIPLY);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Green");
            }
        });
        Button btn3 = (Button) findViewById(R.id.color_btn3);
        btn3.getBackground().setColorFilter(0xFF4C4CF0, PorterDuff.Mode.MULTIPLY);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Blue");
            }
        });
        Button btn4 = (Button) findViewById(R.id.color_btn4);
        btn4.getBackground().setColorFilter(0xFFE9F04C, PorterDuff.Mode.MULTIPLY);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Yellow");
            }
        });
        Button btn5 = (Button) findViewById(R.id.color_btn5);
        btn5.getBackground().setColorFilter(0xFF9A4CF0, PorterDuff.Mode.MULTIPLY);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Purple");
            }
        });
        Button btn6 = (Button) findViewById(R.id.color_btn6);
        btn6.getBackground().setColorFilter(0xFFF0C44C, PorterDuff.Mode.MULTIPLY);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Orange");
            }
        });
        Button btn7 = (Button) findViewById(R.id.color_btn7);
        btn7.getBackground().setColorFilter(0xFFF04CBC, PorterDuff.Mode.MULTIPLY);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Pink");
            }
        });
        Button btn8 = (Button) findViewById(R.id.color_btn8);
        btn8.getBackground().setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testSetColor("Black");
            }
        });





        final Button button = (Button) findViewById(R.id.clear_button);
        button.getBackground().setColorFilter(0xFF4C4CF0, PorterDuff.Mode.MULTIPLY);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //DoodleClass.clearCanvas();
                testClearCanvas();
            }
        });

        final Button button_plus = (Button) findViewById(R.id.brush_size_larger);
        button_plus.getBackground().setColorFilter(0xFF4C4CF0, PorterDuff.Mode.MULTIPLY);
        button_plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                changeBrushSize(1);
            }
        });
        final Button button_minus = (Button) findViewById(R.id.brush_size_smaller);
        button_minus.getBackground().setColorFilter(0xFF4C4CF0, PorterDuff.Mode.MULTIPLY);
        button_minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                changeBrushSize(0);
            }
        });

        final Button button_undo = (Button) findViewById(R.id.undo_button);
        button_undo.getBackground().setColorFilter(0xFF4C4CF0, PorterDuff.Mode.MULTIPLY);
        button_undo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                undoLastDraw();
            }
        });
    }

    public void undoLastDraw() {
        final DoodleClass canvas = (DoodleClass) findViewById(R.id.doodle_canvas);
        canvas.undoLast();
    }

    public void changeBrushSize(int var) {
        // 0 is smaller, 1 is larger
        final DoodleClass canvas = (DoodleClass) findViewById(R.id.doodle_canvas);
        canvas.setBrushSize(var);

    }

    public void testClearCanvas() {
        final DoodleClass canvas = (DoodleClass) findViewById(R.id.doodle_canvas);
        canvas.clearCanvas();
    }

    public void testSetColor(String color) {
        final DoodleClass canvas = (DoodleClass) findViewById(R.id.doodle_canvas);
        canvas.setBrushColor(color);

    }



    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}
