package dev.tbdbatista.chainofresponsability.handler;

import dev.tbdbatista.chainofresponsability.model.File;

import java.util.logging.LogRecord;

public class TextFileHandler implements Handler {
    private Handler handler;
    private String handlerName;

    public TextFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if(file.getFileType().equals("txt")) {
            System.out.println("Process and saving text file: " + file.getFileName());
        } else if(handler != null){
            System.out.println(handlerName + "cannot process " + file.getFileType() + " extension. Forwarding  request to "
                    + handler.getHandlerName());
            handler.process(file);
        }else{
            System.out.println("File type not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return this.handlerName;
    }
}
