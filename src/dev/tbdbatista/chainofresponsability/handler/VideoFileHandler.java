package dev.tbdbatista.chainofresponsability.handler;

import dev.tbdbatista.chainofresponsability.model.File;

public class VideoFileHandler implements Handler {
    private Handler handler;
    private String handlerName;
    public VideoFileHandler(String handlerName){
        this.handlerName = handlerName;
    }
    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void process(File file) {
        if(file.getFileType().equals("mpg")){
            System.out.println("Process and saving video file: " + file.getFileName() + "." + file.getFileType());
        }else if(handler!=null){
            System.out.println(handlerName + "cannot process " + file.getFileType() + " extension. Forwarding  request to "
                    + handler.getHandlerName());
            handler.process(file);
        }else{
            System.out.println("Error uploading file. Type extension not supported");
        }
    }
    @Override
    public String getHandlerName() {
        return handlerName;
    }
}

