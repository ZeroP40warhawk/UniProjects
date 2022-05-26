package com.example.rory.swipy_dex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.ListView;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;

public class pokeCheck extends AppCompatActivity {

    ListView myList;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyUserChoice";
    ArrayList<String> selectedItems = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_check);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myList = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, getResources().getStringArray(R.array.pokemon_caught));
        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myList.setAdapter(adapter);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(MyPREFERENCES)) {
            LoadSelections();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            SaveSelections();
        }
        else if(keyCode == KeyEvent.KEYCODE_HOME)
        {
            SaveSelections();
        }
        return super.onKeyDown(keyCode, event);
    }


        public void getChoice(View v){

        String selected = "";
        int cntChoice = myList.getCount();

        SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();
        for (int i = 0; i < cntChoice; i++) {
            if (sparseBooleanArray.get(i)) {
                selected += myList.getItemAtPosition(i).toString() + "\n";
                System.out.println("Checking list while adding:" + myList.getItemAtPosition(i).toString());
                SaveSelections();
            }

        }
    }

    public void clearAll (View v){
        ClearSelections();
         }

    private void SaveSelections() {
    // save the selections in the shared preference in private mode for the user

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
        prefEditor.putString(MyPREFERENCES, savedItems);
        prefEditor.commit();
    }

    private void LoadSelections() {
    // if the selections were previously saved load them

        if (sharedpreferences.contains(MyPREFERENCES)) {

            String savedItems = sharedpreferences.getString(MyPREFERENCES, "");
            selectedItems.addAll(Arrays.asList(savedItems.split(",")));

            int count = this.myList.getAdapter().getCount();

            for (int i = 0; i < count; i++) {
                String currentItem = (String) myList.getAdapter()
                        .getItem(i);
                if (selectedItems.contains(currentItem)) {
                    myList.setItemChecked(i, true);
                } else {
                    myList.setItemChecked(i, false);
                }

            }
        }
    }

    private String getSavedItems() {
        String savedItems = "";
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.myList.isItemChecked(i)) {
                if (savedItems.length() > 0) {
                    savedItems += "," + this.myList.getItemAtPosition(i);
                } else {
                    savedItems += this.myList.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }
    private void ClearSelections() {
    // user has clicked clear button so uncheck all the items
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            this.myList.setItemChecked(i, false);
        }
    // also clear the saved selections
        SaveSelections();
    }
}
