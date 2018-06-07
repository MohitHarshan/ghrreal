package com.example.reubro.ghr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by reubro on 25/4/18.
 */

public class ForgotPassword extends AppCompatActivity {

    TextInputLayout emails;
    EditText email;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);

    email=(EditText)findViewById(R.id.email);
    submit=(Button)findViewById(R.id.submit);
    emails=(TextInputLayout)findViewById(R.id.emailWrapper);

   submit.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
        String getemail;
           getemail=email.getText().toString();
           if(TextUtils.isEmpty(getemail))
               emails.setError("Enter your email");
       }
   });


    }
}
