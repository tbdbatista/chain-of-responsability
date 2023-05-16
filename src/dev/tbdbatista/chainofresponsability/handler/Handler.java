package dev.tbdbatista.chainofresponsability.handler;

import dev.tbdbatista.chainofresponsability.model.File;

public interface Handler {
    public void setHandler(Handler handler);
    public void process(File file);
    public String getHandlerName();

}
