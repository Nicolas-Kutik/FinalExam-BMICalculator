package ca.lakeheadu.finalexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.lakeheadu.finalexam.databinding.CustomCellBinding

class RecyclerAdapter(private var dataSet: List<Data>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{

    class ViewHolder(val binding: CustomCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder
    {
        // Inflate the layout with view binding
        val binding =
            CustomCellBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
    {
        viewHolder.binding.dataItem1.text = dataSet[position].weight
        viewHolder.binding.dataItem2.text = dataSet[position].height
        viewHolder.binding.dataItem3.text = dataSet[position].date
    }

    //Calculates the BMI
    override fun calculateBMIImperial(weight: Double, height: Double): Double {
        return weight*703 / (height * height)
    }

    override fun calculateBMIMetric(weight: Double, height: Double): Double {
        return weight / (height * height)
    }

    override fun getItemCount() = dataSet.size
}