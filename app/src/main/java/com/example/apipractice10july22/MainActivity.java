package com.example.apipractice10july22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_view);
        textView.setText("");

        ApiInterface apiInterface =ApiClient.getclient().create(ApiInterface.class);
        Call<Modal>call= apiInterface.getpost();
        call.enqueue(new Callback<Modal>() {
            @Override
            public void onResponse(Call<Modal> call, Response<Modal> response) {
              //  Log.d("ok", "yes" + response.body());
                textView.append("SL No.:" + response.body().getId()+"\n Title :"+ response.body().getTitle()+
                        "\n Massage"+ response.body().getBody()+ "\n\n\n");

            }

            @Override
            public void onFailure(Call<Modal> call, Throwable t) {
                Log.d("ok", "No" + t);

            }
        });


    }
}