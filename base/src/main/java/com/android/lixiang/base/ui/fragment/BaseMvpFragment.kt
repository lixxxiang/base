package com.android.lixiang.base.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.android.lixiang.base.common.BaseApplication
import com.android.lixiang.base.injection.component.ActivityComponent
import com.android.lixiang.base.injection.component.DaggerActivityComponent
import com.android.lixiang.base.injection.component.DaggerFragmentComponent
import com.android.lixiang.base.injection.component.FragmentComponent
import com.android.lixiang.base.injection.module.ActivityModule
import com.android.lixiang.base.injection.module.FragmentModule
import com.android.lixiang.base.injection.module.LifecycleProviderModule

import com.android.lixiang.base.presenter.BasePresenter
import com.android.lixiang.base.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpFragment<T: BasePresenter<*>>: BaseFragmentInJava(), BaseView {
//    protected var mHoldDraweListener: OnFragmentHoldDrawerListener? = null
    @Inject
    lateinit var mPresenter: T

    @Inject
    lateinit var fragmentComponent: FragmentComponent


//    protected fun initToolbarNav() {
//        mHoldDraweListener!!.onHoldDrawer()
//
//    }

    interface OnFragmentHoldDrawerListener {
        fun onHoldDrawer()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
//        if (context is OnFragmentHoldDrawerListener) {
//            mHoldDraweListener = context
//        } else {
//                        throw new RuntimeException(context.toString()
//                                + " must implement OnFragmentOpenDrawerListener");
//        }
    }

    override fun onDetach() {
        super.onDetach()
//        mHoldDraweListener = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    abstract fun injectComponent()


    private fun initActivityInjection() {
//        activityComponent = DaggerActivityComponent.builder()
//                .appComponent((activity.application as BaseApplication).appComponent)
//                .activityModule(ActivityModule(activity))
//                .build()
//
        fragmentComponent = DaggerFragmentComponent.builder()
            .appComponent((activity!!.application as BaseApplication).appComponent)
            .fragmentModule(FragmentModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }
}