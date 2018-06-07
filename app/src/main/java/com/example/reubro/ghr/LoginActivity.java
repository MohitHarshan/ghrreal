package com.example.reubro.ghr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.Retrofit.Example;
import com.example.reubro.ghr.Retrofit.Retrofitinterface;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reubro on 25/4/18.
 */

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText siteno,password;
    TextInputLayout site,pass;
    TextView forgot;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();

        login.setOnClickListener(new View.OnClickListener() {

            @Override
    public void onClick(View view) {

        String sitenos=siteno.getText().toString();
        String passwords=password.getText().toString();
    final String token="cmV1YnJvOmQ2MzU2YWQ1ZGMwYTcyMGMxOGI1M2I4ZTUzZDRjMjc0";


        if(!TextUtils.isEmpty(sitenos)&&(!TextUtils.isEmpty(passwords)))
        {
            String API_BASE_URL = "http://10.0.0.15/ghr/api/";

            OkHttpClient clients = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + token)
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();

            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(API_BASE_URL)
                            .addConverterFactory(
                                    GsonConverterFactory.create()
                            );

            Retrofit retrofit =  builder.client(clients)
                    .build();


            Retrofitinterface client =  retrofit.create(Retrofitinterface.class);

            Call<Example> call=client.getdata(token,sitenos,passwords);

            call.enqueue(new Callback<Example>() {

                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {

                String responses=response.body().toString();

                Log.d("Response",responses);


                    String statuss= response.body().getStatus();
                 String messages= response.body().getMessage();


                if(statuss.equals("1"))
                {

                    Toast.makeText(getApplicationContext(),messages,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);


                }else
                    Toast.makeText(getApplicationContext(),messages,Toast.LENGTH_SHORT).show();


                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    Log.d("Response","Failed to fetch json");
                }
            });

        }
        else
        {
            site=(TextInputLayout)findViewById(R.id.sitenoWrapper);
            pass=(TextInputLayout)findViewById(R.id.passwordWrapper);

            if(TextUtils.isEmpty(sitenos))
            site.setError("Please enter a site no");
            if(TextUtils.isEmpty(passwords))
            pass.setError("Please enter a password");


        }

    }
});

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
                   startActivity(intent);

            }
        });




    }


    private void init()

    {    login=(Button)findViewById(R.id.login);
          siteno=(EditText) findViewById(R.id.siteno);
          password=(EditText)findViewById(R.id.password);
          forgot=(TextView)findViewById(R.id.forgotpassword);

    }


}
