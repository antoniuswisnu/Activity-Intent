package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvPesanan;
    TextView tvPesanan2;
    Button btnOK;
    EditText etJumlah;
    public static final String REPLY_EXTRA = "REPLY_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvPesanan = findViewById(R.id.tvPesanan);
        tvPesanan2 = findViewById(R.id.tvPesanan2);
        btnOK = findViewById(R.id.btnOK);
        etJumlah = findViewById(R.id.etJumlah);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_EXTRA);
        String message2 = intent.getStringExtra(MainActivity.MESSAGE_EXTRA2);
        tvPesanan.setText(message2);
        tvPesanan2.setText(message);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String messageReply = etJumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA,messageReply);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}