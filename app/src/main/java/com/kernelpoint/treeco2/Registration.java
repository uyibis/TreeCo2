package com.kernelpoint.treeco2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

public class Registration extends AppCompatActivity {

    UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        userViewModel= new ViewModelProvider(this).get(UserViewModel.class);// ViewModelProvider(this).get(UserViewModel.class.JAVA);

        userViewModel.loadData();
        final dialog loadingdialog = new dialog(this);
        Button bt_reg=findViewById(R.id.bt_sign_up);
        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadingdialog.startLoadingdialog();
                return;
               /* Uti u=new Uti();
                EditText edit_name=(findViewById(R.id.edit_name));
                String name=edit_name.getText().toString();

                EditText edit_mail=(findViewById(R.id.edit_email));
                String email=edit_mail.getText().toString();

                EditText edit_password=(findViewById(R.id.edit_password));
                String password=edit_password.getText().toString();

                EditText edit_password_c=(findViewById(R.id.edit_password_c));
                String password_c= edit_password_c.getText().toString();
                if(password!=password_c){
                    Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_SHORT).show();
                return;
                }
                try {
                    password=Uti.hashPassword( password);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                User user =new User();
                user.setEmail(email);
                user.setName(name);
                user.setPassword(password);
                userViewModel.insert(user);*/
             //   userViewModel.
            }
        });
    }
}