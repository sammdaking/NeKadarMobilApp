package com.example.nekadarjavaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.nekadarjavaapp.databinding.ActivityLoginBinding;
import com.example.nekadarjavaapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private Handler handler;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mAuth = FirebaseAuth.getInstance();


        // daha önce mail ve şifreyle giriş varsa onu otomatik yakalar ve giriş yaptırır.
        FirebaseUser user = mAuth.getCurrentUser();



        // eğer null değilse yani kullanıcı girişi yapıldıysa önceden intente git else gerek yok zaten giriş yapıcak

        if (user!=null)
        {

            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();

        }





    }






// email ve şifre doğruysa home sayfasına yönlendiricek

    public void goHome(View view) {

        String email = binding.edtTextEmail.getText().toString();
        String password = binding.edtTextPass.getText().toString();

        if (email.equals("")  || password.equals("") ){

            Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT).show();

        }
        else{

            mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });


        }










    }










// sign up butonuna basan kişiyi sign up sayfasına yönlendiriyo
    public void goSignUp(View view) {

        // sign up ac yönlenmiyo


        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();

    }

    public void forgetPass(View view) {
        // şifremi unuttuma basan kişiyi yönlendir
        // https://developer.android.com/studio/write/app-link-indexing    bu siteden linke yolla


    }

}

