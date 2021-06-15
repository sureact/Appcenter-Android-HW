package org.sumin.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.sumin.githubapi.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}    //바인딩 생성후 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        val adapter = CustomAdapter()
        setContentView(binding.root)

        binding.recyclerView.adapter =adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder().baseUrl("http://api.github.com").
        addConverterFactory(GsonConverterFactory.create()).build()

        binding.buttonRequest.setOnClickListener {
            val githubService = retrofit.create(GithubService::class.java)
            githubService.users().enqueue(object : Callback<Repository>{
                override fun onFailure(call: Call<Repository>, t: Throwable) {
                }
                override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                    adapter.userList = response.body() as Repository
                    adapter.notifyDataSetChanged()
                }
            })
        }
    }
}
interface  GithubService{
    @GET("user/Kotlin/repos")
    fun users(): Call<Repository>
}