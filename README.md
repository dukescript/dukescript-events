# dukescript-events
Events for DukeScript

With this library you can add simple Java event handling to HTML Elements. A typical
use would be to combine it with our [Canvas API](https://dukescript.com/javadoc/canvas/).

You can add it to your project with Maven:

```xml
<dependency>
    <groupId>com.dukescript.events</groupId>
    <artifactId>events-api</artifactId>
    <version>0.3</version>
</dependency>
```


To do so simply create a new Canvas and add the following snippet:

```java
GraphicsContext2D ctx = GraphicsContext2D.getOrCreate("canvas");       

EventSource es = EventSource.create(ctx, "canvas");
es.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        GraphicsContext2D g2d = (GraphicsContext2D) event.getSource();
        g2d.setFillStyle(ctx.getWebColor("orange"));
        g2d.fillCircle((float) event.getX(), (float) event.getY(), 10);
    }
});


We made it fully pluggable, so it won't interfere with your own EventHandling if you 
have implemented your own. The library supports KeyEvents, TouchEvents and MouseEvents.
The library is available under the MIT-license and free to use in any project.
