package mr.x.soulplanetcloudview;

import android.content.Context;
import android.util.AttributeSet;

import me.haowen.soulplanet.view.SoulPlanetsView;

/**
 * SoulPlanetCloudView
 *
 * Soul 星球列表控件
 *
 * 直接继承 SoulPlanetsView
 * 保留原始控件的全部公开属性和方法
 */
public class SoulPlanetCloudView extends SoulPlanetsView {

    public SoulPlanetCloudView(Context context) {
        super(context);
    }

    public SoulPlanetCloudView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SoulPlanetCloudView(
            Context context,
            AttributeSet attrs,
            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}