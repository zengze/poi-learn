package happy.module.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
    public Map<String, Object> exportExcel(@RequestParam("data") String data) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("data", data);
        return model;
    }
}
