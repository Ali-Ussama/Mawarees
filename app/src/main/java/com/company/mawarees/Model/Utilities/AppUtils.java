package com.company.mawarees.Model.Utilities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

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


}


