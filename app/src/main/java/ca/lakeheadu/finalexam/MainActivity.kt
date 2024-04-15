package ca.lakeheadu.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.lakeheadu.finalexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // View Binding setup for Main Activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO - You should probably replace this
        // Next Button - created for debugging purposes only
        binding.nextButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}