package com.example.myapplication;

import static com.example.myapplication.R.*;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.example.myapplication.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {

    EditText username;
    EditText password;
    Button SignInbutton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username_inpu);
        password=findViewById(R.id.password_inpu);
        SignInbutton=findViewById(R.id.signin_btn);


        SignInbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString().equals("usr")&&password.getText().toString().equals("Danny1234@")){
                    Toast.makeText(SignIn.this,"Sign In Successfull",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(SignIn.this,"Sign In fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}