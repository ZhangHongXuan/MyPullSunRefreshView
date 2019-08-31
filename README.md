# MyPullToRefreshView
刷新 楼房背景 太阳旋转

gradle中引用：
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.okzhx:MyPullSunRefreshView:1.0.0'
	}
	
	maven中引用：
  
  Step 1. Add the JitPack repository to your build file



	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.okzhx</groupId>
	    <artifactId>MyPullSunRefreshView</artifactId>
	    <version>1.0.0</version>
	</dependency>
  
  布局文件：
          <com.zhx.pullsunrefreshview.PullSunRefreshView
            android:id="@+id/refresh_pull"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <android.support.v7.widget.RecyclerView
                android:id="@+id/recyclerview"
                android:layout_width="match_parent"
                android:layout_height="match_parent">

            </android.support.v7.widget.RecyclerView>

        </com.zhx.pullsunrefreshview.PullSunRefreshView>
        
	
	
  activity引用：
          //监听刷新事件
        mPullSunRefreshView.setOnRefreshListener(new PullSunRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullSunRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullSunRefreshView.setRefreshing(false);
                    }
                }, 1000);
            }
        });
  
  
  
  
  
