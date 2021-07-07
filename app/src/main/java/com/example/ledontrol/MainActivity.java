package com.example.ledontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileWriter;


public class MainActivity extends AppCompatActivity {

    private int mFlagLed1 = 0;
    private int mFlagLed2 = 0;
    private int mFlagLed3 = 0;
    private int mFlagLed4 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewLed1 = (TextView)findViewById(R.id.textViewLed1);
        final TextView textViewLed2 = (TextView)findViewById(R.id.textViewLed2);
        final TextView textViewLed3 = (TextView)findViewById(R.id.textViewLed3);
        final TextView textViewLed4 = (TextView)findViewById(R.id.textViewLed4);
        final Button buttonLed1 = (Button)findViewById(R.id.buttonLed1);
        final Button buttonLed2 = (Button)findViewById(R.id.buttonLed2);
        final Button buttonLed3 = (Button)findViewById(R.id.buttonLed3);
        final Button buttonLed4 = (Button)findViewById(R.id.buttonLed4);


            ledControl ("user_led1", 0);
            textViewLed1.setText(R.string.led_1_off);

            ledControl ("user_led2", 0);
            textViewLed2.setText(R.string.led_2_off);

            ledControl ("user_led3", 0);
            textViewLed3.setText(R.string.led_3_off);

            ledControl ("user_led4", 0);
            textViewLed4.setText(R.string.led_4_off);

        buttonLed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlagLed1 == 0)
                {
                    ledControl ("user_led1", 255);
                    textViewLed1.setText(R.string.led_1_on);
                    mFlagLed1 = 1;
                }else {
                    ledControl ("user_led1", 0);
                    textViewLed1.setText(R.string.led_1_off);
                    mFlagLed1 = 0;
                }
            }
        });

        buttonLed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlagLed2 == 0)
                {
                    ledControl ("user_led2", 255);
                    textViewLed2.setText(R.string.led_2_on);
                    mFlagLed2 = 1;
                }else {
                    ledControl ("user_led2", 0);
                    textViewLed2.setText(R.string.led_2_off);
                    mFlagLed2 = 0;
                }
            }
        });

        buttonLed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlagLed3 == 0)
                {
                    ledControl ("user_led3", 255);
                    textViewLed3.setText(R.string.led_3_on);
                    mFlagLed3 = 1;
                }else {
                    ledControl ("user_led3", 0);
                    textViewLed3.setText(R.string.led_3_off);
                    mFlagLed3 = 0;
                }
            }
        });

        buttonLed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlagLed4 == 0)
                {
                    ledControl ("user_led4", 255);
                    textViewLed4.setText(R.string.led_4_on);
                    mFlagLed4 = 1;
                }else {
                    ledControl ("user_led4", 0);
                    textViewLed4.setText(R.string.led_4_off);
                    mFlagLed4 = 0;
                }
            }
        });
    }

    public  void ledControl (String name, int brightness){
        try{
            FileWriter fw = new FileWriter("/sys/class/leds/" + name + "/brightness");
            fw.write(Integer.toString(brightness));
            fw.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}