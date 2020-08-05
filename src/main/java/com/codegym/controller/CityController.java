package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.service.ICityService;
import com.codegym.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {
    @Autowired
   private INationService nationService;

    @Autowired
    private ICityService cityService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("cities",cityService.findAll());
        return "home";
    }

    @GetMapping(value = "/createcity")
    public String createCity(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("nations", nationService.findAll());
        return "create";
    }

    @PostMapping(value = "/createcity")
    public String postCreate(@ModelAttribute("city") City city, Model model) {
        if (city != null) {
//            System.out.println(city.getDes());
            cityService.save(city);
            model.addAttribute("message", "thêm thành công ");
        }
        return "create";
    }

    @GetMapping(value = "/edit/city/{id}")
    public String editCity(@PathVariable String id, Model model) {
        City city = cityService.findOne(Long.valueOf(id));
        if (city != null) {
            model.addAttribute("nations", nationService.findAll());
            model.addAttribute("city", city);
            return "edit";
        }
        model.addAttribute("city", new City());
        model.addAttribute("nations", nationService.findAll());
        model.addAttribute("message", "Khong sua duoc ");
        return "edit";
    }
//    public ModelAndView editCityForm(@PathVariable Long id){
//        City city = cityService.findOne(Long.valueOf(id));
//        if (city!=null){
//            ModelAndView modelAndView =new ModelAndView("edit");
//            modelAndView.addObject("city",city);
//            modelAndView.addObject("nations",nationService.findAll());
//            return modelAndView;
//        }else{
//            ModelAndView modelAndView =new ModelAndView("error-404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/edit/city")
//    public String editCity(@ModelAttribute("city") City city){
//        cityService.save(city);
////        ModelAndView modelAndView =new ModelAndView("edit");
////        modelAndView.addObject("city",city);
//        return "redirect:/";
//    }



    @GetMapping(value = "delete/city/{id}")
    public String deleteCity(@PathVariable String id, Model model){
        cityService.delete(Long.valueOf(id));
        return "delete";
    }

    @GetMapping(value = "view/city/{id}")
    public String viewCity(@PathVariable String id, Model model) {
        model.addAttribute("city", cityService.findOne(Long.valueOf(id)));
        return "view";
    }




}
