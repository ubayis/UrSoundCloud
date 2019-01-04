package com.ur.ursoundcloud.praktikum1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ur.ursoundcloud.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casting();
    }
    private void casting() {
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        buttonSubmit = (Button) findViewById(R.id.btn_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUserOffline();
            }
        });
    }

    private void LoginUserOnline(){
        final String isiUsername = etUsername.getText().toString();
        final String isiPassword = etPassword.getText().toString();

        String url = "http://tiw.web.id/api/mobileapi.php";
        JsonObjectRequest LoginUser = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //berhasil
                Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //gagal

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("UserName",isiUsername);
                params.put("PassWord",isiPassword);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("appid","fasilkom");
                return params;
            }
        };

        MyApplication.getInstance().addToRequestQueue(LoginUser,"RequestLogin");
    }

    private void LoginUserOffline() {
        String isiUsername = etUsername.getText().toString();
        String isiPassword = etPassword.getText().toString();

        if (isiUsername.equals("raisnubair") && isiPassword.equals("201581263")) {
            //ketika berhasil login
            Intent TampilanHome = new Intent(MainActivity.this,HomeActivity.class);
            TampilanHome.putExtra("username",isiUsername);
            startActivity(TampilanHome);


        } else {
            Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
            //ketika gagal login
        }
    }
}
