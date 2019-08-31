package com.tutorialsbuzz.androifromgson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //FROM (JSON > MODEL) (Simple JSON)
        fromJSimpleSONToModel()


        //FROM (JSON > MODEL) (ARRAY of JSON)
        fromArrayOfJSONToModel()

        //TO (MODEL > JSON) (Simple JSON)
        toJSONSimpleJSON()

        //TO (MODEL > JSON) (ARRAY Of JSON)
        toJSONArrayOfJSON()

    }

    private fun fromJSimpleSONToModel(): Unit {
        val response = readFromAssets("sample.json")

        val gson = Gson()
        val model: Model = gson.fromJson(response, Model::class.java)

        Log.d("fromJSimpleSONToModel: ", "${model.name},${model.age}")
    }

    private fun fromArrayOfJSONToModel(): Unit {

        val response = readFromAssets("country.json");

        val gson = Gson()
        val countryList: List<Country> = gson.fromJson(response, Array<Country>::class.java).toList()

        for (country: Country in countryList) {
            Log.d("fromArrayOfJSONToModel", "${country.name} , ${country.capital} \n")
        }
    }

    private fun readFromAssets(fileName: String): String {

        val bufferReader = application.assets.open(fileName).bufferedReader()
        return bufferReader.use {
            it.readText()
        }
    }


    private fun toJSONSimpleJSON(): Unit {
        val model = Model("John", 29)
        val gson = Gson()
        Log.d("ToJSONSimpleJSON : ", gson.toJson(model));

    }

    private fun toJSONArrayOfJSON(): Unit {
        val countryList: MutableList<Country> = mutableListOf<Country>()

        countryList.add(Country("India", "Delhi"))
        countryList.add(Country("United States of America", "Washington D C"))
        countryList.add(Country("United Kingdom", "London"))
        countryList.add(Country("Australia", "Canbera"))
        countryList.add(Country("France", "Paris"))
        countryList.add(Country("Australia", "Canbera"))
        countryList.add(Country("Germany", "Berlin"))
        countryList.add(Country("Russia", "Moscow"))
        countryList.add(Country("Sweden", "Stockholm"))

        val gson = Gson()

        Log.d("ToJSONArrayOfJSON : ", gson.toJson(countryList));
    }

}
