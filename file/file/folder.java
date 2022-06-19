package file;

import java.util.ArrayList;

public class folder {
    String name;
    folder parent;
    ArrayList<folder> sub_folder;
    ArrayList<String> sub_file;
    String full_path;


    public folder(String name) {
        this.name = name;
        this.sub_folder = new ArrayList<folder>();
        this.sub_file = new ArrayList<String>();
    }
}
