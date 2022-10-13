package com.example.bofanotes

import android.app.FragmentManagerNonConfig
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bofanotes.databinding.FragmentNotelistBinding

class FragmentNoteList : Fragment() {
    lateinit var binding : FragmentNotelistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotelistBinding.inflate(inflater,container,false)

        return binding.root
    }
}