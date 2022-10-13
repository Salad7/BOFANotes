package com.example.bofanotes

import android.app.FragmentManagerNonConfig
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bofanotes.databinding.FragmentNotelistBinding
import kotlinx.coroutines.launch

class FragmentNoteList : Fragment() {
    lateinit var binding : FragmentNotelistBinding
    lateinit var noteAdapter :NoteAdapter
    lateinit var viewModel :FragmentNoteListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycleScope.launch {
            binding = FragmentNotelistBinding.inflate(inflater,container,false)
            viewModel = FragmentNoteListViewModel()
            binding.apply {
                lvNoteslist.layoutManager = LinearLayoutManager(context)
                viewModel.addNote()
                noteAdapter = NoteAdapter(viewModel.getNotes(),requireContext())
                lvNoteslist.adapter = noteAdapter
                fabAdd.setOnClickListener {
                    lifecycleScope.launch {
                        viewModel.addNote()
                        noteAdapter.notifyDataSetChanged()
                    }
                }
            }

        }


        return binding.root
    }

    suspend fun updateRecyclerView(){

    }

    public class NoteViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        lateinit var noteMsg : TextView
        lateinit var noteTS :TextView
        init {
            noteMsg = itemView.findViewById(R.id.custom_note_tv)
            noteTS = itemView.findViewById(R.id.custom_ts_tv)
        }
    }

    class NoteAdapter(notesList :List<Note>, ctx :Context) : RecyclerView.Adapter<NoteViewHolder>() {
        var notes = notesList
        var cont = ctx
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
            var view = LayoutInflater.from(cont).inflate(R.layout.custom_note,parent,false)
            return NoteViewHolder(view)
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            holder.noteTS.setText(notes.get(position).timestamp.toString())
            holder.noteMsg.setText(notes.get(position).message.toString())
        }

        override fun getItemCount(): Int {
            return notes.size
        }

    }
}