package ca.lakeheadu.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.lakeheadu.finalexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private val FirebaseDataList = mutableListOf<Data>()
    private val firestoreDataManager: DataManager by lazy { DataManager.instance }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // View Binding setup for Main Activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Next Button - created for debugging purposes only
        binding.nextButton.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        //Take information from User Input
        val name = binding.nameEditText.text.toString()
        val age = binding.ageEditText.text.toString()
        val weight = binding.weightEditText.text.toString()
        val height = binding.heightEditText.text.toString()

        binding.Imperial.setOnClickListener {
            //Check to see if toggle button is checked
            if (binding.Imperial.isChecked)
            {
                //Convert weight and height to Imperial
                val weight = weight.toDouble() * 2.2
                val height = height.toDouble() * 39.37

                //Add weight and height to Firebase
                FirebaseDataList.add(Data(height = height, weight.toString()), calculateBMIImperial(weight, height))
                firestoreDataManager.addBMI(FirebaseDataList)
            }
        }

        binding.Metric.setOnClickListener {
            //Check to see if toggle button is checked
            if (binding.Metric.isChecked)
            {
                //Convert weight and height to Metric
                val weight = weight.toDouble() / 2.2
                val height = height.toDouble() / 39.37

                //Add weight and height to Firebase
                FirebaseDataList.add(Data(height = height, weight.toString()), calculateBMIMetric(weight, height))
                firestoreDataManager.addBMI(FirebaseDataList)
            }
        }
    }
}