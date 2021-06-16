package org.sumin.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import org.sumin.githubapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}    //바인딩 생성후 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CustomAdapter()   //커스텀 아답터 생성
        binding.recyclerView.adapter =adapter       //리사이클러뷰에 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(baseContext)  //리니어 레이아웃 메니저 연결결

        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        Log.d("retrofit","레트로핏 연결")

        val githubService = retrofit.create(GithubService::class.java)

        //버튼이 클릭될 때
        binding.buttonRequest.setOnClickListener {
            githubService.users().enqueue(object : Callback<Repository> {
                override fun onFailure(call: Call<Repository>, t: Throwable) {
                    Log.d("response","응답안됨")
                }
                override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                    Log.d("response","응답됨")
                    response.body()?.let{result ->
                        adapter.userList=result
                        adapter.notifyDataSetChanged()
                    }
                }
            })
        }

    }
}
interface  GithubService{
    @GET("users/Kotlin/repos")
    fun users(): Call<Repository>
}