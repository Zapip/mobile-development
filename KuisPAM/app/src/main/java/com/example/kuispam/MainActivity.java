package com.example.kuispam;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewHair, imageViewEyebrow, imageViewBeard, imageViewMustache;
    private CheckBox checkBoxHair, checkBoxEyebrow, checkBoxBeard, checkBoxMustache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Sekarang findViewById setelah setContentView
        imageViewHair = findViewById(R.id.imageViewHair);
        imageViewEyebrow = findViewById(R.id.imageViewEyebrow);
        imageViewMustache = findViewById(R.id.imageViewMustache);
        imageViewBeard = findViewById(R.id.imageViewBeard);

        checkBoxHair = findViewById(R.id.checkBoxHair);
        checkBoxEyebrow = findViewById(R.id.checkBoxEyebrow);
        checkBoxMustache = findViewById(R.id.checkBoxMustache);
        checkBoxBeard = findViewById(R.id.checkBoxBeard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Event listener untuk Hair
        checkBoxHair.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewHair.setVisibility(View.VISIBLE);
            } else {
                imageViewHair.setVisibility(View.INVISIBLE);
            }
        });

        // Event listener untuk Eyebrow
        checkBoxEyebrow.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewEyebrow.setVisibility(View.VISIBLE);
            } else {
                imageViewEyebrow.setVisibility(View.INVISIBLE);
            }
        });

        // Event listener untuk Beard
        checkBoxBeard.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewBeard.setVisibility(View.VISIBLE);
            } else {
                imageViewBeard.setVisibility(View.INVISIBLE);
            }
        });

        // Event listener untuk Mustache
        checkBoxMustache.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewMustache.setVisibility(View.VISIBLE);
            } else {
                imageViewMustache.setVisibility(View.INVISIBLE);
            }
        });
    }
}
