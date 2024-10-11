package com.example.shoppinglistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextNewItem;
    private Button buttonSubmit;
    private ListView listViewSuggestions;
    private String[] suggestions = {"Susu", "Roti", "Telur", "Keju", "Sayur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextNewItem = findViewById(R.id.editTextNewItem);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        listViewSuggestions = findViewById(R.id.listViewSuggestions);

        ArrayAdapter<String> suggestionsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, suggestions);
        listViewSuggestions.setAdapter(suggestionsAdapter);

        listViewSuggestions.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = suggestions[position];
            Intent resultIntent = new Intent();
            resultIntent.putExtra("item", selectedItem);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        buttonSubmit.setOnClickListener(v -> {
            String newItem = editTextNewItem.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("item", newItem);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
