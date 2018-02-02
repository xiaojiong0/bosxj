package cn.xj.annotation.poi;

import cn.xj.annotation.poi.annotation.ExcelField;
import cn.xj.annotation.poi.util.Reflections;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class Export {
    private int a=10000;

    public Workbook exportExcel(List l,Class cls){
        Workbook wb=new XSSFWorkbook();

        LinkedList linkedList=new LinkedList();
        linkedList.addAll(l);
        boolean flag=true;
        while (linkedList.size()>0) {
            List list = new ArrayList();
            for (int i = 0; i < a; i++) {
                Object poll = linkedList.poll();
                if (poll == null) {
                    flag = false;
                    break;
                }
                if (flag)
                    list.add(poll);
            }

            this.createSheet(wb, list, cls);
        }
        return wb;
    }



 private String checkType(Object o){
      Class  valType=o.getClass();
     String s =null;
 if (valType == Date.class){
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
     s= sdf.format(o);
     return s;
 }
        return o.toString();
 }


 private Sheet createSheet(Workbook wb,List l,Class cls){
     Sheet sheet = wb.createSheet();
     List<Object[]> annotationList= new ArrayList<Object[]>();
     Field[] fs = cls.getDeclaredFields();
     for (Field f : fs){
         ExcelField ef = f.getAnnotation(ExcelField.class);
         if (ef != null && (ef.type()==0 || ef.type()==1)){
             annotationList.add(new Object[]{ef, f});
         }
     }
     // Field sorting 通过sort主键进行排序
     Collections.sort(annotationList, new Comparator<Object[]>() {
         public int compare(Object[] o1, Object[] o2) {
             return new Integer(((ExcelField)o1[0]).sort()).compareTo(
                     new Integer(((ExcelField)o2[0]).sort()));
         };
     });
     Row Headrow = sheet.createRow(0);
     //遍历元素注解集合生成第一行文字描述信息
     for (int i = 0; i <annotationList.size() ; i++) {
         ExcelField lef=(ExcelField)annotationList.get(i)[0];
         String title = lef.title();
         Headrow.createCell(i).setCellValue(title);
     }

     for (Object o : l) {
         Row row = sheet.createRow(sheet.getLastRowNum() + 1);
         for (int i = 0; i <annotationList.size() ; i++) {
             ExcelField lef=(ExcelField)annotationList.get(i)[0];
             Field field = (Field) annotationList.get(i)[1];
             if (lef.value()==""||"".equals(lef.value())){
                 String name = field.getName();
                 Object o1 = Reflections.invokeGetter(o, name);
                 row.createCell(i).setCellValue(checkType(o1));
             }else {
                 Object o1 = Reflections.invokeGetter(o, lef.value());
                 row.createCell(i).setCellValue(checkType(o1));
             }
         }

     }
    return  sheet;
 }


    public void setA(int a) {
        this.a = a;
    }
}



