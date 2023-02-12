package com.niranjan.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    int count =0;
    // 0-x
    // 1-O
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // State Meaning :-
    // 0-X
    // 1-0
    // 2-NULL
    int[][] winingPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view)
    {

        ImageView img = (ImageView)view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive ) {
            gameReset(view);
        }
        if(gameState[tappedImage] == 2)
        {
            count++;
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0) {

                    img.setImageResource(R.drawable.x);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's turns - Tap to play .. ");

            }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer =0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turns - Tap to play .. ");
            }

        img.animate().translationYBy(1000f).setDuration(300);

        }

        // check if any player won or not.......
        for(int[] winPosition : winingPositions)
        {
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]] != 2)
            {
                String winnerstr;
                gameActive = false;
                if(gameState[winPosition[0]] == 0)
                {
                    winnerstr = "X has won.";
                }
                else {
                    winnerstr = "O has won";
                }

                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }
        }

        if(count == 9 && gameActive)
        {
            count =0;
            gameActive = false;
            TextView status = findViewById(R.id.status);
            status.setText("Game is Tie ........");
        }

        //img.animate().translationYBy(1000f).setDuration(300);
    }

    public void gameReset(View view)
    {
        count = 0;
        gameActive = true;
        activePlayer = 0;
        for(int i =0;i<gameState.length;i++)
        {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);



            TextView status = findViewById(R.id.status);
            status.setText("X's Turn - Tap to play ");



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}