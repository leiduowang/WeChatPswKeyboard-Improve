package com.lnyp.pswkeyboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.lnyp.pswkeyboard.widget.PasswordView;
import com.lnyp.pswkeyboard.widget.PopEnterPassword;

public class PaymentKeyBoardActivity extends AppCompatActivity {

    private String my_password ="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_key_board);
    }



    public void showPayKeyBoard(View view) {

        PopEnterPassword popEnterPassword = new PopEnterPassword(this);

        // 显示窗口
        popEnterPassword.showAtLocation(this.findViewById(R.id.layoutContent),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置


        popEnterPassword.initPasswordInput(PaymentKeyBoardActivity.this, new OnPasswordInputFinishText() {
            @Override
            public void inputFinishText(String password) {
                if (my_password.equals(password))
                {
                    Toast.makeText(getBaseContext(),"密码正确",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getBaseContext(),"密码不正确",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
