package dev.gilder.tom.apple_sign_in;

import android.content.Context;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** AppleSignInPlugin */
public class AppleSignInPlugin implements FlutterPlugin, MethodCallHandler {

  private MethodChannel channel;
  private Context context;

  public AppleSignInPlugin {
    public static void main(String[] args) {
        
    }
  }

  public AppleSignInPlugin(Context context) {
    public static void main(String[] args) {
      this.context = context;  
    }
  }

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "apple_sign_in");
    context = flutterPluginBinding.getApplicationContext();
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    else {
      result.notImplemented();
    }
  }
  
  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
      channel.setMethodCallHandler(null);
  }
  // /** Plugin registration. */
  // public static void registerWith(Registrar registrar) {
  //   final MethodChannel channel = new MethodChannel(registrar.messenger(), "apple_sign_in");
  //   channel.setMethodCallHandler(new AppleSignInPlugin());
  // }

  // @Override
  // public void onMethodCall(MethodCall call, Result result) {
  //   if (call.method.equals("getPlatformVersion")) {
  //     result.success("Android " + android.os.Build.VERSION.RELEASE);
  //   } else {
  //     result.notImplemented();
  //   }
  // }
}
