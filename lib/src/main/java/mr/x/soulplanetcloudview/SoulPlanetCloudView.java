package mr.x.soulplanetcloudview;

import android.content.Context;
import android.util.AttributeSet;

import me.haowen.soulplanet.view.SoulPlanetsView;

public class SoulPlanetCloudView extends SoulPlanetsView {

    public SoulPlanetCloudView(Context context) {
        super(context);
    }

    public SoulPlanetCloudView(Context context, AttributeSet attrs) {
        super(context);
        解析XML属性(attrs);
    }

    public SoulPlanetCloudView(
            Context context,
            AttributeSet attrs,
            int defStyleAttr
    ) {
        super(context);
        解析XML属性(attrs);
    }

    /**
     * 手动解析 XML 中声明的 android:id
     */
    private void 解析XML属性(AttributeSet attrs) {

        if (attrs == null) {
            return;
        }

        int xmlId = attrs.getAttributeResourceValue(
                "http://schemas.android.com/apk/res/android",
                "id",
                ViewId.NO_ID
        );

        if (xmlId != ViewId.NO_ID) {
            setId(xmlId);
        }
    }

    private static class ViewId {
        static final int NO_ID = -1;
    }
}
