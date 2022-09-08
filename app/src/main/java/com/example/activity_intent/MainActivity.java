package com.example.activity_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etPesanan;
    Button buttonMakanan;
    Button buttonMinuman;
    TextView tvHasil;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";
    public static final String MESSAGE_EXTRA2 = "MESSAGE_KEY2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPesanan = findViewById(R.id.etPesanan);
        buttonMakanan = findViewById(R.id.buttonMakanan);
        buttonMinuman = findViewById(R.id.buttonMinuman);
        tvHasil = findViewById(R.id.tvHasil);

        buttonMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message = etPesanan.getText().toString();
                String message2 = "MAKANAN";
                intent.putExtra(MESSAGE_EXTRA2, message2);
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);

            }
        });

        buttonMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message = etPesanan.getText().toString();
                String message2 = "MINUMAN";
                intent.putExtra(MESSAGE_EXTRA2, message2);
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String replyText = data.getStringExtra(SecondActivity.REPLY_EXTRA);
            tvHasil.setText(replyText);
        }
    }

}