package com.bird.bird_project.controller;

import com.bird.bird_project.dto.BirdDto;
import com.bird.bird_project.services.BirdService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class BirdController {
    int priceForKg=0;
    @Autowired
    private BirdService birdService;

    @GetMapping("/bird")
    public String main(Model model){
        model.addAttribute("price",priceForKg);
        model.addAttribute("birdList",birdService.getAllBirds());
        return "index";
    }

    @RequestMapping("/add")
    public String addBird(@ModelAttribute("bird") BirdDto birdDto,
                          @RequestParam("health") String health) {
        birdService.addBirdInDB(birdDto,health);
        return "redirect:/bird";
    }
    @GetMapping("/setPriceForKg")
    public String setPriceForKg(@RequestParam("price")int price){
        priceForKg=price;
        birdService.getPriceForKg(price);
        return "redirect:/bird";
    }
    @GetMapping("/set")
    public String redirect(){
        return "getPriceForKg";
    }
}