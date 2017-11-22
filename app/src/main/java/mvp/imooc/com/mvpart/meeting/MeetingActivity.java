package mvp.imooc.com.mvpart.meeting;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import mvp.imooc.com.mvpart.R;
import mvp.imooc.com.mvpart.base.BaseContract;
import mvp.imooc.com.mvpart.base.BizBasePresenter;
import mvp.imooc.com.mvpart.entity.Announcement;
import mvp.imooc.com.mvpart.mvp.MVPBaseActivity;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */
public class MeetingActivity extends MVPBaseActivity<BaseContract.View, BizBasePresenter> implements
        BaseContract.View<List<Announcement>> {
    private TextView mTextView;
    private BizBasePresenter mMeetingPresenter;
    private int mCurPage = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mTextView = findViewById(R.id.tv_result);
        mMeetingPresenter = new BizBasePresenter(this);
    }
    /***
     * 模拟下拉刷新
     * @param view
     */
    public void onRefresh(View view) {
        requestData(LOAD_MODE.REFRESH);
    }
    /***
     * 模拟上拉加载更多
     * @param view
     */
    public void onLoad(View view) {
        requestData(LOAD_MODE.LOAD);
    }

    LOAD_MODE mState;
    public void requestData(LOAD_MODE mode) {
        mState = mode;
        if (mode == LOAD_MODE.REFRESH) {
            mCurPage = 1;
        } else {
            mCurPage++;
        }
        ArrayMap<String, Object> param = new ArrayMap<>(3);
        param.put("user_id", 21);
        param.put("page", mCurPage);
        mMeetingPresenter.loadData(Announcement.class, "http://xh.2188.com.cn/app/Companybull/index?format=json", param);
    }
    @Override
    public void loadSuccess(List<Announcement> result) {
        if (mState == LOAD_MODE.REFRESH) {
            mTextView.setText("下拉刷新" + result.size() + ":" + result.get(0).getTitle());
        } else {
            mTextView.setText("上拉加载" + result.size() + ":" + result.get(0).getTitle());
        }
    }
    private static enum LOAD_MODE {
        REFRESH, LOAD;
    }
}
