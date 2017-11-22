package mvp.imooc.com.mvpart.base;


import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import mvp.imooc.com.mvpart.mvp.BasePresenterImpl;
import mvp.imooc.com.mvpart.utils.JsoupUtils;

/**
 * 集合对象
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BizBasePresenter extends BasePresenterImpl<BaseContract.View> implements BaseContract.Presenter {
    private BaseContract.View mView;
    private BaseContract.Task mTask;

    public BizBasePresenter(BaseContract.View view) {
        mView = view;
        mTask = new BaseTask();
    }
    @Override
    public void loadData(final Class classOfT, String url, ArrayMap param) {
        mView.showLoding();
        mTask.loadData(mView.getContext(), url, param, new RxStringCallback() {
            @Override
            public void onNext(Object tag, String response) {
                if (!TextUtils.isEmpty(response)) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        int code = jsonObject.getInt("code");
                        if (code == 200) {
                            String jsonStr = jsonObject.getJSONObject("data").getJSONArray("result").toString();
                            List result = JsoupUtils.parseTList(jsonStr, classOfT);
                            mView.loadSuccess(result);
                        } else {
                            mView.onFailed(jsonObject.getString("msg"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                mView.hideLoading();
            }

            @Override
            public void onError(Object tag, Throwable e) {
                mView.hideLoading();
                mView.onFailed(e.getMessage());
            }

            @Override
            public void onCancel(Object tag, Throwable e) {
                mView.hideLoading();
            }
        });
    }
}
