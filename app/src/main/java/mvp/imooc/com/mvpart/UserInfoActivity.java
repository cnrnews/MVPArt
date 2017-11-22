package mvp.imooc.com.mvpart;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.widget.Toast;

import mvp.imooc.com.mvpart.base.BaseContract;
import mvp.imooc.com.mvpart.base.BizBasePresenter;
import mvp.imooc.com.mvpart.base.SingleBasePresenter;
import mvp.imooc.com.mvpart.entity.User;
import mvp.imooc.com.mvpart.mvp.MVPBaseActivity;

/***
 * @author admini
 */
public class UserInfoActivity extends MVPBaseActivity<BaseContract.View, BizBasePresenter> implements
        BaseContract.View<User> {
    private SingleBasePresenter mBizBasePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        mBizBasePresenter = new SingleBasePresenter(this);
        ArrayMap<String, Object> param = new ArrayMap<>(1);
        param.put("id", 21);
        mBizBasePresenter.loadData(User.class, "http://xh.2188.com.cn/app/user/info?format=json", param);
    }
    @Override
    public void loadSuccess(User result) {
        Toast.makeText(this, result.getUsername(), Toast.LENGTH_SHORT).show();
    }
}
