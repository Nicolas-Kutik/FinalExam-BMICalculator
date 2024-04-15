package ca.lakeheadu.finalexam

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

/**
 * DataManager Singleton
 */
class DataManager private constructor()
{
    private val db = FirebaseFirestore.getInstance()
    private val collectionRef = db.collection("BMI")

    fun getBMI(onComplete: (List<Data>) -> Unit) {
        collectionRef.get()
            .addOnSuccessListener { result ->
                val notes = result.mapNotNull { it.toObject<Data>() }
                onComplete(notes)
            }
            .addOnFailureListener {
                onComplete(emptyList())
            }
    }

    fun addBMI(newBMI: Data, onComplete: (Boolean) -> Unit) {
        collectionRef
            .add(newBMI)
            .addOnSuccessListener {
                onComplete(true)
            }
            .addOnFailureListener {
                onComplete(false)
            }
    }

    fun deleteBMIById(BMI_Id: String, onComplete: (Boolean) -> Unit) {
        collectionRef
            .document(BMI_Id)
            .delete()
            .addOnSuccessListener {
                onComplete(true)
            }
            .addOnFailureListener {
                onComplete(false)
            }
    }

    fun getBMIById(noteId: String, onComplete: (Data?) -> Unit) {
        collectionRef
            .document(noteId)
            .get()
            .addOnSuccessListener {
                onComplete(it.toObject<Data>())
            }
            .addOnFailureListener {
                onComplete(null)
            }
    }

    fun updateBMI(noteId: String, updatedNote: Data, onComplete: (Boolean) -> Unit) {
        collectionRef
            .document(noteId)
            .set(updatedNote)
            .addOnSuccessListener {
                onComplete(true)
            }
            .addOnFailureListener {
                onComplete(false)
            }
    }

    companion object {
        val instance: DataManager by lazy { DataManager() }
    }
}