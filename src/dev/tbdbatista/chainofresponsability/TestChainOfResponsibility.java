package dev.tbdbatista.chainofresponsability;

import dev.tbdbatista.chainofresponsability.handler.DocumentFileHandler;
import dev.tbdbatista.chainofresponsability.handler.Handler;
import dev.tbdbatista.chainofresponsability.handler.ImageFileHandler;
import dev.tbdbatista.chainofresponsability.handler.TextFileHandler;
import dev.tbdbatista.chainofresponsability.model.File;

public class TestChainOfResponsibility {
    public static void main(String[] args) {
        File file = null;
        Handler textHandler = new TextFileHandler("'txt' handler ");
        Handler docHandler = new DocumentFileHandler("'doc' handler ");
        Handler jpgHandler = new ImageFileHandler("'jpg' handler ");
        textHandler.setHandler(docHandler);
        docHandler.setHandler(jpgHandler);

        file = new File("Abc", "mp3", "C:");
        textHandler.process(file);
        file = new File("Abc", "avi", "C:");
        textHandler.process(file);
        file = new File("Abc", "doc", "C:");
        textHandler.process(file);
        file = new File("Abc", "jpg", "C:");
        textHandler.process(file);
    }
}