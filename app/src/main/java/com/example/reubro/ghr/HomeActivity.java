package com.example.reubro.ghr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reubro.ghr.Retrofit.Example;
import com.example.reubro.ghr.Retrofit.Patient;
import com.example.reubro.ghr.Retrofit.Profile;
import com.example.reubro.ghr.Retrofit.Retrofitinterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.PATCH;

public class HomeActivity extends AppCompatActivity {

    private static int count = 0;

    private List<Patient> listpatient=new ArrayList<>() ;
    EditText searchbyid,searchbyname;
    RecyclerAdapter adapter;
    RecyclerView recycler;

    final public String token = "cmV1YnJvOmQ2MzU2YWQ1ZGMwYTcyMGMxOGI1M2I4ZTUzZDRjMjc0";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homemenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logout:

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                return true;

            case R.id.addpatients:
                Toast.makeText(getApplicationContext(), "Add patient", Toast.LENGTH_SHORT).show();
                count++;
                Intent i = new Intent(getApplicationContext(), Patientadd.class);

                i.putExtra("count", count);

                startActivity(i);

                return true;

            case R.id.sync:
                Toast.makeText(getApplicationContext(), "Sync", Toast.LENGTH_SHORT).show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recycler = (RecyclerView) findViewById(R.id.patientsrecycler);
        LinearLayoutManager linear = new LinearLayoutManager(this);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linear);

      searchbyid=(EditText)findViewById(R.id.searchbyid);
      searchbyname=(EditText)findViewById(R.id.searchbyname);


      searchbyid.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {


              filterbyid(editable.toString());


          }
      });

searchbyname.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    filterbyname(editable.toString());


    }
});





        String API_BASE_URL = "http://10.0.0.15/ghr/api/";

        OkHttpClient clients = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
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

        Retrofit retrofit = builder.client(clients)
                .build();


        Retrofitinterface client = retrofit.create(Retrofitinterface.class);

        Call<Example> call = client.getdata(token, "MT-12", "mt12345");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {


                listpatient.addAll(response.body().getData().getProfile().getPatients());


                adapter=new RecyclerAdapter(getApplicationContext(),listpatient);

                recycler.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            Log.d("FAiled","Failed");


            }
        });



}

    private void filterbyid(String text) {
        ArrayList<Patient> filteredList = new ArrayList<>();

        for (Patient item : listpatient) {
            if (item.getPatientId().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }

    private void filterbyname(String text) {
        ArrayList<Patient> filteredList = new ArrayList<>();

        for (Patient item : listpatient) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }


}