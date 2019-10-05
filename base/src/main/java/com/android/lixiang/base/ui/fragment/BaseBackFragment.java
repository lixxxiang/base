package com.android.lixiang.base.ui.fragment;

import android.content.Context;

public class BaseBackFragment extends MySupportFragment {
    protected OnFragmentHoldDrawerListener mHoldDraweListener;

    protected void initToolbarNav() {
        mHoldDraweListener.onHoldDrawer();
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pop();
//            }
//        });
    }

    public interface OnFragmentHoldDrawerListener {
        void onHoldDrawer();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentHoldDrawerListener) {
            mHoldDraweListener = (OnFragmentHoldDrawerListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentOpenDrawerListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mHoldDraweListener = null;
    }
}