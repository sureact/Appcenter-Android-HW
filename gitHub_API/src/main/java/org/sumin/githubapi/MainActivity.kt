package org.sumin.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.hanbit.networkretrofit.CustomAdapter
import org.sumin.githubapi.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}    //바인딩 생성후 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CustomAdapter()   //커스텀 아답터 생성
        binding.recyclerView.adapter =adapter       //리사이클러뷰에 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this)  //리니어 레이아웃 메니저 연결결

        val retrofit = Retrofit.Builder().baseUrl("http://api.github.com")
               .addConverterFactory(GsonConverterFactory.create()).build()

        //버튼이 클릭될 때
        binding.buttonRequest.setOnClickListener {
            val githubService = retrofit.create(GithubService::class.java)
            githubService.users().enqueue(object : Callback<Repository>{
                override fun onFailure(call: Call<Repository>, t: Throwable) {
                    Log.d("response","응답안됨")
                }
                override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                    Log.d("response","응답됨")
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