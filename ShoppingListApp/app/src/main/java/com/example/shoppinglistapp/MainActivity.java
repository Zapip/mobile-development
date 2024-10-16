package com.example.shoppinglistapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> shoppingItems;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listViewItems;
    private Button buttonAddItem;
    private EditText storeNameEditText;
    private Button buttonFindStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewItems = findViewById(R.id.listViewItems);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        storeNameEditText = findViewById(R.id.storeNameEditText);
        buttonFindStore = findViewById(R.id.findStoreButton);

        shoppingItems = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingItems);
        listViewItems.setAdapter(itemsAdapter);

        // Handle add item button
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        buttonFindStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String storeName = storeNameEditText.getText().toString();
                if (!storeName.isEmpty()) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(storeName));
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String newItem = data.getStringExtra("item");
            shoppingItems.add(newItem);
            itemsAdapter.notifyDataSetChanged();
        }
    }
}
