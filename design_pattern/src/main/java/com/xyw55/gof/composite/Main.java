package com.xyw55.gof.composite;

/**
 * Created by xiayiwei on 12/10/16.
 */
public class Main {
    public static void main(String[] args) {
        AbstractFile f2, f3, f4, f5, f6;
        Folder f1 = new Folder("/");
        f2 = new ImageFile("5.jpg");
        f3 = new TextFile("1.txt");
        f1.add(f2);
        f1.add(f3);

        f1.killVirus();
    }
}
