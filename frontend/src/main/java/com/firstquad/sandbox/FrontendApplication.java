package com.firstquad.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@Controller
public class FrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @GetMapping("/table")
    public ModelAndView table(Model model) {
        ModelAndView mav = new ModelAndView();
        List<Replicat> list = new ArrayList<>();
        list.add(new Replicat("REPL1", "GGDIRECT", "HB", "", "0", "0"));
        list.add(new Replicat("REPL2", "GGDIRECT", "HB000", "", "0", "1"));
        list.add(new Replicat("REPL3", "GGDIRECT", "HB001", "", "0", "0"));
        mav.addObject("replicates", list);
        mav.addObject("dateVal", new SimpleDateFormat("YYYY:mm:dd hh:mm:ss").format(new Date()));
        return mav;
    }
}
