package kr.co.ohmydayz.sample.airchecker.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import kr.co.ohmydayz.sample.airchecker.R;
import kr.co.ohmydayz.sample.airchecker.model.GuAirStatus;
import kr.co.ohmydayz.sample.airchecker.network.AirKoreaApi;
import kr.co.ohmydayz.sample.airchecker.network.NetworkManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitySelectActivity extends AppCompatActivity {

    public static String INTENT_SIDO_NAME = "CITY_NAME";

    private ArrayAdapter<GuAirStatus.CityStatus> cityListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);

        String sido = getIntent().getStringExtra(INTENT_SIDO_NAME);

        if (sido == null) {
            Toast.makeText(this, "잘못된 접근입니다.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }


        ListView citySelectListView = findViewById(R.id.cityListView);

        cityListAdapter = new ArrayAdapter<GuAirStatus.CityStatus>(this, android.R.layout.simple_list_item_1) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View itemView = super.getView(position, convertView, parent);
                TextView textView = itemView.findViewById(android.R.id.text1);
                textView.setText(getItem(position).시군구);
                return itemView;
            }
        };


        citySelectListView.setAdapter(cityListAdapter);


        citySelectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GuAirStatus.CityStatus cityStatus = cityListAdapter.getItem(position);
                Intent intent = new Intent(CitySelectActivity.this, AirStatusActivity.class);
                intent.putExtra(AirStatusActivity.INTENT_CITY_STATUS, cityStatus);
                startActivity(intent);
            }
        });


        requestSidoAirStatus(sido);


    }

    private void requestSidoAirStatus(String sido) {
        ProgressDialog dialog = ProgressDialog.show(this, "알림",
                "잠시만 기다려주세요.", false, false);

        NetworkManager.getOpenApi()
                .create(AirKoreaApi.class)
                .get시도별실시간평균정보조회(sido)
                .enqueue(new Callback<GuAirStatus>() {
                    @Override
                    public void onResponse(@NotNull Call<GuAirStatus> call, @NotNull Response<GuAirStatus> response) {
                        if (response.isSuccessful()) {
                            GuAirStatus guAirStatus = response.body();
                            if (guAirStatus != null) {
//                                Collections.sort(guAirStatus.statuses, (o1, o2) -> o1.시군구.compareTo(o2.시군구));
                                cityListAdapter.clear();
                                cityListAdapter.addAll(guAirStatus.cityStatuses);
                                cityListAdapter.notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<GuAirStatus> call, @NotNull Throwable t) {
                        Toast.makeText(getApplicationContext(), "네트워크를 확인해주세요.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });



    }
}
