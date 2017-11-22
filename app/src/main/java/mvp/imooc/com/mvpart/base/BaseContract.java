package mvp.imooc.com.mvpart.base;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.tamic.novate.callback.RxStringCallback;

import mvp.imooc.com.mvpart.mvp.BasePresenter;
import mvp.imooc.com.mvpart.mvp.BaseView;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BaseContract {
    public interface View<T> extends BaseView {
        void loadSuccess(T result);
    }
    public interface Presenter extends BasePresenter<View> {
        void loadData(Class obj, String url, ArrayMap<String, Object> param);
    }
    public interface Task {
        void loadData(Context context, String url, ArrayMap<String, Object> param, RxStringCallback callBack);
    }
}
