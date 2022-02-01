package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.CategoryService
import com.example.foodorderingapp.api.RetrofitClient
import com.example.foodorderingapp.model.Category
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CategoryViewModel(val categoryService: CategoryService): ViewModel(),KoinComponent {
    var readAllData: MutableLiveData<List<Category>>

    init {
        readAllData = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Category>> {
        return readAllData
    }

    fun categoriesDataCall(){
        val service: CategoryService by inject()
        var call = service.getCategoriesList()
        call.enqueue(object: Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable){
                readAllData.postValue(null)
            }

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ){
                readAllData.postValue(response.body())
            }
        })
    }
}