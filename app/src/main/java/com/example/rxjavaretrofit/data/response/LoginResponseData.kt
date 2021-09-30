package com.example.rxjavaretrofit.data.response

data class LoginResponseData(
    val token: String?,
    val user: User?,
    val error: Boolean?,
    val message: String?
)

data class User(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val firstName: String,
    val mobile: String,
    val password: String
)