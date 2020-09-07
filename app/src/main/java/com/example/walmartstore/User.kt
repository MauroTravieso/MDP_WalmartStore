package com.example.walmartstore

import java.io.Serializable

data class User(val firstName:String, val lastName:String, val username:String, val password:String) : Serializable {
}