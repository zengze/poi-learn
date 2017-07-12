package happy.module.home.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import happy.module.home.dao.Home;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String main(){
        return "redirect:/html-modules/home.html";
    }

    @RequestMapping(value = "/import", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Map<String, Object> importExcel(@RequestParam("data") String data) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("data", data);
        return model;
    }

    @RequestMapping(value = "/export", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        String year = request.getParameter("year");
        String data = request.getParameter("data");

        List<Home> excelList = JSON.parseObject(data, new TypeReference<List<Home>>() {});

        String path = session.getServletContext().getRealPath("/public/excel/test.xlsx");
        String fileName = "抚顺市水资源公报-" + year + "年抚顺市供水量.xlsx";

        InputStream instream = null;
        OutputStream outStream = null;

        try {
            instream = new FileInputStream(new File(path));

            response.setContentType("application/force-download");
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
            outStream = response.getOutputStream();

            // 从模板创建excel
            XSSFWorkbook wb = new XSSFWorkbook(instream);
            // 获取模板的第一个sheet
            XSSFSheet sheet = wb.getSheetAt(0);
            int index = 0; //行
            // 遍历数据
            for(Home home: excelList) {
                // 新建行
                XSSFRow row = sheet.createRow(++index);
                // 获取实体类的所有属性，返回Field数组
                Field[] field = home.getClass().getDeclaredFields();
                for (int i = 0; i < field.length; i++) {
                    // 新建列
                    XSSFCell cell = row.createCell(i);
                    // 获取属性的名字
                    String fieldName = field[i].getName();
                    // 取得getter方法名称
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    // 创建gettet方法
                    Method getMethod = home.getClass().getMethod(getMethodName);
                    // 调用getter方法获取属性值
                    Object value = getMethod.invoke(home);
                    //判断值的类型后进行强制类型转换
                    String textValue = null;
                    if(value != null) {
                        //其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                        //利用正则表达式判断textValue是否全部由数字组成
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if(matcher.matches()){
                            //是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }
                }
            }
            wb.write(outStream);
        } finally {
            instream.close();
            outStream.close();
        }
    }
}
