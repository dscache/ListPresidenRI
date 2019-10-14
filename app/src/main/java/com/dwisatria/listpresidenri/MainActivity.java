package com.dwisatria.listpresidenri;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] listView_Title = new String[]{
            "Soekarno",
            "Soeharto",
            "Bacharuddin Jusuf Habibie",
            "Abdurrahman Wahid",
            "Megawati Soekarnoputri",
            "Susilo Bambang Yudhoyono",
            "Joko Widodo",
    };

    int[] listviewImage = new int[]{
            R.drawable.soekarno,    R.drawable.soeharto, R.drawable.habibie, R.drawable.gusdur,
            R.drawable.megawati,    R.drawable.sby,  R.drawable.jokowi
    };

    String[] listviewShortDescription = new String[]{
            "lahir di Surabaya, Jawa Timur, 6 Juni 1901 – meninggal di Jakarta, 21 Juni 1970 pada umur 69 tahun",
            "lahir di Kemusuk, Yogyakarta, 8 Juni 1921 – meninggal di Jakarta, 27 Januari 2008 pada umur 86 tahun",
            "lahir di Parepare, Sulawesi Selatan, 25 Juni 1936 – meninggal di Jakarta, 11 September 2019 pada umur 83 tahun",
            "lahir di Jombang, Jawa Timur, 7 September 1940 – meninggal di Jakarta, 30 Desember 2009 pada umur 69 tahun",
            "lahir di Yogyakarta, 23 Januari 1947; umur 72 tahun",
            "lahir di Tremas, Arjosari, Pacitan, Jawa Timur, Indonesia, 9 September 1949; umur 70 tahun",
            "lahir di Surakarta, Jawa Tengah, 21 Juni 1961; umur 58 tahun",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 7; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listView_Title[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                LinearLayout linearLayoutParent = (LinearLayout) container;
                LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);
                TextView tvlistview_title = (TextView) linearLayoutChild.getChildAt(0);
                Toast.makeText(getBaseContext(), tvlistview_title.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        };
        androidListView.setOnItemClickListener(itemClickListener);
    }
}