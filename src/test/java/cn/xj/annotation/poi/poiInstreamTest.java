package cn.xj.annotation.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class poiInstreamTest {



    public void  poiInstram() throws Exception{
        File file=new File("D:\\home\\idea\\bosXj\\src\\test\\java\\cn\\xj\\annotation\\poi\\lalala.xlsx");
        ImportExcel importExcel=new ImportExcel(file,0,0);
        List<User> dataList = importExcel.getDataList(User.class, null);
        System.out.println(dataList);
    }

    public void dateTest() {
        int year=2017;
        for (int i = 5; i < 13; i++) {
            Calendar cal = Calendar.getInstance();
            //设置年份
            cal.set(Calendar.YEAR,year);
            //设置月份
            cal.set(Calendar.MONTH, i-1);
            //获取某月最大天数
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            //设置日历中月份的最大天数
            cal.set(Calendar.DAY_OF_MONTH, lastDay);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String s = sdf.format(cal.getTime());
            System.out.println(cal.getTime());
        }


    }

    @Test
    public void poiExport() throws Exception {
        User u1=new User("张三1","女",new Date(),"1234");
        User u2=new User("张三2","女",new Date(),"1234");
        User u3=new User("张三3","女",new Date(),"1234");
        User u4=new User("张三4","女",new Date(),"1234");
        User u5=new User("张三5","女",new Date(),"1234");
        User u6=new User("张三6","女",new Date(),"1234");
        List l = new ArrayList<User>();
        l.add(u1);
        l.add(u2);
        l.add(u3);
        l.add(u4);
        l.add(u5);
        l.add(u6);
        //构建万条数据导出
        for (int i = 0; i <11 ; i++) {
            l.addAll(l);
        }
        System.out.println(l.size());
        Export export = new Export();
        Workbook workbook = export.exportExcel(l, User.class);
        OutputStream os = new FileOutputStream("C:\\write\\abc.xls");
        workbook.write(os);
        os.close();
    }

}
