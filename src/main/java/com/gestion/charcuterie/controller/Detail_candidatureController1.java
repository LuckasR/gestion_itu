// package com.gestion.charcuterie.controller;

// import  com.gestion.charcuterie.model.*;
// import  com.gestion.charcuterie.service.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;


// @Controller
// @RequestMapping("/detail_candidature")
// public class Detail_candidatureController1 {

//     @Autowired
//     private Detail_candidatureService service;

//     @Autowired
//     private CandidatureService candidatureService;

//     @Autowired
//     private GenreService genreService;

//     @GetMapping
//     public String index(Model model) {
//         model.addAttribute("detail_candidatures", service.getAll());
//         return "detail_candidature/index";
//     }

//     @GetMapping("/create")
//     public String createForm(Model model) {
//         model.addAttribute("detail_candidature", new Detail_candidature());
//         model.addAttribute("candidatures", candidatureService.getAll());
//         model.addAttribute("genres", genreService.getAll());
//         return "detail_candidature/create";
//     }

//     @PostMapping("/save")
//     public String save(@ModelAttribute Detail_candidature obj) {
//         service.save(obj);
//         return "redirect:/detail_candidature";
//     }

//     @GetMapping("/edit/{id}")
//     public String edit(@PathVariable Integer id, Model model) {
//         model.addAttribute("detail_candidature", service.getById(id));
//         model.addAttribute("candidatureList", candidatureService.getAll());
//         model.addAttribute("genreList", genreService.getAll());
//         return "detail_candidature/edit";
//     }

//     @PostMapping("/update")
//     public String update(@ModelAttribute Detail_candidature obj) {
//         service.save(obj);
//         return "redirect:/detail_candidature";
//     }

//     @GetMapping("/delete/{id}")
//     public String delete(@PathVariable Integer id) {
//         service.delete(id);
//         return "redirect:/detail_candidature";
//     }}
