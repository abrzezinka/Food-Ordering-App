package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.CategoryService
import com.example.foodorderingapp.api.RetrofitClient
import com.example.foodorderingapp.model.Category
import com.example.foodorderingapp.repositories.CategoryRepository
import retrofit2.*

class CategoryViewModel(): ViewModel() {
    var readAllData: MutableLiveData<List<Category>>
    private val retroInstance: Retrofit
    private val categoryService: CategoryService
    private val repository: CategoryRepository

    init {
        readAllData = MutableLiveData()
        retroInstance = RetrofitClient.getRetroInstance()
        categoryService = retroInstance.create(CategoryService::class.java)
        repository = CategoryRepository(categoryService)

    }

    fun getLiveDataObserver(): MutableLiveData<List<Category>> {
        return readAllData
    }

    fun categoriesDataCall(){
        val call = repository.getCategoriesList()
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