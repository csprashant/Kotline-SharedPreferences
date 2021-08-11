package com.example.kotlinesharedpreferencesexamples

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var userNameEt:EditText
    lateinit var userPasswordEt:EditText
    lateinit var msgTv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameEt=findViewById(R.id.usertxt)
        userPasswordEt=findViewById(R.id.passwordtxt)
        msgTv=findViewById(R.id.msg)
    }
    fun saveData(view: View){
        val savepref:SharedPreferences=getSharedPreferences("userinformation", Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=savepref.edit()
        editor.putString("username",userNameEt.text.toString())
        editor.putString("password",userPasswordEt.text.toString())
        editor.apply()
        Toast.makeText(this,"Data is saved",Toast.LENGTH_SHORT).show()
    }
    fun displayData(view:View){
        val showPref:SharedPreferences=getSharedPreferences("userinformation", Context.MODE_PRIVATE)
        val userName:String?=showPref.getString("username","")
        val userPassword:String?=showPref.getString("password","")
        msgTv.setText("username="+userName+" password="+userPassword)
    }
}