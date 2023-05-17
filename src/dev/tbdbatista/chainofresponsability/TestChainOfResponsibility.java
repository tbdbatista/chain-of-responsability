package dev.tbdbatista.chainofresponsability;

import dev.tbdbatista.chainofresponsability.handler.*;
import dev.tbdbatista.chainofresponsability.model.File;

public class TestChainOfResponsibility {
    public static void main(String[] args) {
        File file;
        Handler textHandler = new TextFileHandler("'txt' handler ");
        Handler docHandler = new DocumentFileHandler("'doc' handler ");
        Handler jpgHandler = new ImageFileHandler("'jpg' handler ");
        Handler mp3Handler = new AudioFileHandler("'mp3' handler ");
        Handler aviHandler = new VideoFileHandler("'avi' handler ");

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
    }
}