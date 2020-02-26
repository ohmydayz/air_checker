package kr.co.ohmydayz.sample.airchecker.network;

import kr.co.ohmydayz.sample.airchecker.model.GuAirStatus;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface AirKoreaApi {
    @GET("ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?ServiceKey=" + NetworkManager.OPEN_API_SERVICE_KEY
            + "&numOfRows=999&pageNo=1&searchCondition=HOUR&_returnType=json")
    Call<GuAirStatus> get시도별실시간평균정보조회(@Query("sidoName") String 시도);
}

