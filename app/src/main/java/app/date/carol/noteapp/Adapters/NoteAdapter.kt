package app.date.carol.noteapp.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import app.date.carol.noteapp.Model.Note
import app.date.carol.noteapp.R
import app.date.carol.noteapp.View.MainActivity
import app.date.carol.noteapp.View.UpdateActivity

class NoteAdapter(private val activity : MainActivity) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes : List<Note> = ArrayList()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textViewTitle : TextView = itemView.findViewById(R.id.notetitle)
        val textViewDescription : TextView = itemView.findViewById(R.id.description)
        val cardView : CardView = itemView.findViewById(R.id.cardview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item,parent,false)

        return NoteViewHolder(view)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        var currentNote : Note = notes[position]

        holder.textViewTitle.text = currentNote.title
        holder.textViewDescription.text = currentNote.description

        holder.cardView.setOnClickListener {

            val intent = Intent(activity,UpdateActivity::class.java)
            intent.putExtra("currentTitle",currentNote.title)
            intent.putExtra("currentDescription",currentNote.description)
            intent.putExtra("currentId",currentNote.id)
            //activity result launcher
            activity.updateActivityResultLauncher.launch(intent)

        }

    }

    override fun getItemCount(): Int {

        return notes.size

    }

    fun setNote(myNotes : List<Note>){
        this.notes = myNotes
        notifyDataSetChanged()
    }

    fun getNote(position : Int) : Note{

        return notes[position]

    }

}