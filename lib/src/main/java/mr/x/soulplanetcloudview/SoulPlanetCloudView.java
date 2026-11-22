package mr.x.soulplanetcloudview;

import android.content.Context;
import android.util.AttributeSet;

import me.haowen.soulplanet.view.SoulPlanetsView;

/**
 * SoulPlanetCloudView
 *
 * Soul 星球云控件
 *
 * 直接继承 SoulPlanetsView
 * 兼容 XML 布局加载
 * 避免原始 JAR 缺少 R$styleable 导致闪退
 */
public class SoulPlanetCloudView extends SoulPlanetsView {

    public SoulPlanetCloudView(Context context) {
        super(context);
    }

    public SoulPlanetCloudView(
            Context context,
            AttributeSet attrs) {

        // 不传递 attrs，避免访问缺失的 R$styleable
        super(context);
    }

    public SoulPlanetCloudView(
            Context context,
            AttributeSet attrs,
            int defStyleAttr) {

        // 不传递 attrs，避免访问缺失的 R$styleable
        super(context);
    }
}