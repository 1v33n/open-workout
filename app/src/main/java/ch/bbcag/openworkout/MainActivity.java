package ch.bbcag.openworkout;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
    String[] eintrag = {
            "jonas 1",
            "ivan 2",
            "Eintrag 3",
            "Eintrag 4",
            "Eintrag 5",
            "Eintrag 6",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Listview adapter
        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,eintrag));
    }
    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        Toast.makeText(this, "Ihre Auswahl : " + eintrag[position],
                Toast.LENGTH_LONG).show();
    }
}