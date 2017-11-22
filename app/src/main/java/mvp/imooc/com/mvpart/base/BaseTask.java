package mvp.imooc.com.mvpart.base;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.tamic.novate.Novate;
import com.tamic.novate.callback.RxStringCallback;

/**
 * @author:candy
 * @date:2017/11/22 10:56
 * @邮箱:1601796593@qq.com
 */
public class BaseTask implements BaseContract.Task {
    @Override
    public void loadData(Context context, String url, ArrayMap<String, Object> param, final RxStringCallback callBack) {
        new Novate.Builder(context)
                .baseUrl("http://xh.2188.com.cn/app/")
                .build()
                .rxPost(url,param,callBack);
    }
}
