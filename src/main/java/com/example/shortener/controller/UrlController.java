package com.example.shortener.controller;

import com.example.shortener.model.UrlModel;
import com.example.shortener.repositories.UrlRepository;
import com.example.shortener.services.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;

    private UrlService urlService;

    private UrlModel urlModel;

    private static final String orderByMostAccessed = "SELECT * FROM URL_MODEL ORDER BY VIEW DESC";

    @RequestMapping(value = "/shortNewUrl", method = RequestMethod.GET)
    public String form() {
        return "url/formUrl";
    }

    @RequestMapping(value = "/shortNewUrl", method = RequestMethod.POST)
    public String form(UrlModel url) {

        urlRepository.save(url);

        return "redirect:/shortNewUrl";
    }

    @RequestMapping("/encurtador")
    public ModelAndView listUrl() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<UrlModel> urls = urlRepository.findAll();
        mv.addObject("urlmodel", urls);
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView detailsUrl(@PathVariable("id") Long id) {
        UrlModel url = urlService.find(id);
        ModelAndView mv = new ModelAndView("url/detailsUrl");
        mv.addObject("urlmodel", url);
        System.out.printf("urlmodel", url);
        return mv;
    }


    @RequestMapping("/MostAccessed")
    public ModelAndView mostAccessed() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<UrlModel> urls = urlRepository.findAll();
        mv.addObject("urlmodel, url");
        return mv;
    }
}
