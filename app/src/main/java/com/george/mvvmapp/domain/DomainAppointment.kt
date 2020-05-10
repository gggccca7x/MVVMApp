package com.george.mvvmapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainAppointment (
    val _id : Long,
    val startTimeMilli: Long
) : Parcelable