package com.dongnao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PathchMain {
    public static void main(String[] args) {
/// 获取新旧Bundle文件
        String o = "/Users/tucheng/Desktop/apk/old.bundle";
        String n = "/Users/tucheng/Desktop/apk/new.bundle";

// 对比
        diff_match_patch dmp = new diff_match_patch();
        LinkedList<diff_match_patch.Diff> diffs = dmp.diff_main(o, n);

// 生成差异补丁包
        LinkedList<diff_match_patch.Patch> patches = dmp.patch_make(diffs);

// 解析补丁包
        String patchesStr = dmp.patch_toText(patches);

        try {
            // 将补丁文件写入到某个位置
            Files.write(Paths.get("/Users/tucheng/Desktop/apk/patches.pat"), patchesStr.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }



    }

}
