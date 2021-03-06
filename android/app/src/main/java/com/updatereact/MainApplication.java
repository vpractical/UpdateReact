package com.updatereact;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.updatereact.communication.CommPackage;
import com.updatereact.constants.FileConstant;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class MainApplication extends Application implements ReactApplication {

  public static Context appContext;
  private static MainApplication instance;
  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    appContext = getApplicationContext();
    SoLoader.init(this, /* native exopackage */ false);
  }
  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }
//返回JS 的路径   super.getJSBundleFile();   asserts/index.bundle
//    替换这个返回值  bundle路径   patch文件

    @Nullable
    @Override
    protected String getJSBundleFile() {
      File file = new File (FileConstant.JS_BUNDLE_LOCAL_PATH);
      if(file != null && file.exists()) {
        return FileConstant.JS_BUNDLE_LOCAL_PATH;
      } else {
        return super.getJSBundleFile();
      }
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  /**
   *包名
   */
  public String getAppPackageName() {
    return this.getPackageName();
  }

  /**
   * 获取Application实例
   */
  public static MainApplication getInstance() {
    return instance;
  }





}
