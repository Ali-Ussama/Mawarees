package com.company.mawarees.Model.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.company.mawarees.R;

public class AppUtils {

    public static void startActivity(Context context, Class<?> activity_class, Bundle data) {
        Intent intent = new Intent(context, activity_class);
        if (data != null)
            intent.putExtras(data);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class<?> activity_class,
                                     Bundle data, String action) {
        Intent intent = new Intent(context, activity_class);
        if (data != null)
            intent.putExtras(data);
        if (!TextUtils.isEmpty(action))
            intent.setAction(action);
        context.startActivity(intent);
    }

    public static void startActivityForResult(Context context, Class<?> activity_class, Bundle data, int reqCode) {
        Intent intent = new Intent(context, activity_class);
        if (data != null)
            intent.putExtras(data);
        ((FragmentActivity) context).startActivityForResult(intent, reqCode);
    }


    public static void startActivityForResult(Fragment fragment, Class<?> activity_class,
                                              Bundle data, int reqCode) {
        Intent intent = new Intent(fragment.getActivity(), activity_class);
        if (data != null)
            intent.putExtras(data);
        fragment.startActivityForResult(intent, reqCode);
    }

    public static MaterialDialog showProgressDialog(Context context, String message) {
        return new MaterialDialog.Builder(context)
                //.title(getString(R.string.str_dialog_waiting_msg))
                .content(message)
                .cancelable(false)
                .autoDismiss(false)
                .progress(true, 100)
                .show();
    }

    public static void showAlertDialog(Context context, String message) {
        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .autoDismiss(false)
                .cancelable(false)
                //.title(title)
                .content(message)
                .positiveText(R.string.str_ok_lbl)
                .positiveColorRes(R.color.color_red)
                .onPositive((dialog, which) -> dialog.dismiss())
                .build();
        materialDialog.getTitleView().setTextSize(8f);
        if (!materialDialog.isShowing()) materialDialog.show();
    }

    public static MaterialDialog showAlertDialogWithCustomView(Context context, int layoutResID) {
        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .autoDismiss(false)
                .cancelable(false)
                .customView(layoutResID, false)
                .positiveText(R.string.str_ok_lbl)
                .onPositive((dialog, which) -> dialog.dismiss())
                .positiveColorRes(R.color.color_red)
                .build();
        materialDialog.getTitleView().setTextSize(8f);
        if (!materialDialog.isShowing()) materialDialog.show();
        return materialDialog;
    }

    public interface CallBack {
        void OnPositiveClicked(MaterialDialog dlg);

        void OnNegativeClicked(MaterialDialog dlg);
    }

    public static void showConfirmationDialog(Context context, String message, String positiveTXT, String negativeTXT, CallBack callBack) {
        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .autoDismiss(false)
                .cancelable(false)
                //.title(title)
                .content(message)
                .positiveText(positiveTXT)
                .positiveColorRes(R.color.color_red)
                .negativeText(negativeTXT)
                .negativeColorRes(R.color.color_red)
                .onPositive((dialog, which) -> callBack.OnPositiveClicked(dialog))
                .onNegative((dialog, which) -> {
                    dialog.dismiss();
                    callBack.OnNegativeClicked(dialog);
                })
                .build();
        materialDialog.getTitleView().setTextSize(8f);
        if (!materialDialog.isShowing()) materialDialog.show();
    }

    public static Toolbar setupToolbar(AppCompatActivity activity, int homeIcon) {
        Toolbar toolbar = ((Activity) activity).findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
            if (homeIcon == -1) {
                activity.getSupportActionBar().setHomeButtonEnabled(false);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            } else if (homeIcon >= 0) {
                activity.getSupportActionBar().setHomeButtonEnabled(true);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                //if (homeIcon >= 1)
                //activity.getSupportActionBar().setHomeAsUpIndicator(homeIcon);
            }
            toolbar.setContentInsetsAbsolute(0, 0);
            toolbar.getContentInsetEnd();
            //toolbar.setPadding(16, 0, 16, 0);
        }
        return toolbar;
    }

    public static void setToolbarTitle(Toolbar toolbar, String title) {
        TextView toolbarTitleTV = toolbar.findViewById(R.id.tv_toolbar_title);
        if (toolbarTitleTV != null) toolbarTitleTV.setText(title);
    }

    public static void setToolbarHomeIcon(AppCompatActivity activity, int homeIcon) {
        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().setHomeAsUpIndicator(homeIcon);
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}


