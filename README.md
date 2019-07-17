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
