package com.example.aec_07_text_to_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button BTN_speak;
    TextView TV_text;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        speak();
    }

    private void initializer() {
        BTN_speak = findViewById(R.id.BTN_speak);
        TV_text = findViewById(R.id.TV_text);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }
    public void speak(){
        BTN_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = TV_text.getText().toString();
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

}