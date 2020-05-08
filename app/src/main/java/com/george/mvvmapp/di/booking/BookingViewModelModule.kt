package com.george.mvvmapp.di.booking

import com.george.mvvmapp.di.ViewModelKey
import com.george.mvvmapp.screens.booking_fragment.BookingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BookingViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookingViewModel::class)
    abstract fun bindBookingViewModel(viewModel: BookingViewModel)

}