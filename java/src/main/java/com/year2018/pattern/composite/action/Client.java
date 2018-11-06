package com.year2018.pattern.composite.action;

/**
 * Author: zyh
 * Date: 2018/8/29 13:54
 */
public class Client {
    public static void main(String[] args){
        // 构造一个目录对象表示C盘目录
        Dir diskC = new Folder("C");

        // C盘根目录下有一个文件ImbaMallLog.txt"
        diskC.addDir(new File("ImbaMallLog.txt"));

        // C盘根目录下还有3个子目录有Windows、PerfLogs、Program File
        Dir dirWin = new Folder("Windows");

        // Windows目录下有文件Explorer.exe
        dirWin.addDir(new File("explorer.exe"));

        // PerfLogs目录
        Dir dirPer = new Folder("PerfLogs");

        //PerfLogs目录下有文件null.txt
        dirPer.addDir(new File("null.txt"));
        diskC.addDir(dirPer);

        // Program File目录
        Dir dirPro = new Folder("Program File");

        // Program File目录下有文件ftp.txt
        dirPro.addDir(new File("ftp.txt"));
        diskC.addDir(dirPro);

        //打印出文件结构
        diskC.print();
    }
}
