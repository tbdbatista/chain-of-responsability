# Chain of Responsibility Design Pattern Example

This project demonstrates the implementation of the Chain of Responsibility design pattern in Java. The Chain of Responsibility pattern allows a set of objects to handle a request in a hierarchical manner, where each object in the chain has the ability to either handle the request or pass it on to the next object in the chain.

## Project Description

The project consists of a `TestChainOfResponsibility` class that showcases the usage of the Chain of Responsibility pattern. In this example, we have different types of file handlers: `TextFileHandler`, `DocumentFileHandler`, `ImageFileHandler`, `AudioFileHandler`, and `VideoFileHandler`. Each handler is responsible for handling a specific type of file.

The `main` method demonstrates how the chain of handlers is set up and used to process different files. Here's a breakdown of the code:

```java
File file;
Handler textHandler = new TextFileHandler("'txt' handler");
Handler docHandler = new DocumentFileHandler("'doc' handler");
Handler jpgHandler = new ImageFileHandler("'jpg' handler");
Handler mp3Handler = new AudioFileHandler("'mp3' handler");
Handler aviHandler = new VideoFileHandler("'avi' handler");

textHandler.setHandler(docHandler);
docHandler.setHandler(jpgHandler);
jpgHandler.setHandler(aviHandler);
aviHandler.setHandler(mp3Handler);

file = new File("interview", "mp3");
textHandler.process(file);
file = new File("introduction", "avi");
textHandler.process(file);
file = new File("cover_letter", "pdf");
textHandler.process(file);
file = new File("resume", "doc");
textHandler.process(file);
file = new File("profile_picture", "jpg");
textHandler.process(file);
```

In this code, a chain of handlers is created starting with `textHandler` and followed by `docHandler`, `jpgHandler`, `aviHandler`, and finally `mp3Handler`. Each handler is responsible for handling a specific file type. The `setHandler` method is used to set the next handler in the chain.

The `process` method is called on the `textHandler` to process different files. Each file is represented by a `File` object with a name and an extension. The file is passed through the chain of handlers, and each handler checks if it can handle the file. If a handler can handle the file, it performs the required actions. Otherwise, it passes the file to the next handler in the chain.


## Conclusion

The Chain of Responsibility pattern provides an elegant way to decouple the sender of a request from its receiver, allowing multiple objects to have a chance to handle the request. It promotes flexibility and extensibility by dynamically assigning responsibilities at runtime. By using this pattern, you can achieve loose coupling and avoid hard dependencies between objects in your application.
