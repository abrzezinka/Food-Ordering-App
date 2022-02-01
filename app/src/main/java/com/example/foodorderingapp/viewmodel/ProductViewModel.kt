package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.ProductService
import com.example.foodorderingapp.api.RetrofitClient
import com.example.foodorderingapp.model.Category
import com.example.foodorderingapp.model.Product
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel: ViewModel(), KoinComponent {
    var readAllData: MutableLiveData<List<Product>>
    val service: ProductService by inject()

    init {
        readAllData = MutableLiveData()

    }

    fun getLiveDataObserver(): MutableLiveData<List<Product>>{
        return readAllData
    }

    fun productsDataCall(){

        var call = service.getProductsList()
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

    // TODO create new list for data
    fun getProductsFromCategoryCall(category: Category){

        var call = service.getProductsFromCategory(category.name)
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


}