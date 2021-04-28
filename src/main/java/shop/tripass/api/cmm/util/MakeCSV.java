package shop.tripass.api.cmm.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class MakeCSV {
    public static long createCSV(List<reviewer> list, String title, String filepath) {
        long resultCount = 0;
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath + "/" + title + ".csv", true));
            for(reviewer dom:list) {bw.write(dom.getPceNum()+";"+dom.getRevStar()+";"+dom.getRevName()+";"+
                    dom.getRevContent()+";"+dom.getRevDate()+";");
                bw.newLine();}
            bw.flush();
            bw.close();
        }catch (Exception e) {
            e.printStackTrace();}
        return (long) resultCount;}}