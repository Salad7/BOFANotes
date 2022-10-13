package com.example.bofanotes

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class NoteCreatorDialogFragment : DialogFragment() {

    private fun sendResult(REQUEST_CODE: Int, msg: String) {
        val intent = Intent()
        intent.putExtra("note", msg)
        targetFragment!!.onActivityResult(
            targetRequestCode, REQUEST_CODE, intent
        )
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var v =
            LayoutInflater.from(requireContext()).inflate(R.layout.custom_note_dialog,null,false)
        var noteText = v.findViewById<EditText>(R.id.dialog_msg_et)
        v.findViewById<Button>(R.id.dialog_save_btn).setOnClickListener {
            Toast.makeText(requireContext(),"Booooop",Toast.LENGTH_LONG).show()
            Log.d("NoteCreatorDialogFragment","Sending Text")
            sendResult(0,noteText.text.toString())
            dismiss()
        }
        v.findViewById<Button>(R.id.dialog_cancel_btn).setOnClickListener {
        dismiss()
        }
        Log.d("NoteCreatorDialogFragment","onCreate called")
//        view = View.inflate(requireContext(),R.layout.custom_note_dialog,)
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Create Note")
        builder.setView(v)

        return builder.create()
    }


}