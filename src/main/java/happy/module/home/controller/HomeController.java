package happy.module.home.controller;

import happy.module.home.dao.Home;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String main(){
        return "redirect:/html-modules/home.html";
    }

    @RequestMapping(value = "/import", method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> importExcel(@RequestParam("data") String data) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("data", data);
        return model;
    }

    @RequestMapping(value = "/export", method= RequestMethod.GET)
    @ResponseBody
    public void exportExcel(HttpServletResponse response, HttpSession session) throws IOException {

        List<Home> list = new ArrayList<Home>();
        Home home;

        home = new Home();
        home.setName("胡彦斌");
        home.setAge(32);
        home.setAddress("西湖区湖底公园1号");
        list.add(home);

        home = new Home();
        home.setName("吴彦祖");
        home.setAge(43);
        home.setAddress("西湖区湖底公园2号");
        list.add(home);

        String path = session.getServletContext().getRealPath("/public/excel/test.xlsx");
        String fileName = "测试.xlsx";

        InputStream instream = null;
        OutputStream outStream = null;

        try {
            instream = new FileInputStream(new File(path));
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
            outStream = response.getOutputStream();

            XSSFWorkbook wb = new XSSFWorkbook(instream);
            XSSFSheet sheet = wb.getSheetAt(0);
            int index = 0;
            for(Home h: list) {
                XSSFRow row = sheet.createRow(++index);
                for(int i = 0; i < 3; i++) {
                    row.createCell(i);
                }
                row.getCell(0).setCellValue(h.getName());
                row.getCell(1).setCellValue(h.getAge());
                row.getCell(2).setCellValue(h.getAddress());
            }
            wb.write(outStream);
        } finally {
            instream.close();
            outStream.close();
        }
    }
}
