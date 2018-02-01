package com.sheygam.contactapp.presentetion.login.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.sheygam.contactapp.R;
import com.sheygam.contactapp.presentetion.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by gregorysheygam on 31/01/2018.
 */

public class LoginView extends MvpAppCompatFragment implements ILoginView{
    private Unbinder mUnbinder;

    @BindView(R.id.inputEmail)
    EditText mInputEmail;
    @BindView(R.id.inputPassword)
    EditText mInputPassword;
    @BindView(R.id.regBtn)
    Button mRegBtn;
    @BindView(R.id.loginBtn)
    Button mLoginBtn;
    @BindView(R.id.myProgress)
    ProgressBar mMyProgress;

    private AlertDialog dialog;

    @InjectPresenter
    LoginPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_view,container,false);
        mUnbinder = ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.loginBtn)
    void onLoginClick(){
        presenter.actionLogin(mInputEmail.getText().toString(),mInputPassword.getText().toString());
    }

    @OnClick(R.id.regBtn)
    void onRegClick(){
        presenter.actionRegistration(mInputEmail.getText().toString(), mInputPassword.getText().toString());
    }



    @Override
    public void showProgress() {
        mMyProgress.setVisibility(View.VISIBLE);
        mInputEmail.setVisibility(View.INVISIBLE);
        mInputPassword.setVisibility(View.INVISIBLE);
        mLoginBtn.setVisibility(View.INVISIBLE);
        mRegBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mMyProgress.setVisibility(View.INVISIBLE);
        mInputEmail.setVisibility(View.VISIBLE);
        mInputPassword.setVisibility(View.VISIBLE);
        mLoginBtn.setVisibility(View.VISIBLE);
        mRegBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginSuccess(@NonNull String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        //Todo replace to ContactListView
    }

    @Override
    public void showError(@NonNull String error) {
        dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Error!")
                .setMessage(error)
                .setOnDismissListener(dialog -> presenter.onErrorDialogDismiss()).create();
        dialog.show();


    }

    @Override
    public void hideErrorDialog() {
        if(dialog!=null){
            dialog.dismiss();
        }
    }

    @Override
    public void putEmailError(String error) {
        mInputEmail.setError(error);
    }

    @Override
    public void putPasswordError(String error) {
        mInputPassword.setError(error);
    }

    @Override
    public void clearInputError() {
        mInputPassword.setError(null);
        mInputEmail.setError(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(dialog != null){
            dialog.setOnDismissListener(null);
            dialog.dismiss();
        }
        mUnbinder.unbind();
    }
}
