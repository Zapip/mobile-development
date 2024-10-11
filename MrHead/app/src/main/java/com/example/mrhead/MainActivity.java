package com.example.mrhead;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewHair, imageViewEyebrow, imageViewMustache, imageViewBeard;
    private CheckBox checkBoxHair, checkBoxEyebrow, checkBoxMustache, checkBoxBeard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewHair = findViewById(R.id.imageViewHair);
        imageViewEyebrow = findViewById(R.id.imageViewEyebrow);
        imageViewMustache = findViewById(R.id.imageViewMustache);
        imageViewBeard = findViewById(R.id.imageViewBeard);

        checkBoxHair = findViewById(R.id.checkBoxHair);
        checkBoxEyebrow = findViewById(R.id.checkBoxEyebrow);
        checkBoxMustache = findViewById(R.id.checkBoxMustache);
        checkBoxBeard = findViewById(R.id.checkBoxBeard);

        // Listener untuk checkbox rambut
        checkBoxHair.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewHair.setVisibility(View.VISIBLE);
            } else {
                imageViewHair.setVisibility(View.INVISIBLE);
            }
        });

        // Listener untuk checkbox alis
        checkBoxEyebrow.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewEyebrow.setVisibility(View.VISIBLE);
            } else {
                imageViewEyebrow.setVisibility(View.INVISIBLE);
            }
        });

        // Listener untuk checkbox kumis
        checkBoxMustache.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewMustache.setVisibility(View.VISIBLE);
            } else {
                imageViewMustache.setVisibility(View.INVISIBLE);
            }
        });

        // Listener untuk checkbox janggut
        checkBoxBeard.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageViewBeard.setVisibility(View.VISIBLE);
            } else {
                imageViewBeard.setVisibility(View.INVISIBLE);
            }
        });
    }
}
