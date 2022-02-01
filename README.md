<h2 align="center">Hi there! 👋</h2>
<p align="center">
  <b>Consumer-Producer Pattern</b>
</p>

<img align='right' src='https://media.giphy.com/media/bcKmIWkUMCjVm/giphy.gif' width='200"'>

:zap: It is an example of the application of the producer-consumer pattern applying concurrency concepts.

:zap: Within the project there are two running applications, in which the same pattern is applied but with two different techniques.
- The first one is to use the notify() and wait() methods to manage access to shared resources without generating inconsistencies.<br><br>
    Ubicado en: <em>src/com/producerconsumer/using_notify_wait/</em>
    
- The second one is to use resources that are synchronized from the definition. This means that they are thread safety and they can be used as a shared resource without the need to use the wait() and notify() methods. <br><br>
    Ubicado en: <em>src/com/producerconsumer/using_blocking_queue/</em>
