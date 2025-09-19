
package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.service.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// @RequestMapping("/")
public class MainController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/")
    public String MenuPrincipale(Model model) {
        return "main";
    }

    @GetMapping("/login")
    public String LoginForm(Model model) {
        return "login";
    }


    @PostMapping("/loginCheck")
public String loginCheck(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpSession session,
                         Model model) {

    Utilisateur user = utilisateurService.checking(username, password);
    Admin admin = adminService.checking(username, password);
    Employee emp = employeeService.checking(username, password);

    if (user != null) {
        // Stocker les informations dans la session
        session.setAttribute("user_id", user.getId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("role", "USER");

        return "redirect:/utilisateur";
    }

    if (emp != null) {
        session.setAttribute("user_id", emp.getId());
        session.setAttribute("username", emp.getUsername());
        session.setAttribute("role", "EMPLOYEE");
        session.setAttribute("departement_id", emp.getDepartement() != null ? emp.getDepartement().getId() : null);

        // Redirection selon le département
        if (emp.getDepartement() != null && emp.getDepartement().getId() == 1) {
            return "PageAdmin/RH/index";
        } else {
            return "redirect:/employee";
        }
    }

    if (admin != null) {
        session.setAttribute("user_id", admin.getId());
        session.setAttribute("username", admin.getUsername());
        session.setAttribute("role", "ADMIN");

        return "redirect:/admin";
    }

    // Login échoué
    model.addAttribute("error", "Nom d’utilisateur ou mot de passe incorrect");
    return "login";
}

    @GetMapping("/logout")
    public String logout(HttpSession session) {
      session.invalidate() ; 
      return "redirect:/login" ; 
    }


    // // Réception du formulaire
    // @PostMapping("/loginCheck")
    // public String loginCheck(@RequestParam("username") String username,
    //         @RequestParam("password") String password,
    //         Model model) {
    //     // Vérification dans la base
    //     Utilisateur user = utilisateurService.checking(username, password);
    //     Admin admin = adminService.checking(username, password);
    //     Employee emp = employeeService.checking(username, password);

    //     if (user != null) {
           
    //         return "redirect:/utilisateur";
    //     }
    //     if (emp != null) {
    //         // ✅ Login OK → redirection vers dashboard
    //         if(emp.getDepartement().getId() == 1){
    //             return "PageAdmin/RH/index" ; 
    //         }
    //         else{
                
    //         }
    //         return "redirect:/employee";
    //     }
    //     if (admin != null) {
    //         // ✅ Login OK → redirection vers dashboard
    //         return "redirect:/admin";
    //     } else {
    //         model.addAttribute("error", "Nom d’utilisateur ou mot de passe incorrect");
    //         return "login";
    //     }
    // }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Niveau_etude obj) {
    // service.save(obj);
    // return "redirect:/niveau_etude";
    // }

}
