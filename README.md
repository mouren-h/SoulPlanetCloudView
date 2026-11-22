# SoulPlanetCloudView Demo

```{=html}
<p align="center">
```
`<b>`{=html}一个基于 Android 原生 Java
的星球云社区板块展示示例`</b>`{=html}
```{=html}
</p>
```
```{=html}
<p align="center">
```
`<img src="https://img.shields.io/badge/Platform-Android-brightgreen?logo=android" alt="Platform">`{=html}
`<img src="https://img.shields.io/badge/Language-Java-orange?logo=java" alt="Language">`{=html}
`<img src="https://img.shields.io/badge/Build-Gradle-blue?logo=gradle" alt="Gradle">`{=html}
`<img src="https://img.shields.io/badge/Dependency-JitPack-informational" alt="JitPack">`{=html}
```{=html}
</p>
```
## 项目简介

SoulPlanetCloudView Demo 是一个 Android 星球云效果展示项目，使用
`SoulPlanetCloudView` 将不同社区板块以彩色星球标签的形式呈现。

项目基于 Java 和 XML
布局开发，适合用于社区分类、兴趣标签、内容入口等场景。

## 功能特性

-   彩色星球标签展示
-   支持自定义星球颜色
-   支持调整星球半径
-   支持设置滚动速度
-   支持自动滚动
-   支持手动拖动
-   支持监听星球点击事件
-   使用原生 Android Java + XML

## 项目截图

> 可将项目运行截图上传到仓库，例如放在 `screenshots/`
> 目录，然后替换下面的图片路径。

``` text
screenshots/
└── preview.png
```

```{=html}
<!-- 将截图上传到仓库后，取消下面这行注释并按实际路径修改 -->
```
```{=html}
<!-- ![项目运行截图](screenshots/preview.png) -->
```
## 环境要求

-   Android Studio 或支持标准 Android Gradle 项目的 IDE（例如
    CodeAssist）
-   Android SDK
-   Java
-   Gradle

## 添加依赖

### 1. 配置仓库

在项目级 `settings.gradle` 的 `dependencyResolutionManagement` 中添加
JitPack 仓库：

``` gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. 添加库依赖

在 `app/build.gradle` 的 `dependencies` 中添加：

``` gradle
dependencies {
    implementation 'com.github.mouren-h:SoulPlanetCloudView:1.3'
}
```

## XML 布局

在 `res/layout/activity_main.xml` 中放入星球云控件：

``` xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main_v"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <mr.x.soulplanetcloudview.SoulPlanetCloudView
        android:id="@+id/v1"
        android:layout_width="match_parent"
        android:layout_height="320dp" />

</LinearLayout>
```

## Java 使用示例

下面展示控件的基本初始化方式。示例中的 `星球列表控件` 是 XML 中
`@+id/v1` 对应的 View。

``` java
private SoulPlanetCloudView 星球列表控件;
private SimpleLayoutManager 布局管理器;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    星球列表控件 = findViewById(R.id.v1);

    布局管理器 = new SimpleLayoutManager(this);

    星球列表控件.setDarkColor(Color.RED);
    星球列表控件.setLightColor(Color.GREEN);
    星球列表控件.setRadiusPercent(0.75f);
    星球列表控件.setScrollSpeed(20);
    星球列表控件.setManualScroll(true);
    星球列表控件.setAutoScrollMode(1);

    星球列表控件.setAdapter(布局管理器);

    星球列表控件.setOnTagClickListener(
        new SoulPlanetsView.OnTagClickListener() {
            @Override
            public void onTagClick(int position) {
                // 根据 position 获取对应的板块数据
            }
        }
    );
}
```

> 注意：以上代码是控件初始化示例。实际项目还需要创建数据列表，并按照
> `SimpleLayoutManager` 的数据格式添加数据。若 XML
> 已经声明了星球云控件，不要再对同一个控件重复调用 `addView()`。

## 关于自定义包装类

本示例使用自定义类：

``` java
mr.x.soulplanetcloudview.SoulPlanetCloudView
```

该类继承自原始的 `SoulPlanetsView`，用于在当前项目中封装控件。

由于部分发布包可能缺少原库生成的 `R.styleable` 资源，包装类可以通过
`super(context)` 绕过父类构造阶段的 XML 自定义属性解析，再按需读取
`android:id` 等基础属性。

**说明：** 这种处理方式不等于完整支持原库的所有自定义 XML
属性。控件继承的 Java 方法仍可使用，但原库依赖构造阶段解析的自定义 XML
属性需要另行处理。

## 项目结构

``` text
app/
├── src/
│   └── main/
│       ├── java/
│       │   ├── com/example/myapp/
│       │   │   └── MainActivity.java
│       │   └── mr/x/soulplanetcloudview/
│       │       └── SoulPlanetCloudView.java
│       └── res/
│           └── layout/
│               └── activity_main.xml
└── build.gradle
```

## 适用场景

-   社区兴趣板块
-   兴趣标签云
-   内容分类入口
-   用户兴趣展示
-   轻量级数据可视化

## 致谢

本项目使用的星球云控件依赖：

``` gradle
implementation 'com.github.mouren-h:SoulPlanetCloudView:1.3'
```

感谢原作者的开源分享。

## License

请遵循原始依赖项目的许可证要求。当前 Demo
自身的许可证可根据仓库实际情况补充。
