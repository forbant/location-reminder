package com.example.andrii.reminder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<ExampleItem> exampleItems;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        bindView();
        createExampleList();
        buildRecyclerView();

    }

    private void bindView() {
        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editText = findViewById(R.id.edittext_insert);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = calculatePosition();
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = calculatePosition();
                removeItem(position);
            }
        });
    }

    private int calculatePosition() {
        int position = Integer.parseInt(editText.getText().toString());
        if(position < exampleItems.size())
            return position;
        else if(exampleItems.isEmpty())
            return 0;
        else
            return exampleItems.size()-1;
    }

    public void insertItem(int position) {
        exampleItems.add(position, new ExampleItem(R.drawable.ic_android, "New Item on position" + position, "this is line 2"));
        adapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        if(exampleItems.isEmpty())
            return;
        exampleItems.remove(position);
        adapter.notifyItemRemoved(position);
    }

    public void createExampleList() {
        exampleItems = new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.ic_android, "Line 1 large", "line 1 small"));
        exampleItems.add(new ExampleItem(R.drawable.ic_emoticon, "Line 2 large", "line 2 small"));
        exampleItems.add(new ExampleItem(R.drawable.ic_hotel, "Line 3 large", "line 3 small"));
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
