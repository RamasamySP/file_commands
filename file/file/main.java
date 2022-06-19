package file;

import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static String curr = "";
    public static void main(String[] args) {
        //creating root directory
        file_func.md(".", null);

        //setting current to root
        curr = ".";
        //boolean loop is set to true inorder to exit when command is x
        boolean loop = true;
        while (loop) {
            //printing current folder path
            System.out.print(file_func.print_path(curr) + ">");
            //getting command
            String command = sc.next();
            switch (command) {
                case "tree" :
                    file_func.tree(".");
                    break;
                case "cd":
                    //getting folder name to do cd
                    String dir = sc.next();
                    curr = file_func.cd(dir, curr);
                    break;
                case "md":
                    //getting folder name to do md
                    String md_dir = sc.next();
                    file_func.md(md_dir, curr);
                    System.out.println(md_dir + " created successfully !");
                    break;

                case "touch" :
                    //getting file name
                    String file_name = sc.next();
                    file_func.touch(file_name, curr);
                    break;

                case "dir" :
                    file_func.dir(curr);
                    break;

                case "pwd":
                    System.out.println(file_func.print_path(curr));
                    break;
                case "x" :
                    loop = false;
                default:
                    continue;
            }
        }
    }
}
