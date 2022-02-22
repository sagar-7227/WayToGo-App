package com.meicode.waytogo.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;
import com.meicode.waytogo.R;

public class Login extends AppCompatActivity {

//    variables
    CountryCodePicker countryCodePicker;
    TextInputLayout password,phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

//        hooks
        countryCodePicker =findViewById(R.id.country_code_picker);
        phoneNumber =findViewById(R.id.login_username);
        password =findViewById(R.id.login_passsword);

    }

    public void letTheUserLoggedIn(View view){

//        check the internet connected
        if (!isConnected(this)){
            showCustomDialog();
            
        }







//        if (!validateFields()){
//            return;
//        }

//        get data
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();

        if (_phoneNumber.charAt(0) =='0'){
            _phoneNumber = _phoneNumber.substring(1);
        }
//        String _completePhoneNumber = "+"+countryCodePicker.getFullNumber()+_phoneNumber;
        String _completePhoneNumber = "+91"+_phoneNumber;

//        database
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(_completePhoneNumber);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if (datasnapshot.exists()){
                    phoneNumber.setError(null);
                    phoneNumber.setErrorEnabled(false);

                    String systemPassword = datasnapshot.child(_completePhoneNumber).child("password").getValue(String.class);
                    if (systemPassword.equals(_password)){
                        password.setError(null);
                        password.setErrorEnabled(false);

                        String _fullName =datasnapshot.child(_completePhoneNumber).child("fullName").getValue(String.class);
                        String _email =datasnapshot.child(_completePhoneNumber).child("email").getValue(String.class);
                        String _phoneNo =datasnapshot.child(_completePhoneNumber).child("phoneNo").getValue(String.class);
                        String _dataOfBirth =datasnapshot.child(_completePhoneNumber).child("date").getValue(String.class);

                        Toast.makeText(Login.this, _fullName+"\n"+_phoneNo + "\n" + _dataOfBirth + "\n"+ _email , Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Login.this, "Data does not exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Login.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void showCustomDialog() {

        AlertDialog.Builder builder =new AlertDialog.Builder(Login.this);
        builder.setMessage("please connect to the internet to proceeed")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
                        finish();
                    }
                });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

    }

    private boolean isConnected(Login login) {

        ConnectivityManager connectivityManager = (ConnectivityManager) login.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn !=null && wifiConn.isConnected()) || (mobileConn !=null && mobileConn.isConnected())){
            return true;
        }
        else{
            return false;
        }
    }


    public void gotodshboard(View view) {
        Login.super.onBackPressed();

    }
}