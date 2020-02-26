package kr.co.ohmydayz.sample.airchecker.view;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.ohmydayz.sample.airchecker.R;

public class SidoSelectActivity extends AppCompatActivity {



    private String[] sidoList = new String[]{"서울", "부산", "대구", "인천", "광주",
            "대전", "울산", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "세종" };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sido_select);

        ListView sidoListView = findViewById(R.id.sidoListView);

        ArrayAdapter<String> sidoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        sidoAdapter.addAll(sidoList);

        sidoListView.setAdapter(sidoAdapter);

        sidoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), sidoList[position] + "선택됨", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SidoSelectActivity.this, CitySelectActivity.class);
                intent.putExtra(CitySelectActivity.INTENT_SIDO_NAME, sidoList[position]);
                startActivity(intent);
            }
        });


    }
}
