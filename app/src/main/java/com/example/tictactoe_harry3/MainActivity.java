package com.example.tictactoe_harry3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
  // 0 - x   // 1- 0

    boolean gameActive=true;
    int active=0;

    int[] arr={2,2,2,2,2,2,2,2,2};

    int [][]winState={
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

   public void playerTab(View view)
   {
        ImageView img= (ImageView) view;
        int id= Integer.parseInt(img.getTag().toString());

        if(arr[id]==2)
       {
               arr[id]=active;
               img.setTranslationY(-1000f);
               if(active==0)
               {
                   img.setImageResource(R.drawable.cross);
                   active=1;
                   TextView status=findViewById(R.id.status);
                   status.setText("O's  turn - Tap to PLAY ");

               }
               else
               {
                   img.setImageResource(R.drawable.zero);
                   active=0;
                   TextView status=findViewById(R.id.status);

                   status.setText("X's  turn - Tap to PLAY ");
               }
           img.animate().translationYBy(1000f).setDuration(300);
       }
       if(!gameActive)
       {
           resetGame(view);

       }
            String str;

            for(int[] win : winState)
            {
                if(arr[win[0]]==arr[win[1]]  && arr[win[1]]==arr[win[2]] && arr[win[0]]!=2)
                {
                     if(arr[win[0]]==0)
                     {
                         str="  🎉 Winner 👑 : X ";

                         gameActive=false;
                     }
                     else
                     {
                         str="  🎉 Winner 👑 : 0 ";

                         gameActive=false;
                     }

                    TextView status=findViewById(R.id.status);
                    status.setText(str);


                }

            }


   }



   public void resetGame(View view)
   {
       gameActive=true;
       active=0;
       for(int i=0;i<arr.length;i++)
       {
           arr[i]=2;
       }

       ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);





   }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


    }





}