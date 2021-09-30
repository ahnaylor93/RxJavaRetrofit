package com.example.rxjavaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxjavaretrofit.api.ApiClient
import com.example.rxjavaretrofit.data.request.LoginRequestData
import com.example.rxjavaretrofit.data.response.LoginResponseData
import com.example.rxjavaretrofit.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var user: LoginResponseData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val observable: Observable<LoginResponseData> = ApiClient.apiService.login(LoginRequestData("test@gmail.com", "abc123"))

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())

    }


        private fun getObservable(): Observable<LoginResponseData> {
            return Observable.just(user)
        }

    private fun getObserver(): Observer<LoginResponseData>{
        return object:Observer<LoginResponseData>{
            override fun onSubscribe(d: Disposable) {
                Log.d("Login Observer", "OnSubscribe")
            }

            override fun onNext(t: LoginResponseData) {
                Log.d("Login Observer", "OnNext: ${t.user?.firstName?:"Not Found"}")
            }

            override fun onError(e: Throwable) {
                Log.d("Login Observer", "OnError: ${e.message}")
            }

            override fun onComplete() {
                Log.d("Login Observer", "OnComplete")
            }

        }
    }
}