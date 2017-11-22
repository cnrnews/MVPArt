package mvp.imooc.com.mvpart.mvp;

import android.content.Context;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public interface BaseView{
     Context getContext();
     void showLoding();
     void hideLoading();
     void onFailed(String e);
}