package com.example.lenovo.flag;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeleteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DeleteFragment extends DialogFragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    public DeleteFragment() {

        // Required empty public constructor
    }
    public static DeleteFragment newInstance() {
        DeleteFragment df = new DeleteFragment();
        return df;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_delete,container,false);
        Button yesBtn=(Button) v.findViewById(R.id.btn_yes);
        Button cancleBtn=(Button) v.findViewById(R.id.btn_cancle);
        yesBtn.setOnClickListener(this);
        cancleBtn.setOnClickListener(this);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置dialog的背景为透明
       //   this.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return v;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);//无法直接点击外部取消dialog
        setStyle(DialogFragment.STYLE_NO_FRAME,0); //NO_FRAME就是dialog无边框，0指的是默认系统Theme
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_Dialog_Fragment);//背景变暗styles.xml
      //  setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }
    //弹出框占用屏幕宽度75%
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.9), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
    public void onClick(View v) {  //点击事件
        switch (v.getId()) {
            case R.id.btn_cancle:
                break;
            case R.id.btn_yes:
                int index=getArguments().getInt("index");
                MainActivity mainActivity=(MainActivity) getActivity();
                mainActivity.onUserSelect(index);
                break;
            default:
                break;
        }
        dismiss();
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
