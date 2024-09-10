package org.example.pathrequest.controller;

import org.example.pathrequest.model.Etudiant;
import org.example.pathrequest.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
public class EtudiantController {

    @Autowired
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @RequestMapping("/")
    public String home() {
        return "accueil";
    }

    @RequestMapping("/accueil")
    public String homePage() {
        return "accueil";
    }

    @RequestMapping("/inscription")
    public String inscriptionPage(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "pages/inscription";
    }

//    @PostMapping
//    public

    @PostMapping("/inscription")
    public String createEtudiant(@RequestParam("lastname") String lastname,
                                 @RequestParam("firstname") String firstname,
                                 @RequestParam("age") int age,
                                 @RequestParam("email") String email) {
        // Crée un nouvel étudiant à partir des données du formulaire
        etudiantService.createStudent(lastname, firstname, age, email);

        // Redirige vers la page qui affiche la liste des étudiants après l'inscription
        return "redirect:/liste";
    }


    @RequestMapping("/liste")
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllStudents());
        return "pages/liste";
    }

    @RequestMapping("/etudiant/{lastname}") // /search?contactName=Toto
    public String detailEtudiant(@PathVariable("lastname") String lastname, Model model) {
        Etudiant etudiant = etudiantService.findStudentByName(lastname);

        if (etudiant != null) {
            model.addAttribute("etudiant", etudiant);
            return "pages/detail";
        } else {
            return "pages/inscription";
        }
    }

    @GetMapping("/recherche")
    public String searchStudent(@RequestParam String lastname, Model model) {
        Etudiant etudiant = etudiantService.findStudentByName(lastname);
        model.addAttribute("etudiant", etudiant);
        return "pages/recherche";
    }
}
