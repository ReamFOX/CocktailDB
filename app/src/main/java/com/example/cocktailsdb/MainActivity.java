package com.example.cocktailsdb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocktailsdb.model.RealmDrink;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHistory;
    FloatingActionButton fab;
    RecyclerView rvMain;
    RealmAdapter adapter;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        tvHistory = findViewById(R.id.tvHistory);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        rvMain.setLayoutManager(new GridLayoutManager(this, 2));
        realm = Realm.getDefaultInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!realm.isEmpty()) {
            tvHistory.setText("");
            realm.beginTransaction();
            final RealmResults<RealmDrink> results = realm.where(RealmDrink.class).findAll();
            realm.commitTransaction();
            adapter = new RealmAdapter(results, getApplicationContext());
            rvMain.setAdapter(adapter);


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_clear){
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
            tvHistory.setText("History is empty");
            Toast.makeText(this, "History was cleared", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.action_exit) {
            finish();

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            Intent intent = new Intent(MainActivity.this, searchRes.class);
            startActivity(intent);
        }

    }

    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
