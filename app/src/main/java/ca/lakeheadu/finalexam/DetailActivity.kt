package ca.lakeheadu.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ca.lakeheadu.finalexam.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding
    private val firestoreDataManager: DataManager by lazy { DataManager.instance }
    private val FirebaseDataList = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // View Binding setup for Detail Activity
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestoreDataManager.getBMI { Data ->
            RecyclerAdapter.updateData(Data)
        }

        val myDataList = mutableListOf<Data>(
            Data("one", "two", "three"),
            Data("one", "two", "three"),
            Data("one", "two", "three"),
        )

        fun onBMIClick(data: Data) {
        startActivity(Intent(this, MainActivity::class.java))
    }

        // RecyclerView setup
        val recyclerAdapter = RecyclerAdapter(myDataList)
        binding.RecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }

        // Back Button - created for debugging purposes only
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}