package csc201.checkerboard;

import android.content.Context;
import android.view.*;
import android.graphics.*;
import android.util.Log;
import android.widget.EditText;
import android.widget.ScrollView;
import android.os.Bundle;

public class CheckerBoard extends ScrollView {
    int numberOfSquares = 10;
    int squareSize;
    int height, width;
    Paint paint = new Paint();

    public CheckerBoard(Context c) {
        super(c);
    }

    public CheckerBoard(Context c, int numberOfSquares) {
        super(c);
        System.out.print(numberOfSquares);
        this.numberOfSquares = numberOfSquares > 0 ? numberOfSquares : 10;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height = MeasureSpec.getSize(heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void onDraw(Canvas canvas) {

        // error is null pointer exception??
        System.out.print(numberOfSquares);

        int top, bottom, left, right;
        int multiplier = width / numberOfSquares; //grid multiplier determines square size based on view size and number of squares

        for(int j = 0; j < numberOfSquares; j++) {

            for(int i = 0; i < numberOfSquares; i++) {
                top = j * multiplier;
                bottom = top + multiplier;
                left = i * multiplier;
                right = left + multiplier;

                if ((j + i) % 2 == 0) {
                    paint.setColor(Color.BLACK);
                } else {
                    paint.setColor(Color.WHITE);
                }

                canvas.drawRect(left, top, right, bottom, paint);
            }
        }
    }

//    public void drawCheckerboard() {
//        for (int j = 0; j < numberOfSquares; j++) {
//
//            for (int i = 0; i < numberOfSquares; i++) {
//                Paint myPaint = new Paint();
//                myPaint.setColor(Color.rgb(0, 0, 0));
//                myPaint.setStrokeWidth(1);
//                c.drawRect(100, 100, 200, 200, myPaint);
//
//                if ((j + i) % 2 == 0) {
//                    square.setFill(Color.WHITE);
//                } else {
//                    square.setFill(Color.BLACK);
//                }
//
//                    /*
//                     * Add square to grid at position [i, j]
//                     * Where i is the row index and j is the column index
//                     */
//                add(square, i, j);
//
//                // Bind size of grid squares to size of window divided by total number of grid squares
//                square.widthProperty().bind(widthProperty().divide(numberOfSquares));
//                square.heightProperty().bind(heightProperty().divide(numberOfSquares));
//
//            }
//
//        }
//    }


}
