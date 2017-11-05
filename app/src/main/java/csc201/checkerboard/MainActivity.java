package csc201.checkerboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.*;
import android.util.Log;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "csc201.checkerboard.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set initial view
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.generate);
        final Context context = this;

        button.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               // set checkerboard view when button is clicked
//               CheckerBoard board = new CheckerBoard(context);
//               board.setBackgroundColor(Color.WHITE);
//               setContentView(board);
               sendMessage(v);

           }
       });

    }

    /* Called when the user taps the Send button */
    public void sendMessage(View v) {
        Intent intent = new Intent(this, ActivityCheckerboard.class);
        EditText squares = (EditText) findViewById(R.id.numberOfSquaresInput);
        String message = squares.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
