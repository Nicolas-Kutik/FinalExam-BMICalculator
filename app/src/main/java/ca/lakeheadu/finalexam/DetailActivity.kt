package ca.lakeheadu.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ca.lakeheadu.finalexam.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // View Binding setup for Detail Activity
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataList = mutableListOf<Data>(
            Data("one", "two", "three"),
            Data("one", "two", "three"),
            Data("one", "two", "three"),
        )

        // RecyclerView setup
        val recyclerAdapter = RecyclerAdapter(myDataList)
        binding.RecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }

        // TODO - You should probably replace this
        // Back Button - created for debugging purposes only
        binding.backButton.setOnClickListener {
            finish()
        }

    }
}