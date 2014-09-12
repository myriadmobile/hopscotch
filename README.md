![Hopscotch](https://github.com/myriadmobile/hopscotch/raw/master/res/hopscotch_banner.png)

Introduction
-------

Features
-------
+ Implements Serializable
+ Implements Parcelable
+ Save Paths to storage for later

Usage
-------
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

Documentation
-------

Dependencies
-----
Hopscotch is on Maven Central! Simply add the following line into your build.gradle file. Remember to update the version number properly.
```
    compile 'com.myriadmobile.library:hopscotch:X.X.X'
```

Bugs and Feedback
-------
Have you found a bug? We'd sincerely appreciate an issue opened with as much detail as possible about the problem. Additionally, if you have a rad idea for a feature, tweak, or configurable aspect, create an issue! We'd love to hear from you. Fair warning: we may not agree the feature or tweak is a rad idea and close the issue, in which case you should maintain your own fork with your own changes.

Contributors
-------
### Lead
[dandc87](https://github.com/dandc87)

Would you like to contribute? Fork us and send a pull request! Be sure to checkout our issues first.

FAQ
-------
> Why Hopscotch?

The way Hopscotch works is basically recording every move that extends the path. Each step is discrete and iterable, much like a hopscotch court.


![Hopscotch](https://github.com/myriadmobile/hopscotch/raw/master/res/hopscotch.png)

License
-------

The MIT License (MIT)

Copyright (c) 2014 Myriad Mobile, www.myriadmobile.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
