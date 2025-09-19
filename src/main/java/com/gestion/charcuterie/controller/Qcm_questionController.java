package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.service.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.text.StyledEditorKit.BoldAction;

@Controller
@RequestMapping("/qcm_question")
public class Qcm_questionController {

    @Autowired
    private Qcm_questionService service;

    @Autowired
    private DepartementService departementService;

    @Autowired
    private CandidatureService candidatService;

    @Autowired
    private SocieteService societeService;

    @Autowired
    private Qcm_testService testService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("qcm_questions", service.getAll());
        return "qcm_question/index";
    }

    @GetMapping("/{candidatId}")
    public String showRandomQuestion(@PathVariable int candidatId, Model model, HttpSession session) {

        // Récupérer le candidat et son département
        Candidature cand = candidatService.getById(candidatId);
        Boolean testCandidat = cand.getPassed_test();

        if (testCandidat != null && testCandidat == true) {
            model.addAttribute("error", "Vous avez déjà passé le test QCM.");
            List<Qcm_test> values = testService.getByCandidatureId( candidatId ) ;  
            Qcm_test test = values.get( 0 ) ; 
            model.addAttribute("score", test.getScore());
            return "qcm_reponse/qcmReponse";
        }

        Departement dept = cand.getAnnonce().getDepartement();

        if (session.getAttribute("nombreQuestion") == null) {
            int val = societeService.getById(1).getNombre_qcm_test();
            session.setAttribute("nombreQuestion", val);
            session.setAttribute("score", 0.0);
        }

        // Liste des IDs déjà posés dans la session
        List<Integer> sessionPosedIds = (List<Integer>) session.getAttribute("posedQuestions_" + dept.getId());
        final List<Integer> posedIds = (sessionPosedIds == null) ? new ArrayList<>() : new ArrayList<>(sessionPosedIds);

        // Récupérer toutes les questions du département
        List<Qcm_question> questions = service.getQuestionsByDepartement(dept.getId());
        if (questions.isEmpty()) {
            model.addAttribute("message", "Aucune question disponible pour ce département");
            return "qcm_reponse/qcm";
        }

        // Filtrer les questions déjà posées
        List<Qcm_question> remaining = questions.stream()
                .filter(q -> !posedIds.contains(q.getId()))
                .collect(Collectors.toList());

        // Si toutes les questions ont été posées, réinitialiser la liste
        if (remaining.isEmpty()) {
            posedIds.clear();
            remaining = new ArrayList<>(questions);
        }

        // Choisir une question aléatoire parmi celles restantes
        Random rand = new Random();
        Qcm_question question = remaining.get(rand.nextInt(remaining.size()));

        // Ajouter l'ID de la question posée à la session
        posedIds.add(question.getId());
        session.setAttribute("posedQuestions_" + dept.getId(), posedIds);

        // Récupérer les réponses pour cette question
        List<Qcm_reponse> reponses = service.getReponses(question.getId());

        model.addAttribute("question", question);
        model.addAttribute("reponse", reponses);
        model.addAttribute("candidatId", candidatId);

        return "qcm_reponse/qcm"; // --> templates/qcm/qcm.html
    }

    @PostMapping("/valider")
    public String validerReponses(@RequestParam int questionId, @RequestParam int candidatId,
            @RequestParam(name = "reponses", required = false) List<Integer> reponses,
            Model model, HttpSession session) {

        Candidature cand = candidatService.getById(candidatId);
        Boolean testCandidat = cand.getPassed_test();

        if (testCandidat != null && testCandidat == true) {
            model.addAttribute("error", "Vous avez déjà passé le test QCM.");
            List<Qcm_test> values = testService.getByCandidatureId( candidatId ) ;  
            Qcm_test test = values.get( 0 ) ; 
            model.addAttribute("score", test.getScore());
            return "qcm_reponse/qcmReponse";
        }

        double point = service.getPoint(questionId, 1, reponses);
        double score = (Double) session.getAttribute("score");
        double newScore = score + point;
        int nombreQuestion = (Integer) session.getAttribute("nombreQuestion");
        nombreQuestion = nombreQuestion - 1;
        System.out.println(nombreQuestion);
        if (nombreQuestion < 1) {
            model.addAttribute("score", newScore);
            Qcm_test ResultatTestCandidat = new Qcm_test();
            ResultatTestCandidat.setCandidature(cand);
            ResultatTestCandidat.setScore(BigDecimal.valueOf(newScore));
            ResultatTestCandidat.setDate_test(java.time.LocalDateTime.now());
            cand.setPassed_test(true);
            testService.save(ResultatTestCandidat);
            candidatService.save(cand);
            session.invalidate();
            return "qcm_reponse/qcmReponse";
        } else {
            session.setAttribute("nombreQuestion", nombreQuestion);
            session.setAttribute("score", newScore);

            return "redirect:/qcm_question/" + candidatId;
        }

    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("qcm_question", new Qcm_question());
        model.addAttribute("departements", departementService.getAll());
        return "qcm_question/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Qcm_question obj) {
        service.save(obj);
        return "redirect:/qcm_question";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("qcm_question", service.getById(id));
        model.addAttribute("departementList", departementService.getAll());
        return "qcm_question/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Qcm_question obj) {
        service.save(obj);
        return "redirect:/qcm_question";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/qcm_question";
    }
}
