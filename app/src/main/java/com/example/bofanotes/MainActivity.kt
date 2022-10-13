package com.example.bofanotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bofanotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    lateinit var viewModel = ViewModel
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.notes_frame,FragmentNoteList())
            .commit()
        binding.apply {
            fabAdd.setOnClickListener {
                Toast.makeText(this@MainActivity,"Boop",Toast.LENGTH_LONG).show()
            }
        }
    }
}