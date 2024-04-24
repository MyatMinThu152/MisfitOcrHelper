# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.ac
-renamesourcefileattribute SourceFile

-keepattributes *Annotation*, Signature, Exception


# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# models
-keep class com.misfit.orc.models.** { *; }
-keep class com.misfit.orc.network.base.** { *; }
-keep class com.misfit.orc.network.requests.** { *; }
-keep class com.misfit.orc.network.responses.** { *; }
-keep class com.misfit.orc.network.responseJsonPraser.** { *; }

# Retofit
-keep class com.squareup.** { *; }
-keep interface com.squareup.** { *; }
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *;}
-keep interface com.squareup.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

-keep class androidx.core.app.NotificationCompat { *; }
-keep class android.support.v4.app.NotificationCompat$* { *; }
-keep class androidx.core.app.NotificationManagerCompat { *; }

-keep class io.invertase.firebase.** { *; }
-keep class io.invertase.firebase.messaging.** { *; }
-keep class com.google.firebase.** { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.** { *; }

# eventBus
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
 }
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

## week view calendar
## https://square.github.io/otto/ ##
-keepclassmembers class ** {
    @com.squareup.otto.Subscribe public *;
    @com.squareup.otto.Produce public *;
}
