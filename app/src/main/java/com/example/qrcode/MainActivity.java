package com.example.qrcode;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.WeakHashMap;


public class MainActivity extends AppCompatActivity {

    TextView text;
    Button tlacidlo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.TextView);
        tlacidlo = findViewById(R.id.button);

        tlacidlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcher.launch(new ScanOptions());
            }
        });
    }

    // Register the launcher and result handler
    private final ActivityResultLauncher<ScanOptions> launcher = registerForActivityResult(new ScanContract(),
            result -> {
                TextView tv = findViewById(R.id.text);
                if(result.getContents() == null) {
                    tv.setText("No Content");
                } else {
                    tv.setText(result.getContents());
                }
            });
}



