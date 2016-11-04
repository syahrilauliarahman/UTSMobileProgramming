package com.syahril.utsmobprog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity { 
    static final public Integer[] ID_CAKE = {
        R.drawable.cake1,
        R.drawable.cake2,
        R.drawable.cake3,
        R.drawable.cake4,
        R.drawable.cake5,
    };

	ArrayList<RincianData> hasil; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);
		
        ArrayList<RincianData> listData = perolehData();
	        
        final ListView listViewData = (ListView) findViewById(R.id.listViewData);
        AdapterDaftarItem adapter = new AdapterDaftarItem(this, listData);
        listViewData.setAdapter(adapter);
        listViewData.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
                Object terpilih = listViewData.getItemAtPosition(position);
                RincianData rincian = (RincianData) terpilih;
                
                // Bentuk Intent untuk menampilkan detail negara
                Intent intent = new Intent(MainActivity.this, InfoDetail.class);

                Bundle data = new Bundle();
                data.putString("Cake", rincian.perolehCake());
                data.putInt("Gambar", rincian.perolehIdCake());
                
                intent.putExtras(data);
                startActivityForResult(intent, 1);
         	}          	 
        });
    }
	
    private ArrayList<RincianData> perolehData(){
        hasil = new ArrayList<RincianData>(); 
    	
        RincianData data;
    	
        data = new RincianData("Cake 1",1);
        hasil.add(data);
  
        data = new RincianData("Cake 2", 2);
        hasil.add(data);

        data = new RincianData("Cake 3", 3);
        hasil.add(data);

        data = new RincianData("Cake 4", 4);
        hasil.add(data);

        data = new RincianData("Cake 5", 5);
        hasil.add(data);

        return(hasil);
    }	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
