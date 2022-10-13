package com.example.bofanotes

import android.app.FragmentManagerNonConfig
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bofanotes.databinding.FragmentNotelistBinding
import kotlinx.coroutines.launch
import java.util.*

class FragmentNoteList : Fragment() {
    lateinit var binding : FragmentNotelistBinding
    lateinit var noteAdapter :NoteAdapter
    lateinit var viewModel :FragmentNoteListViewModel
    var requestCode = 0;
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
//                        viewModel.addNote()
//                        noteAdapter.notifyDataSetChanged()
                        var noteDialog =  NoteCreatorDialogFragment()
                       noteDialog.setTargetFragment(this@FragmentNoteList,requestCode)
                        noteDialog.show(requireFragmentManager(),"TAG")
                    }
                }
            }

        }


        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 0 ){
            lifecycleScope.launch {
                var note = Note(UUID.randomUUID(), 1110, data!!.getStringExtra("note")!!)
                Toast.makeText(
                    requireContext(),
                    "Message recieved: " + note.message,
                    Toast.LENGTH_LONG
                ).show()
                viewModel.addCustomNote(note)
                noteAdapter.notifyDataSetChanged()
            }
            }
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