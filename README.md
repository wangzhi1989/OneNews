# OneNews 简单的新闻客户端 #

2017/4/7 15:05:52 

## 1.Using the Design Support Library.
https://developer.android.com/training/material/design-library.html

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



















































