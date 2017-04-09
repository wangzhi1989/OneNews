# OneNews 简单的新闻客户端 #

2017/4/7 15:05:52 

## 1.Using the Design Support Library.

**参考：**

* Using the Design Support Library<br>https://developer.android.com/training/material/design-library.html</br>

* Android Design Support Library（1）- FloatingActionButton的使用<br>http://blog.csdn.net/leejizhou/article/details/50479934</br>

* Android Design Support Library（2）- TextInputLayout的使用<br>http://blog.csdn.net/leejizhou/article/details/50494634</br>

* Android Design Support Library（3）- Snackbar的使用<br>http://blog.csdn.net/leejizhou/article/details/50513833</br>

* Android Design Support Library（4）- TabLayout的使用<br>http://blog.csdn.net/leejizhou/article/details/50520547</br>

* Android Design Support Library（5）- CoordinatorLayout的入门使用<br>http://blog.csdn.net/leejizhou/article/details/50533020</br>


Design Support Library包含8个控件，具体如下：

Widget Name     								  | Description 				    | Picture 
:-------- 										  | :---								| :--:  
android.support.design.widget.TextInputLayout	  | 强大带提示的MD风格的EditText	    | ![](http://img.blog.csdn.net/20150603142024003) |
android.support.design.widget.FloatingActionButton| MD风格的圆形按钮，来自于 ImageView | ![](http://img.blog.csdn.net/20150603142131566) | 
android.support.design.widget.Snackbar            | 类似Toast，添加了简单的单个Action	| ![](http://img.blog.csdn.net/20150603142348085) |
android.support.design.widget.TabLayout	          | 选项卡							| ![](http://img.blog.csdn.net/20150603142328036) | 
android.support.design.widget.NavigationView      | DrawerLayout的SlideMenu			| ![](http://img.blog.csdn.net/20150603142539875) | 
android.support.design.widget.CoordinatorLayout   | 超级FrameLayout					| ![](http://img.blog.csdn.net/20150603142453883) |   
android.support.design.widget.AppBarLayout	      | MD风格的滑动Layout				| ![](http://img.blog.csdn.net/20150603142727562) |
android.support.design.widget.CollapsingToolbarLayout| 可折叠MD风格ToolbarLayout		| ![](http://img.blog.csdn.net/20150603142632834) |  

### TextInputLayout
在MD中，使用TextInputLayout将EditText进行了封装，提示信息会变成一个显示在EditText之上的floating label，这样用户就始终知道他们现在输入的是什么，而且过度动画是平滑的。还可以在下方通过setError设置Error提示，使用比较简单。

**注意项：**

TextInputLayout中至少嵌套一个EditText。
### FloatingActionButton
一个负责显示界面基本操作的圆形按钮。Design library中的FloatingActionButton 实现了一个默认颜色为主题中colorAccent的悬浮操作按钮。除了一般大小的悬浮操作按钮，它还支持mini size（fabSize=”mini”）。FloatingActionButton继承自ImageView，你可以使用android:src或者 ImageView的任意方法，比如setImageDrawable()来设置FloatingActionButton里面的图标。
### Snackbar
Snackbar为一个操作提供轻量级、快速的反馈。Snackbar显示在屏幕的底部（有MD动画效果浮现和消失），包含了文字信息与一个可选的操作按钮。在指定时间结束之后自动消失。另外，用户还可以在超时之前将它滑动删除。Snackbar被看作是比Toast更强大的快速反馈机制，你会发现他们的API非常相似。你应该注意到了make()方法中把一个View作为第一个参数（Snackbar试图找到一个合适的父亲以确保自己是被放置于底部）。
### TabLayout
通过选项卡的方式切换View并不是MD中才有的新概念，它们和顶层导航模式或者组织app中不同分组内容（比如，不同风格的音乐）是同一个概念。 Design library的TabLayout 既实现了固定的选项卡（View的宽度平均分配），也实现了可滚动的选项卡（View宽度不固定同时可以横向滚动）。如果你使用ViewPager在 tab之间横向切换，你可以直接从PagerAdapter的getPageTitle() 中创建选项卡，然后使用setupWithViewPager()将两者联系在一起。它可以使tab的选中事件能更新ViewPager,同时 ViewPager的页面改变能更新tab的选中状态。

**注意项：**

如果你使用ViewPager在tab之间横向切换，切记可以直接从PagerAdapter的getPageTitle() 中创建选项卡，然后使用setupWithViewPager()将两者联系在一起。
### NavigationView
抽屉导航是app识别度与内部导航的关键，保持这里设计上的一致性对app的可用性至关重要，尤其是对于第一次使用的用户。 NavigationView 通过提供抽屉导航所需的框架让实现更简单，同时它还能够直接通过菜单资源文件直接生成导航元素。把NavigationView作为 DrawerLayout的内容视图来使用。NavigationView处理好了和状态栏的关系，可以确保NavigationView在API21+ 设备上正确的和状态栏交互。

**注意项：**

你可以通过设置一个OnNavigationItemSelectedListener，使用其 setNavigationItemSelectedListener()来获得元素被选中的回调事件。它为你提供被点击的菜单元素，让你可以处理选择事件、改变复选框状态、加载新内容、关闭导航菜单，以及其他任何你想做的操作。你会注意到NavigationView的两个新自定义属性如下：

new attr     	 | Description	
:-------- 	     | :---				
app:headerLayout | 控制头部的布局
app:menu	     | 导航菜单的资源文件（也可以在运行时配置）

### CoordinatorLayout
手势,及滚动布局，MD的手势有很多组成部分，包括touch ripples和meaningful transitions。Design library引入了CoordinatorLayout，一个从另一层面去控制子view之间触摸事件的布局，Design library中的很多控件都利用了它。一个很好的例子就是当你将FloatingActionButton作为一个子View添加进 CoordinatorLayout并且将CoordinatorLayout传递给 Snackbar.make()，在3.0及其以上的设备上，Snackbar不会显示在悬浮按钮的上面，而是FloatingActionButton 利用CoordinatorLayout提供的回调方法，在Snackbar以动画效果进入的时候自动向上移动让出位置，并且在Snackbar动画地消失的时候回到原来的位置，不需要额外的代码。

CoordinatorLayout的另一个用例是ActionBar与滚动技巧。你可能已经在自己的布局中使用了Toolbar ，它允许你更加自由的自定义其外观与布局的其余部分融为一体。Design library把这种设计带到了更高的水平，使用AppBarLayout可以让你的Toolbar与其他View（比如TabLayout的选项卡）能响应被标记了ScrollingViewBehavior的View的滚动事件。

**注意项：**

当用户滚动RecyclerView，AppBarLayout可以这样响应滚动事件：

根据子view的滚动标志（scroll flag）来控制它们如何进入（滚入屏幕）与退出（滚出屏幕）。

**Flag包括：**

* scroll：所有想滚动出屏幕的View都需要设置这个flag，没有设置这个flag的View将被固定在屏幕顶部。
* enterAlways：这个flag让任意向下的滚动都会导致该View变为可见，启用快速“返回模式”。
* enterAlwaysCollapsed：当你的视图已经设置minHeight属性又使用此标志时，你的视图只能已最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
* exitUntilCollapsed：this flag causes the view to scroll off until it is ‘collapsed’ (its minHeight) before exiting。
> 特别注意：所有使用scroll flag的View都必须定义在没有使用scroll flag的View前面，这样才能确保所有的View从顶部退出，留下固定的元素。

PS一句：CoordinatorLayout还提供了layout_anchor和layout_anchorGravity属性一起配合使用，可以用于放置floating view，比如FloatingActionButton与其他View的相对位置。相见Demo中演示。
### AppBarLayout
这个没啥解释的，就是一个ViewGroup，配合ToolBar与CollapsingToolbarLayout等使用。就是一个纯容器类。
### CollapsingToolbarLayout
可伸缩折叠的Toolbar （Collapsing Toolbar），直接添加Toolbar到AppBarLayout可以让你使用enterAlwaysCollapsed和 exitUntilCollapsedscroll标志，但是无法控制不同元素如何响应collapsing的细节。这里使用了 CollapsingToolbarLayout的app:layout_collapseMode=”pin”来确保Toolbar在view折叠的时候仍然被固定在屏幕的顶部。还可以做到更好的效果，当你让CollapsingToolbarLayout和Toolbar在一起使用的时候，title 会在展开的时候自动变得大些，而在折叠的时候让字体过渡到默认值。必须注意，在这种情况下你必须在CollapsingToolbarLayout上调用 setTitle()，而不是在Toolbar上。除了固定住View，你还可以使用 app:layout_collapseMode=”parallax”（以及使用 app:layout_collapseParallaxMultiplier=”0.7”来设置视差因子）来实现视差滚动效果（比如 CollapsingToolbarLayout里面的一个ImageView），这中情况和CollapsingToolbarLayout的 app:contentScrim=”?attr/colorPrimary”属性一起配合更完美。

有一件事情必须注意，那就是CoordinatorLayout并不知道FloatingActionButton或者AppBarLayout的内部工作原理，它只是以Coordinator.Behavior的形式提供了额外的API，该API可以使子View更好的控制触摸事件与手势以及声明它们之间的依赖，并通过onDependentViewChanged()接收回调。

可以使用CoordinatorLayout.DefaultBehavior(你的View.Behavior.class)注解或者在布局中使用app:layout_behavior=”com.example.app.你的View$Behavior”属性来定义view的默认行为。 framework让任意View和CoordinatorLayout结合在一起成为了可能。

----------

## 2.Fragment

**参考：**

* Creating a Fragment<br>https://developer.android.com/training/basics/fragments/creating.html<br>

* Building a Dynamic UI with Fragments<br>https://developer.android.com/training/basics/fragments/fragment-ui.html<br>

* Android类参考---Fragment（一）<br>http://blog.csdn.net/think_soft/article/details/7619251<br>

* Android类参考---Fragment（二）<br>http://blog.csdn.net/think_soft/article/details/7621380<br>

* Android类参考---Fragment（三）<br>http://blog.csdn.net/think_soft/article/details/7623967<br>

* Android类参考---Fragment（四）<br>http://blog.csdn.net/think_soft/article/details/7625454<br>

### Add the fragment to the 'frame_content' FrameLayout
```java
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, new NewsFragment())
                .commit();
```

### viewPager.setOffscreenPageLimit
```java
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);
```

在空闲状态下，将视图层次结构中应保留的页面数量设置为当前页面的两侧。超出此限制的页面将在需要时从适配器重新创建。

这是作为优化提供的。如果您事先知道您需要支持的页面数量或者您的页面上已经安装了懒惰加载机制，则调整此设置可以有助于寻呼动画和交互的平滑度。如果您有少量页面（3-4），您可以一次性保持活动状态，则会在用户页面来回更新时间花费在新创建的视图子树的布局中。

您应该将此限制降低，特别是如果您的网页具有复杂的布局。此设置默认为1。
Set the number of pages that should be retained to either side of the current page in the view hierarchy in an idle state. Pages beyond this limit will be recreated from the adapter when needed.

This is offered as an optimization. If you know in advance the number of pages you will need to support or have lazy-loading mechanisms in place on your pages, tweaking this setting can have benefits in perceived smoothness of paging animations and interaction. If you have a small number of pages (3-4) that you can keep active all at once, less time will be spent in layout for newly created view subtrees as the user pages back and forth.

You should keep this limit low, especially if your pages have complex layouts. This setting defaults to 1.

### FragmentPagerAdapter与FragmentStatePagerAdapter
* Creating Swipe Views with Tabs<br>https://developer.android.com/training/implementing-navigation/lateral.html</br>
```java
public static class MyPagerAdapter extends FragmentPagerAdapter {
}

public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {
}
```
```java
MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());
```

FragmentPagerAdapter
This is best when navigating between sibling screens representing a fixed, small number of pages.
在同步屏幕之间进行导航，这表示固定的少量页面是最好的。

FragmentStatePagerAdapter
This is best for paging across a collection of objects for which the number of pages is undetermined. It destroys fragments as the user navigates to other pages, minimizing memory usage.
这最适合在不确定页数的对象集合之间进行分页。 当用户导航到其他页面时，它会破坏碎片，从而最大限度地减少内存使用。

### ViewPager与Fragment绑定
#### 创建Adapter
```java
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
```

* public Fragment getItem(int position)
	Get the data item associated with the specified position in the data set.
	获取与数据集中指定位置相关联的数据项。

* public int getCount() 
	Return the number of views available.
	返回可用视图数。

*  public CharSequence getPageTitle(int position)
	This method may be called by the ViewPager to obtain a title string to describe the specified page.
	ViewPager可以调用此方法来获取描述指定页面的标题字符串。

#### fragment的构造参数
```java
    public static NewsListFragment newInstance(int type) {
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }
```
* setArguments(Bundle args)
	Supply the construction arguments for this fragment.
	提供此fragment的构造参数。
* mType = getArguments().getInt("type");
	Return the arguments supplied to setArguments(Bundle), if any.
	返回提供给setArguments（Bundle）的参数（如果有）。

#### ViewPager与Fragment绑定
```java
    private void setupViewPager(ViewPager viewPager) {
        // Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_TOP), getString(R.string.top));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_NBA), getString(R.string.nba));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_CARS), getString(R.string.cars));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_JOKES), getString(R.string.jokes));
        viewPager.setAdapter(adapter);
    }
```

### TabLayout与ViewPager绑定
```java
tabLayout.setupWithViewPager(viewPager);
```

### Activity Lifecycle
https://developer.android.com/reference/android/app/Activity.html
![](https://developer.android.com/images/activity_lifecycle.png)

### Activity Lifecycle
https://developer.android.com/reference/android/app/Fragment.html#Lifecycle

The core series of lifecycle methods that are called to bring a fragment up to resumed state (interacting with the user) are:

1. onAttach(Activity) called once the fragment is associated with its activity.
2. onCreate(Bundle) called to do initial creation of the fragment.
3. onCreateView(LayoutInflater, ViewGroup, Bundle) creates and returns the view hierarchy associated with the fragment.
4. onActivityCreated(Bundle) tells the fragment that its activity has completed its own Activity.onCreate().
5. onViewStateRestored(Bundle) tells the fragment that all of the saved state of its view hierarchy has been restored.
6. onStart() makes the fragment visible to the user (based on its containing activity being started).
7. onResume() makes the fragment begin interacting with the user (based on its containing activity being resumed).

As a fragment is no longer being used, it goes through a reverse series of callbacks:

1. onPause() fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.
2. onStop() fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.
3. onDestroyView() allows the fragment to clean up resources associated with its View.
4. onDestroy() called to do final cleanup of the fragment's state.
5. onDetach() called immediately prior to the fragment no longer being associated with its activity.


----------

## 3.RecyclerView
https://developer.android.com/training/material/lists-cards.html

### RecyclerView.Adapter
```java
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private String[] mDataset;

    public NewsAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.info_text);
        }
    }
}
```
* public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	创建新视图（由布局管理器调用）
* public void onBindViewHolder(ViewHolder holder, int position) 
	替换视图的内容（由布局管理器调用）
* public int getItemCount() 
	返回适配器持有的数据集中的项目总数。

### RecyclerView.ViewHolder
* 提供对每个数据项的视图的引用

### RecyclerView.OnScrollListener
* 当在RecyclerView上发生滚动事件时，OnScrollListener可以添加到RecyclerView中以接收消息。
```java
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
    };
```
* public void onScrolled(RecyclerView recyclerView, int dx, int dy) 
	RecyclerView滚动后调用的回调方法。

* public void onScrollStateChanged(RecyclerView recyclerView, int newState)
	回收方法在RecyclerView的滚动状态更改时被调用。