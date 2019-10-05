package com.android.lixiang.base.ui.fragment;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.android.lixiang.base.R;
import com.orhanobut.logger.Logger;


/**
 * Created by YoKeyword on 16/2/3.
 */
public class BaseMainFragment extends MySupportFragment {

    protected OnFragmentOpenDrawerListener mOpenDraweListener;

    protected void initToolbarNav(Toolbar toolbar) {
        initToolbarNav(toolbar, false);
    }

    protected void initToolbarNav(Toolbar toolbar, boolean isHome) {
//        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
//        toolbar.setTitle("");
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Logger.d("OPEN");
//                if (mOpenDraweListener != null) {
//                    mOpenDraweListener.onOpenDrawer();
//                }
//            }
//        });
        mOpenDraweListener.onUnHoldDrawer();
    }

    protected void initToolbarBack() {
        mOpenDraweListener.onHoldDrawer();
    }

    protected void initDataToolbarBack(Toolbar toolbar, String title) {
        mOpenDraweListener.onHoldDrawer();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle(title);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pop();
//            }
//        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOpenDrawerListener) {
            mOpenDraweListener = (OnFragmentOpenDrawerListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentOpenDrawerListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOpenDraweListener = null;
    }

    public interface OnFragmentOpenDrawerListener {
        void onOpenDrawer();
        void onHoldDrawer();
        void onUnHoldDrawer();
    }
}
