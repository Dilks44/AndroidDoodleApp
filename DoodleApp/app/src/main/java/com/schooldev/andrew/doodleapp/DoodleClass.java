package com.schooldev.andrew.doodleapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Andrew on 11/2/16.
 */

public class DoodleClass extends View {

    private class Drawings {
        public Paint _paintDoodle;
        public Path _path;

        public Drawings() {
            _paintDoodle = new Paint();
            _paintDoodle.setColor(Color.BLACK);
            _paintDoodle.setAntiAlias(true);
            _paintDoodle.setStyle(Paint.Style.STROKE);
            _paintDoodle.setStrokeWidth(3);
            _path = new Path();

        }

    }

    private ArrayList<Drawings> drawingsArray = new ArrayList<Drawings>();

    private Paint _paintDoodle = new Paint();
    private Path _path = new Path();
    private Canvas _canvas;
    private Drawings currentDrawing;
    private int currentBrushSize = 3;
    private int currentColor = 0xFF000000;


    public DoodleClass(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(null, 0);
    }

    public DoodleClass(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(null, 0);
    }

    private void init(AttributeSet attrs, int defStyle) {
        currentDrawing = new Drawings();
        currentColor = 0xFF000000;
        currentBrushSize = 3;
        drawingsArray.add(currentDrawing);
    }




    public void clearCanvas() {
        drawingsArray.clear();
        init(null, 0);
        _canvas.drawPath(currentDrawing._path, currentDrawing._paintDoodle);
        invalidate();
    }

    public void undoLast() {
        drawingsArray.remove(drawingsArray.size()-1);
        currentDrawing = new Drawings();
        //init(null, 0);
        invalidate();
    }

    public void setBrushSize(int size) {
        // 0 is smaller, 1 is larger
        if (size == 0) {
            // decrease brush size
            currentBrushSize -= 3;
        }
        else {
            // increase brush size
            currentBrushSize += 3;
        }
        currentDrawing = new Drawings();
        currentDrawing._paintDoodle.setStrokeWidth(currentBrushSize);
        currentDrawing._paintDoodle.setColor(currentColor);
        drawingsArray.add(currentDrawing);
    }

    public void setBrushColor(String color) {
        //currentDrawing = new Drawings();
        Drawings newDrawing = new Drawings();
        newDrawing._paintDoodle.setStrokeWidth(currentBrushSize);
        switch (color) {
            case "Red":
                newDrawing._paintDoodle.setColor(0xFFFF4545);
                currentColor = 0xFFFF4545;
                break;
            case "Green":
                newDrawing._paintDoodle.setColor(0xFF49F449);
                currentColor = 0xFF49F449;
                break;
            case "Blue":
                newDrawing._paintDoodle.setColor(0xFF4C4CF0);
                currentColor = 0xFF4C4CF0;
                break;
            case "Yellow":
                newDrawing._paintDoodle.setColor(0xFFE9F04C);
                currentColor = 0xFFE9F04C;
                break;
            case "Purple":
                newDrawing._paintDoodle.setColor(0xFF9A4CF0);
                currentColor = 0xFF9A4CF0;
                break;
            case "Orange":
                newDrawing._paintDoodle.setColor(0xFFF0C44C);
                currentColor = 0xFFF0C44C;
                break;
            case "Pink":
                newDrawing._paintDoodle.setColor(0xFFF04CBC);
                currentColor = 0xFFF04CBC;
                break;
            case "Black":
                newDrawing._paintDoodle.setColor(0xFF000000);
                currentColor = 0xFF000000;
                break;
            default:
                break;
        }
        drawingsArray.add(newDrawing);
        currentDrawing = newDrawing;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        _canvas = canvas;

        for (Drawings currentDraw : drawingsArray) {
            canvas.drawPath(currentDraw._path, currentDraw._paintDoodle);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentDrawing._path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                currentDrawing._path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();
        return true;
    }

}
