package Fragments

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class WhatsAppMain: AppCompatActivity() {
    lateinit var chaTab : TextView;
    lateinit var statusTab : TextView;
    lateinit var callsTab : TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.whats_app_main);
        chaTab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FragmentContainer, Chat_WahtsApp())
                .commit()
        }
        statusTab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FragmentContainer, StastusWhatsApp())
                .commit()
        }
        chaTab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FragmentContainer, Chat_WahtsApp())
                .commit()
        }
    }
}