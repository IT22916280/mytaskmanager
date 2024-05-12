package com.example.mytaskmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytaskmanager.databinding.AddTaskBinding


class Addtask : AppCompatActivity() {

    private lateinit var binding: AddTaskBinding
    private lateinit var  db:DBhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=AddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= DBhelper(this)

        binding.saveButton.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val task = Task(0,title,content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Saved",Toast.LENGTH_SHORT).show()
        }
    }
}