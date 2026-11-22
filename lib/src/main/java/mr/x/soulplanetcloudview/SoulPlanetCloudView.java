package mr.x.soulplanetcloudview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import me.haowen.soulplanet.view.SoulPlanetsView;

public class SoulPlanetCloudView extends SoulPlanetsView {

    private static final String TAG = "SoulPlanetDebug";

    public SoulPlanetCloudView(Context context) {
        super(context);
        logId("构造器1");
    }

    public SoulPlanetCloudView(Context context, AttributeSet attrs) {
        super(context);

        int xmlId = attrs == null ? -1 :
            attrs.getAttributeResourceValue(
                "http://schemas.android.com/apk/res/android",
                "id",
                -1
            );

        Log.e(TAG, "构造器2，XML声明的ID：" + xmlId);

        logId("构造器2");
    }

    public SoulPlanetCloudView(
        Context context,
        AttributeSet attrs,
        int defStyleAttr
    ) {
        super(context);
        logId("构造器3");
    }

    private void logId(String position) {
        Log.e(TAG, position + "，当前View ID：" + getId());
    }
}