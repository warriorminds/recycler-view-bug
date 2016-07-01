package com.warriorminds.recyclerviewbug;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.common.collect.Lists;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new MyAdapter();
        recyclerView.setHasFixedSize(true); // if true, doesn't work. false, works ok.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new DummyAsync().execute();
    }

    private class DummyAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter.clearList();
            adapter.addObjects(generateObjects());
            adapter.refreshList();
        }

        private List<MyObject> generateObjects() {
            return Lists.newArrayList(new MyObject("One", "One description"),
                    new MyObject("Two", "Two description"),
                    new MyObject("Three", "Three description"));
        }
    }
}
