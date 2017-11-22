package mvp.imooc.com.mvpart.contact;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mvp.imooc.com.mvpart.R;
import mvp.imooc.com.mvpart.entity.Contact;
import mvp.imooc.com.mvpart.base.BizBasePresenter;
import mvp.imooc.com.mvpart.base.BaseContract;
import mvp.imooc.com.mvpart.mvp.MVPBaseActivity;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ContactActivity extends MVPBaseActivity<BaseContract.View, BizBasePresenter>
        implements BaseContract.View<List<Contact>> {
    private TextView mTextView;
    private ProgressDialog mProgressDialog;
    private BizBasePresenter mBizBasePresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mTextView = findViewById(R.id.tv_result);
        mBizBasePresenter = new BizBasePresenter(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("loading...");


        ArrayMap<String, Object> param = new ArrayMap<>();
        param.put("user_id", 21);
        param.put("page", 1);
        mBizBasePresenter.loadData(Contact.class,"http://xh.2188.com.cn/app/Conference/focuslist?format=json", param);
    }
    @Override
    public void showLoding() {
        mProgressDialog.show();
    }
    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }
    @Override
    public void loadSuccess(List<Contact> result) {
        mTextView.setText(result.size() + ":" + result.get(0).getCompanyname());
    }
    @Override
    public void onFailed(String e) {
        Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
    }

}
