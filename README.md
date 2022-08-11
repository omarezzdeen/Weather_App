 Android Arsenal Android Gems

Get it on Google Play Watch the demo video

WeatherView
WeatherView is an Android Library that helps you make a cool weather animation for your app.
This library is based on the confetti library.

 

Setup
Android Studio / Gradle
Add the following dependency in your root build.gradle at the end of repositories:

allprojects {
    repositories {
        //...
        maven { url = 'https://jitpack.io' }
    }
}
Add the dependency:

dependencies {
    implementation 'com.github.MatteoBattilana:WeatherView:3.0.0'
}
Simple usage
Simple use cases will look something like this:

Kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
	
	weather_view.setWeatherData(PrecipType.RAIN)
     }
 }
Java
public class Main2Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherView weatherView = findViewById(R.id.weather_view);
        weatherView.setWeatherData(PrecipType.RAIN);
    }
}
<com.github.matteobattilana.weather.WeatherView
    android:id="@+id/weather_view"
    android:layout_width="0dp"
    android:layout_height="0dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
For examples of usage, see the demo app.

Screenshots
  

License details
Copyright 2019 Matteo Battilana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
The library is Free Software, you can use it, extended with no requirement to open source your changes. You can also make paid apps using it.
