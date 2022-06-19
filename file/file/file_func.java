package file;

import java.util.HashMap;
import java.util.Objects;

public class file_func {
    static HashMap<String, folder> data = new HashMap<>();
    public static void md(String name, String parent) {
        folder f = new folder(name);
        f.name = name;
        data.put(name, f);

        if (parent != null) {
            for (String i : data.keySet()) {
                folder p = data.get(i);
                if (Objects.equals(p.name, parent)) {
                    f.parent = p;
                    p.sub_folder.add(f);
                    f.full_path = p.full_path+ '/' + f.name;
                }
            }

        } else {
            //setting root parent
            f.parent = null;
            f.full_path = ".";
        }
        //System.out.println(f.name+ " " +f.parent + " " + f.full_path);
    }

    public static void tree(String name) {
        folder f = data.get(name);
        for (int j = 0; j < f.sub_file.size(); j++) {
            System.out.println(f.sub_file.get(j));
        }
        for (folder i : f.sub_folder) {
            System.out.println("dir " +i.full_path);
        }
        for (folder z : f.sub_folder) {
            tree(z.name);
        }
    }

    public static void touch(String file_name, String curr) {
        folder f = data.get(curr);
        f.sub_file.add(file_name);
        System.out.println(file_name + " has been created at " + f.name);
    }

    public static void dir(String curr) {
        folder f = data.get(curr);
        for (int j = 0; j < f.sub_file.size(); j++) {
            System.out.println(f.sub_file.get(j));
        }
        for (folder i : f.sub_folder) {
            System.out.println("dir " +i.name);
        }
    }

    public static String cd(String name, String parent) {
        String temp = parent;
        if (Objects.equals(name, "..")) {
            folder par = data.get(parent);
            // To catch Null pointer while doing cd .. at root
            try {
                if (par.parent.name == null) {
                    System.out.println("Null pointer");
                    temp = parent;
                } else {
                    //setting current to parent name
                    temp = par.parent.name;
                }
            } catch (NullPointerException e) {
                System.out.println("Already at root !");;
            }

        } else if (Objects.equals(name, "./")) {
            //setting current to root
            temp = ".";
        }else {
            //getting current folder and parent folder and checking in sub folder
            folder f = data.get(parent);
            folder p = data.get(name);
            if (f.sub_folder.contains(p)) {
                //setting curent folder as parent name
                temp = p.name;
            } else {
                System.out.println("No Such directory ");
            }
        }
        return temp;
    }


    static String print_path(String name) {
        folder path = data.get(name);
        String s = path.full_path;
        return s;
    }

}
