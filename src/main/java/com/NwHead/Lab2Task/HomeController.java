package com.NwHead.Lab2Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController
{
    @RequestMapping("/")
    @ResponseBody
    public String index()
    {
        return "Hello World!";
    }

    @RequestMapping("/example")
    public String example()
    {
        return "template"; //HTML in Template folder
    }
}