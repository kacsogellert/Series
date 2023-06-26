package com.series.app.shared

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwNjZlY2ZmNjhhODcyYzU0NTZhMTdlMmNlNGU0Y2EyMCIsInN1YiI6IjY0OTU5OWE4YTI4NGViMDExY2RiOWQ5YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.S88cUxrYKhvFopBVBYKW5jC3w2yKEThFT1Y9c6tiSuI")
            .addHeader("accept", "application/json")
            .build()
        return chain.proceed(newRequest)
    }
}
