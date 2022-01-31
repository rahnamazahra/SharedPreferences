package com.example.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.sharedpreferences.databinding.SettingActivityBinding


private lateinit var binding:SettingActivityBinding

const val PREF_NAME:String = "pref_config"
var sharePref: SharedPreferences? = null

class SettingsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref_name="CONFIG"
        var sharePref:SharedPreferences?=null
        sharePref=getSharedPreferences(pref_name,0)

        if(sharePref.contains("App_Theme")){
            val theme=sharePref.getString("App_Theme",null)
            if(theme=="Light"){
                binding.LightSwitch.isChecked=true
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO))
            }
            else{
                binding.darkSwitch.isChecked=true
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_YES))
            }
        }

        binding.darkSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                binding.LightSwitch.isChecked = false
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_YES))
                val editor: SharedPreferences.Editor = sharePref!!.edit()
                editor.putString("App_Theme", "Dark")
                editor.apply()
                //editor.commit()
            }else{
                binding.LightSwitch.isChecked = true
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO))
                val editor: SharedPreferences.Editor = sharePref!!.edit()
                editor.putString("App_Theme", "Light")
                editor.apply()
                
            }


        }
        binding.LightSwitch.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked) {
                binding.darkSwitch.isChecked=false
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO))
                val editor: SharedPreferences.Editor = sharePref!!.edit()
                editor.putString("App_Theme", "Light")
                editor.apply()
                //editor.commit()
            }else{
                binding.darkSwitch.isChecked=true
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_YES))
                val editor: SharedPreferences.Editor = sharePref!!.edit()
                editor.putString("App_Theme", "Dark")
                editor.apply()
                //editor.commit()
            }


        }

    }


}