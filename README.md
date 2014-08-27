Hopscotch
=========

A drop in replacement for Android's Path which implements Serializable and Parcelable.

Currently under development

Maven
-----

Use this for Gradle, substituting the most current version:
```
    compile 'com.myriadmobile.library:hopscotch:X.X.X'
```

How To Use
----------

Wherever you would normally use `Path`, just use `SerializablePath` instead. Feel free to pass it 
around in Intents or Bundles or write it out to disk. And when you actually need an instance of 
`Path`, call the `makePath()` method and it will build you one.

```java
public class FirstActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        SerializablePath path = new SerializablePath();
        
        Intent intent = new Intent(this, SecondActivity.class);
        //Since SerializablePath implements both Parcelable and Serializable, 
        //    we need to specify
        intent.putExtra("path", (Parcelable) path);
        startActivity(intent);
    }
}


public class SecondActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        SerializablePath path = getIntent().getParcelableExtra("path");
        Path realPath = path.makePath();
    }
}
```