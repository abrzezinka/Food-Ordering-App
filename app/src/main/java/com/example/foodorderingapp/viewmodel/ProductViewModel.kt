package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.ProductService
import com.example.foodorderingapp.api.RetrofitClient
import com.example.foodorderingapp.model.Category
import com.example.foodorderingapp.model.Product
import com.example.foodorderingapp.repositories.ProductRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ProductViewModel: ViewModel(){
    var readAllData: MutableLiveData<List<Product>>
    var readCategoryData: MutableLiveData<List<Product>>
    private val retroInstance = RetrofitClient.getRetroInstance()
    private val productService: ProductService = retroInstance.create(ProductService::class.java)
    private val repository = ProductRepository(productService)

    init {

        readAllData = MutableLiveData()
        readCategoryData = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Product>>{
        return readAllData
    }

    fun getCategoryLiveDataObserver(): MutableLiveData<List<Product>>{
        return readCategoryData
    }

    fun productsDataCall(){
        var call = repository.getProductsList()
        call.enqueue(object: Callback<List<Product>> {
             override fun onFailure(call: Call<List<Product>>, t: Throwable){
                readAllData.postValue(null)
            }
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ){
                readAllData.postValue(response.body())
            }
        })
    }


    fun getProductsFromCategoryCall(category: Category){

        var call = repository.getProductsFromCategory(category.name)
        call.enqueue(object: Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable){
                readCategoryData.postValue(null)
            }

            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ){
                readCategoryData.postValue(response.body())
            }
        })
    }


}