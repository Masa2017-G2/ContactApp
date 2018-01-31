package com.sheygam.contactapp.presentetion.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.sheygam.contactapp.R;
import com.sheygam.contactapp.presentetion.login.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by gregorysheygam on 31/01/2018.
 */

public class LoginView extends MvpAppCompatFragment implements ILoginView{
    private Unbinder mUnbinder;
    EditText mInputEmail;
    EditText mInputPassword;
    Button mRegBtn;
    Button mLoginBtn;
    ProgressBar mMyProgress;

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
        //Todo AlertDialog
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
