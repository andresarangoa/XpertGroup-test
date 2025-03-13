package com.app.xpertgroup.ui.config

import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers

enum class DeviceType(val qualifier: String) {
    SMALL_PHONE(RobolectricDeviceQualifiers.SmallPhone),
    PIXEL_4A(RobolectricDeviceQualifiers.Pixel4a),
    PIXEL_6(RobolectricDeviceQualifiers.Pixel6),
    PIXEL_7(RobolectricDeviceQualifiers.Pixel7),
    NEXUS_9(RobolectricDeviceQualifiers.Nexus9)
}