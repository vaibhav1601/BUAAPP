package bramhagrjana.com.buaapp.view.Login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import bramhagrjana.com.buaapp.R;
import bramhagrjana.com.buaapp.presenter.Presenter.LoginPresenter.LoginContract;
import bramhagrjana.com.buaapp.presenter.Presenter.LoginPresenter.LoginPresenter;
import bramhagrjana.com.buaapp.view.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private LoginPresenter loginPresenter;
    private Button btnLogin,btnSignUp;
    private EditText mobile_no;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initializeView() {
        mobile_no=(EditText)findViewById(R.id.mobile_no);
        password=(EditText)findViewById(R.id.password);
        btnLogin=(Button)findViewById(R.id.email_sign_in_button);
        btnSignUp=(Button)findViewById(R.id.btn_sign_up);


    }

    @Override
    protected void initializePresenter() {

        loginPresenter= new LoginPresenter();
        loginPresenter.setLoginDetails(mobile_no.getText().toString(),password.getText().toString());

    }

    @Override
    public void onLoginSuccess(String msg) {

    }

    @Override
    public void onLoginFailed() {

    }

    @Override
    public void onInActiveUser() {

    }

    @Override
    public void showUserNameEmptyError() {

    }

    @Override
    public void showPasswordEmptyError() {

    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void showForgetProcess(boolean flag) {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void loginData(String jsonData) {

    }

    @Override
    public void userPresent(boolean val, String uname, String pwd) {

    }

    @Override
    public void passwordChanged(boolean flag) {

    }

    @Override
    public void userInactive() {

    }

    @Override
    public void userNotAllow() {

    }

    @Override
    public void accountDeactivated() {

    }

    @Override
    public void accountExpired() {

    }
}
