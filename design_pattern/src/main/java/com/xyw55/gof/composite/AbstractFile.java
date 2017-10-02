package com.xyw55.gof.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiayiwei on 12/10/16.
 */
public interface AbstractFile {
    void killVirus();
}

class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("image " + name + " kill");
    }
}


class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("text " + name + " kill");
    }
}


class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("video " + name + " kill");
    }
}

class Folder implements AbstractFile {
    private String name;
    // 定义容器存放leaf
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        super();
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("folder " + name + " kill");

        for (AbstractFile file : list) {
            file.killVirus();
        }
    }
}
