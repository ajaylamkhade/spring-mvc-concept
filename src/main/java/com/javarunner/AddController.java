package com.javarunner;

import com.javarunner.service.AddService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Function;

@Controller
public class AddController {

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public ModelAndView add ( @RequestParam("t1") int i,@RequestParam("t2") int j, HttpServletRequest request, HttpServletResponse response){

       Function<String,Integer> parameterFunctionalInterface = (String inputParam) -> Integer.parseInt(inputParam);

       //int i = parameterFunctionalInterface.apply(request.getParameter("t1"));
       //int j = parameterFunctionalInterface.apply(request.getParameter("t2"));

        AddService addService = new AddService();
         int k = addService.add(i,j);

       ModelAndView mv = new ModelAndView();
       mv.setViewName("display");
       mv.addObject("result",k);

        return mv;
    }
}
