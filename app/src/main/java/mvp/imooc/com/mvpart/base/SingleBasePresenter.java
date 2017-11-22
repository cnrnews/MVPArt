package mvp.imooc.com.mvpart.base;

import android.support.v4.util.ArrayMap;

import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import mvp.imooc.com.mvpart.utils.JsoupUtils;

/**
 * 单一对象
 * @author:candy
 * @date:2017/11/22 16:12
 * @邮箱:1601796593@qq.com
 */
public class SingleBasePresenter extends BizBasePresenter {
    private BaseContract.View mBaseView;
    private BaseContract.Task mTask;
    public SingleBasePresenter(BaseContract.View view) {
        super(view);
        mBaseView=view;
        mTask=new BaseTask();
    }
    @Override
    public void loadData(final Class classOfT, String url, ArrayMap param) {
        super.loadData(classOfT, url, param);
        mBaseView.showLoding();
        mTask.loadData(mBaseView.getContext(), url, param, new RxStringCallback() {
            @Override
            public void onNext(Object tag, String response) {
                try {
                    String json=new JSONObject(response).getJSONObject("data").toString();
                    mBaseView.loadSuccess(JsoupUtils.getT(classOfT,json));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mBaseView.hideLoading();
            }
            @Override
            public void onError(Object tag, Throwable e) {
                mBaseView.hideLoading();
            }

            @Override
            public void onCancel(Object tag, Throwable e) {
                mBaseView.hideLoading();
            }
        });
    }
}
