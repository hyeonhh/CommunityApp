package com.example.mysoloapp.auth

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysoloapp.MainActivity
import com.example.mysoloapp.R
import com.example.mysoloapp.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        binding  =DataBindingUtil.setContentView(this,R.layout.activity_join)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {



            var isGoToJoin = true
            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            //저기 값이 비어있는지 확인
            if(email.isEmpty()) {
                Toast.makeText(this,"이메일을 입력해주세요",Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if(password1.isEmpty()) {
                Toast.makeText(this,"Password1을 입력해주세요",Toast.LENGTH_SHORT).show()
                isGoToJoin = false

            }

            if(password2.isEmpty()) {
                Toast.makeText(this,"Password2을 입력해주세요",Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            //비밀번호 2개가 같은지 확인

            if(!password1.equals(password2)) {
                Toast.makeText(this,"비밀번호를 똑같이 입력해주세요",Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            //비밀번호가 6자 이상인지
            if(password1.length<6){
                Toast.makeText(this,"비밀번호를 6자리 이상 입력해주세요",Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (isGoToJoin){
                auth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                            //성공하면 메인액티비티로 이동한다.
                            val intent = Intent(this,MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }

                        else {
                            Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                        }//else

                        }
                    }
        }//setOnClickListener
    }//onCreate
}//class