package com.reactnativemultithreading;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class MultithreadingModule extends ReactContextBaseJavaModule {
  static {
    System.loadLibrary("cpp");
  }

  private native void nativeInstallMultithreading(long jsiPtr);

  public MultithreadingModule(ReactApplicationContext context) {
    super(context);
  }

  @NonNull
  @Override
  public String getName() {
    return "RNMultithreading";
  }

  @Override
  public void initialize() {
    super.initialize();

    nativeInstallMultithreading(
      this.getReactApplicationContext().getJavaScriptContextHolder().get()
    );
  }
}