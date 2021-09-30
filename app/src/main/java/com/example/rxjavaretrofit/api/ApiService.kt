package com.example.rxjavaretrofit.api

import com.example.rxjavaretrofit.data.request.LoginRequestData
import com.example.rxjavaretrofit.data.response.LoginResponseData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-type: application/json")
    @POST("auth/login")
    fun login(
        @Body loginData: LoginRequestData
    ): Observable<LoginResponseData>
}