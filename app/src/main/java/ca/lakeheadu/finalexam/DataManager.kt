package ca.lakeheadu.finalexam

/**
 * DataManager Singleton
 */
class DataManager private constructor()
{
    companion object
    {
        val instance: DataManager by lazy { DataManager() }
    }
}