package design.patterns.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        FileSystem fileSystem1 = new File("file1");
        FileSystem fileSystem2 = new File("file2");
        Folder folder = new Folder("folder1");
        folder.add(fileSystem2);
        Folder folder2 = new Folder("folder2");
        folder2.add(fileSystem1);
        Folder folder3 = new Folder("folder3");
        folder3.add(folder);
        folder3.add(folder2);
        folder3.showDetails();
    }
}

interface FileSystem {
    void showDetails();
}

class File implements FileSystem {
    String name;

    File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File name: " + name);
    }
}

class Folder implements FileSystem {

    String name;
    List<FileSystem> fileSystems = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder name:" + name);
        for (FileSystem file : fileSystems) {
            System.out.print("->");
            file.showDetails();
        }
    }
}
