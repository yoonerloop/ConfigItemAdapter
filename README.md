  一个可以动态配置item的Adapter，支持配置正文形式，图集形式，短视频形式，文本形式，以及广告插入，专题、通栏、banner图、图布局和根布局等多种形式。支持下拉刷新、上拉加载，支持加载中布局，加载更多布局，加载失败布局，加载空数据布局。
  
## 理念
不管是头布局，脚布局，图文布局，还是轮播图等，把每一种类型的布局都看作一个Item的类型，这样，每次添加一个内容的时候都可以把它当作Recycleview的一个Item，只需要给数据集合中添加一个Item，然后刷新数据，这个添加根据服务器返回数据是动态添加，因此可以动态适配各种布局类型。如下：

![这里写图片描述](https://github.com/yoonerloop/DesignDemo/blob/master/yanshi.gif)

## 使用
1、引入Adapter库文件。<br/>
2、Fragment继承自BaseFragment。<br/>

```
public class MyFragment extends BaseFragment<DataBean.ResultBean.ContentBean> {  
    /** 
     * 下拉刷新逻辑处理 
     */  
    @Override  
    protected void onPullRefresh() {  
  
    }  
  
    /** 
     * 上拉加载逻辑处理 
     */  
    @Override  
    protected void onLoadingMore() {  
  
    }  
  
    /** 
     * 初始化数据，访问网络，网络请求 
     */  
    @Override  
    protected void initData() {  
  
    }  
  
    /** 
     * 对网络请求的数据进行处理，返回Adapter所有要传递参数的集合 
     * @param list 
     * @return 
     */  
    @Override  
    protected List<Item> getItem(List<DataBean.ResultBean.ContentBean> list) {  
        return null;  
    }  
}  
```
