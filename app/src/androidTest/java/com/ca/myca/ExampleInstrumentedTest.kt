package com.ca.myca

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.ca.myca", appContext.packageName)
        val client = OkHttpClient().newBuilder()
            .addInterceptor(getInterceptor())
            .build()
        val request = Request.Builder()
            .url("https://www.baidu.com/s?wd=okhttp&ie=UTF-8")
            .build()
        val response = client.newCall(request).execute()
        Log.i("aaaaaaaaaaaaa", "response ${response}")
    }

    fun getInterceptor(): Interceptor =
        object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val requestBody = chain.request().body()
                Log.i("bbbbbbbbbbbbbbbb", "${requestBody}")
                return chain.proceed(chain.request())
            }
        }
}
