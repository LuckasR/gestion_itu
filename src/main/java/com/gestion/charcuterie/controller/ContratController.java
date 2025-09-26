package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.Annonce;
import com.gestion.charcuterie.model.Candidature;
import com.gestion.charcuterie.model.Detail_candidature;
import com.gestion.charcuterie.model.Emploi_dt_entretient;
import com.gestion.charcuterie.model.Planing_entretient;
import com.gestion.charcuterie.model.Utilisateur;
import com.gestion.charcuterie.repository.Information_employeeRepository;
import com.gestion.charcuterie.service.AnnonceService;
import com.gestion.charcuterie.service.CandidatureService;
import com.gestion.charcuterie.service.Detail_candidatureService;
import com.gestion.charcuterie.service.Emploi_dt_entretientService;
import com.gestion.charcuterie.service.EmployeeService;
import com.gestion.charcuterie.service.GenreService;
import com.gestion.charcuterie.service.Niveau_etudeService;
import com.gestion.charcuterie.service.Planing_entretientService;
import com.gestion.charcuterie.service.RoleService;
import com.gestion.charcuterie.service.SocieteService;
import com.gestion.charcuterie.service.Status_traitementService;
import com.gestion.charcuterie.service.UtilisateurService;
import com.itextpdf.html2pdf.HtmlConverter;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ContratController {
    @Autowired
    private Detail_candidatureService service;

    @Autowired
    private CandidatureService candidatureService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private Status_traitementService status_traitementService;

    @Autowired
    private SocieteService societe;

    @Autowired
    private Information_employeeRepository repo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CandidatureService cs1;

    @Autowired
    private Emploi_dt_entretientService empx ;

    @Autowired
    private Planing_entretientService ps1 ; 

    @Autowired
    private Planing_entretientService pe ; 

    @Autowired
    private org.thymeleaf.TemplateEngine templateEngine;

@GetMapping("/contrat/pdf/{candidatId}")
public void genererContratPdf(@PathVariable Integer candidatId, HttpServletResponse response) throws Exception {
    // 1️⃣ Récupérer les données
    Candidature cx = cs1.getById(candidatId);
    Utilisateur ux = cx.getUtilisateur();
    Detail_candidature dc = cs1.getDetail(cx.getId());
    Annonce annonce = cx.getAnnonce();
    Planing_entretient pe1 = pe.getByCandidat(cx);
    Emploi_dt_entretient emploie = empx.getByPlaning(pe1).get(0);

    // 2️⃣ Préparer le contexte Thymeleaf
    Context context = new Context();
    context.setVariable("companyName", "Charucuterie");
    context.setVariable("siret", "034 25 235 33");
    context.setVariable("companyAddress", "Antanimena , Antananarivo");
    context.setVariable("nafCode", "6201Z");
    context.setVariable("employerRepresentative", "M. Jean DIRECTEUR");
    context.setVariable("employerTitle", "Directeur Général");
    context.setVariable("employeeName", ux.getUsername());
    context.setVariable("birthDate", dc.getDate_naissance().toString());
    context.setVariable("employeeAddress", dc.getAddress());
    context.setVariable("jobTitle", annonce.getTitle());
    context.setVariable("startDate", emploie.getDateEntretient().toString());
    context.setVariable("salary", annonce.getSalaire().toString());
    context.setVariable("workingHours", "35 heures");
    context.setVariable("jobDescription", annonce.getDescription());
    context.setVariable("probationPeriod", "3 mois");
    context.setVariable("workLocation", "Ivato, Laniera ambodifasina");
    context.setVariable("collectiveAgreement", "SYNTEC");
    context.setVariable("city", "Madagascar");
    context.setVariable("contractDate", "25 septembre 2024");

    // 3️⃣ Générer le HTML depuis le template
    String htmlContent = templateEngine.process("pdfContrat", context);

    // 4️⃣ Convertir en PDF avec Flying Saucer
    ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
    ITextRenderer renderer = new ITextRenderer();

    String baseUrl = new File("src/main/resources/templates/").toURI().toURL().toString();
    renderer.setDocumentFromString(htmlContent, baseUrl);
    renderer.layout();
    renderer.createPDF(pdfStream);

    // 5️⃣ Préparer la réponse HTTP
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "inline; filename=contrat_" + candidatId + ".pdf");
    response.setContentLength(pdfStream.size());

    // 6️⃣ Écrire le PDF dans la réponse
    try (OutputStream out = response.getOutputStream()) {
        pdfStream.writeTo(out);
        out.flush();
    }
}

}
