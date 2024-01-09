package com.coroutinewithroom

import com.google.gson.Gson
import mock.createMockApi
import mock.mockAndroidVersions
import utils.MockNetworkInterceptor

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