[![Build Status](https://travis-ci.org/luck-fc/SplitView.svg?branch=master)](https://travis-ci.org/luck-fc/SplitView)
[![](https://jitpack.io/v/luck-fc/SplitView.svg)](https://jitpack.io/#luck-fc/SplitView)
<a href="http://www.methodscount.com/?lib=com.github.luck-fc%3ASplitView%3AV1.0.0"><img src="https://img.shields.io/badge/Methods and size-core: 54 | deps: 16651 | 20 KB-e91e63.svg"/></a>
# SplitView
In the same view, click on the response event in different areas

The following figure is a custom example, the project has been included in the 2_2 3_2 3_3  segmentation click processing logic
下图是一个自定义的例子，该项目已列入 2x2  3x2 3x3 模式的分割点击处理逻辑
## 效果图
<img src="https://github.com/luck-fc/SplitView/blob/master/screenshot/style_other.png"/> 

## 用法
引入library 
root build.gradle加入
```xml
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
项目 build.gradle加入
```xml
    compile 'com.github.luck-fc:SplitView:V1.0.0'
```
（1）.xml加入布局
```xml
<com.luck.view.splitview.SplitImageView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/splitImageView1"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:adjustViewBounds="true"
        android:background="#11FFAA"
        android:scaleType="fitXY"
        android:src="@mipmap/ic_launcher"
        app:style="Style_2_2" />
```
（2）java代码

```xml
        //以下是3*3 模块的例子，还有2*2 3*2可选  都不满足条件还可以通过setOtherStyle()方法自定义
        SplitImageView splitImageView1 = (SplitImageView) findViewById(R.id.splitImageView1);
        splitImageView1.setOtherStyle(SplitImageView.STYLE_3_3);
        splitImageView1.setOnXYClickListener(new SplitImageView.onSplitClickListener() {
            @Override
            public void onSplitClick(View v, int position) {
                show("点到了3*3模式的第" + (position + 1) + "个区域");
            }
        }    
```
##其他
 如有疑问，请提[issue](https://github.com/luck-fc/SplitView/issues)
##以后
    该libary将会继续被维护，相信以后会封装得更方便便捷，敬请期待！
    如有更好的方式，欢迎随时Pull requests
    
开发者 (Developer)
----------------

* luck-fc - <xiaoorchao@gmail.com>

## License

    Copyright 2016 luck-fc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
