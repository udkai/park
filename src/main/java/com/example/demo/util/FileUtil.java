package com.example.demo.util;

import java.io.File;

/**
 * Created by liukai on 2018/7/25.
 */
public class FileUtil {
    public static boolean delFile(String path){
        File file=new File(path);
        if(!file.exists()){
            return false;
        }else{
            file.delete();
            return true;
        }
    }
    public static boolean delDir(String path){
        if(!path.endsWith(File.separator)){
            path+=File.separator;
        }
        File dirFile=new File(path);
        if(!dirFile.exists()||!dirFile.isDirectory()){
            return false;
        }
        boolean flag=true;
        File[]files=dirFile.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isFile()){
               flag= delFile(files[i].getAbsolutePath());
               if(!flag)break;
            }else{
                flag=delDir(files[i].getAbsolutePath());
                if(!flag)break;
            }
        }
        if(!flag)return false;
//        删除当前目录
        if(dirFile.delete()){
            return true;
        }else{
            return false;
        }
    }
}
