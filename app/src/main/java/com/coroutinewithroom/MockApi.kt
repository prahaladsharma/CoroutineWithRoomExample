package com.coroutinewithroom

import com.google.gson.Gson
import com.coroutinewithroom.mock.createMockApi
import com.coroutinewithroom.mock.mockAndroidVersions
import com.coroutinewithroom.utils.MockNetworkInterceptor

fun mockApi() =
    createMockApi(
        MockNetworkInterceptor()
            .mock(
                "http://localhost/recent-android-versions",
                { Gson().toJson(mockAndroidVersions) },
                200,
                5000
            )
    )