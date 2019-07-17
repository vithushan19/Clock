# Clock
A simple app that shows multiple clocks

I failed an interview question last year where the interviewer asked me to code up an Android application and render an analog clock that updates with the current time. I completely bombed the question at the time, so I wanted to try implementing it again.

### Learning Goals
- Kotlin
- Android app architecture (ie. Jetpack)
- Drawing a custom view with attributes

### Important Classes
- __ClockView__ - A custom widget that can take the time in a Date object and render an analog clock
- __MainActivity__ - The View layer that contains multiple ClockView widgets and updates them whenever the ViewModel changes
- __ClockViewModel__ - The ViewModel layer that the View will listen to for updates. This gets the time from a Repository and allows the View layer (ie. MainActivity) to observe on it. This is currently a very simple class, but if we wanted to do additional view-related processing/transformations on the raw data from the repository, we would do so here
- __TimeRepository__ - The Repository layer that provides the current time to the ViewModel layer every second. This class abstracts away exactly how and where we get the data, so we could easily change data sources and wouldn't need to make changes to ViewModel or View. (ie. Currently we get the time from the java.util.Calendar class, but we could easily change this to use the Android OS SystemClock, or the JodaTime DateTime library

### Screenshot
![Screenshot](https://media.giphy.com/media/hV0hCET0wUJn5Q1Za0/200w_d.gif)

### Useful Examples/Articles that I used

- [An Android Jetpack ViewModel Tutorial](https://www.techotopia.com/index.php/An_Android_Jetpack_ViewModel_Tutorial)

- [Kotlin Syntax Reference](https://kotlinlang.org/docs/reference/basic-syntax.html)

- [Android Architecture Components by Example](https://proandroiddev.com/architecture-components-modelview-livedata-33d20bdcc4e9?gi=dfd695f819ef)

- [Applying Android Architecture Components with Kotlin](https://android.jlelse.eu/applying-android-architecture-components-with-kotlin-bfadb8399521?gi=4f2ae96bb35c)

- [Understanding LiveData made simple](https://medium.com/@elye.project/understanding-live-data-made-simple-a820fcd7b4d0)

- [Google Code Labs - LiveDataTimer Example](https://github.com/googlecodelabs/android-lifecycles/blob/master/app/src/main/java/com/example/android/lifecycles/step3_solution/LiveDataTimerViewModel.java)

- [Android Developer Docs - Custom Views](https://developer.android.com/training/custom-views/create-view)


