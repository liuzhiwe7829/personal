import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author zhiwei.liu003
 * @date 2020/6/3010:06
 */
public class Test {
    private static final String inputPath = "D:\\quoteToproposal_log.txt";
    private static  final  String date = "20200622-20200629";

    static int i = 1;

    static void fetchClass(File inputFile) throws Exception {
        if (inputFile != null && inputFile.isDirectory()) {
            File[] hxcoreFiles = inputFile.listFiles();
            for (File singleFile : hxcoreFiles) {
                fetchClass(singleFile);
            }
        } else {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(inputFile), "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            String line = "";
            java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
            double total =0;
            //10秒内
            double lt10 = 0;
            //10-20秒内
            double lt20 = 0;
            //20以外
            double gt20=0;

            double dubboTotal =0;
            //10秒内
            double dubboLt10 = 0;
            //10-20秒内
            double dubboLt20 = 0;
            //20以外
            double dubboGt20=0;

            double esbTotal =0;
            //10秒内
            double esbLt10 = 0;
            //10-20秒内
            double esbLt20 = 0;
            //20以外
            double esbGt20=0;
            while((line=reader.readLine())!=null) {
                if(!line.contains("time：")) {
                    continue;
                }
                total++;
                int index = line.indexOf("time：");
                int time = Integer.valueOf(line.substring(index + "time：".length())).intValue();
                //dubbo
                if(line.indexOf("DubboServerHandler")>-1){

                    dubboTotal++;
                    if(time<=10){
                        dubboLt10++;
                    }else if (time>10&&time<=20){
                        dubboLt20++;
                    }else{
                        dubboGt20++;
//                        System.out.println(line);
                    }
                }
                //esb
                if(line.indexOf("XNIO")>-1){

                    esbTotal++;
                    if(time<=10){
                        esbLt10++;
                    }else if (time>10&&time<=20){
                        esbLt20++;
                    }else{
                        esbGt20++;
//                        System.out.println(line);
                    }
                }
                if(time<=10){
                    lt10++;
                }else if (time>10&&time<=20){
                    lt20++;
                }else{
                    gt20++;
//                    System.out.println(line);
                }
            }
            System.out.println(date+" 累计转投保调用"+total+"次");
            System.out.println("10s内:"+lt10+"次,占比"+df.format((lt10*100)/total)+"%");
            System.out.println("10s-20s内:"+lt20+"次,占比"+df.format((lt20*100)/total)+"%");
            System.out.println("超过20s:"+gt20+"次,占比"+df.format((gt20*100)/total)+"%");
            System.out.println("--------------------");
            System.out.println(date+" dubbo方式累计转投保调用"+dubboTotal+"次,占比"+df.format((dubboTotal*100)/total)+"%");
            System.out.println("10s内:"+dubboLt10+"次,占比"+df.format((dubboLt10*100)/dubboTotal)+"%");
            System.out.println("10s-20s内:"+dubboLt20+"次,占比"+df.format((dubboLt20*100)/dubboTotal)+"%");
            System.out.println("超过20s:"+dubboGt20+"次,占比"+df.format((dubboGt20*100)/dubboTotal)+"%");
            System.out.println("--------------------");
            System.out.println(date+" esb方式累计转投保调用"+esbTotal+"次,占比"+df.format((esbTotal*100)/total)+"%");
            System.out.println("10s内:"+esbLt10+"次,占比"+df.format((esbLt10*100)/esbTotal)+"%");
            System.out.println("10s-20s内:"+esbLt20+"次,占比"+df.format((esbLt20*100)/esbTotal)+"%");
            System.out.println("超过20s:"+esbGt20+"次,占比"+df.format((esbGt20*100)/esbTotal)+"%");
        }
    }



    public static void main(String[] args) {
        try {
            File copyFile = new File(inputPath);
            fetchClass(copyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
