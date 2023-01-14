package com.example.mysoloapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.mysoloapp.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize Firebase Auth
        auth = Firebase.auth

        if(auth.currentUser?.uid==null){
            //현재 유저의 uid 값이 없으면 로그인을 해 주어야하는 상황
            Log.d("SplashActivity","null")
            Handler().postDelayed(
                { startActivity(Intent(this,IntroActivity::class.java))
                    finish() }
                ,3000) //postDelayed

            // null이면 intro 엑티비티로 그대로 넘어간다.

        }else{
            Log.d("SplashActivity","not null")

            Handler().postDelayed(
                { startActivity(Intent(this,MainActivity::class.java))
                    finish() }
                ,3000) //postDelayed
            // null이 아니면 바로 메인 엑티비티로 넘긴다.


        }




    }//onCreate
}