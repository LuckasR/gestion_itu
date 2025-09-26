package com.gestion.charcuterie.service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.Planing_entretientRepository;

@Service
public class Planing_entretientServiceImpl implements Planing_entretientService {

    @Autowired
    private Planing_entretientRepository repo;

    @Autowired
    private Horaire_travailService horaire_travailService;

    @Autowired
    private Jour_ferieService jour_ferieService;

    @Autowired
    private Detail_horaireService detail_horaireService;

    @Autowired
    private Emploi_dt_entretientService empService;

    public List<Planing_entretient> getAll() {
        return repo.findAll();
    }

    public Planing_entretient getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Planing_entretient getByCandidat(Candidature candidat) {
        return repo.findByCandidature( candidat);
    }


    public void save(Planing_entretient obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

  

    // @Override
    // public void reserverTempsLibre(Planing_entretient planing, LocalDate date,
    // int dureeMinutes) {
    // int maxJoursRecherche = 30; // on cherche au maximum 30 jours à l'avance

    // for (int i = 0; i < maxJoursRecherche; i++) {
    // LocalDate currentDate = date.plusDays(i);

    // // Récupère l'horaire de travail du jour
    // DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
    // Horaire_travail horaire =
    // horaire_travailService.getByJour_semaine(dayOfWeek.name());

    // if (horaire == null) {
    // continue; // jour non travaillable
    // }

    // List<Detail_horaire> plagesTravail =
    // detail_horaireService.getByHoraire(horaire);
    // if (plagesTravail == null || plagesTravail.isEmpty()) {
    // continue; // aucune plage de travail ce jour
    // }

    // // Récupère les rendez-vous déjà enregistrés
    // List<Emploi_dt_entretient> rdvs = empService.getByDate(currentDate);
    // rdvs.sort(Comparator.comparing(Emploi_dt_entretient::getHeure_debut));

    // // Cas 1 : aucun RDV → prendre la première plage disponible
    // if (rdvs.isEmpty()) {
    // for (Detail_horaire plage : plagesTravail) {
    // if (Duration.between(plage.getHeure_debut(),
    // plage.getHeure_fin()).toMinutes() >= dureeMinutes) {
    // enregistrerRdv(planing, currentDate, plage.getHeure_debut(), dureeMinutes);
    // return;
    // }
    // }
    // }

    // // Cas 2 : chercher un trou entre RDV
    // for (Detail_horaire plage : plagesTravail) {
    // LocalTime libreDebut = plage.getHeure_debut();
    // LocalTime libreFin = plage.getHeure_fin();

    // for (Emploi_dt_entretient rdv : rdvs) {
    // LocalTime rdvDebut = rdv.getHeure_debut();
    // LocalTime rdvFin = rdv.getHeure_fin();

    // if (!rdvFin.isBefore(libreDebut) && !rdvDebut.isAfter(libreFin)) {
    // if (rdvDebut.isAfter(libreDebut)) {
    // if (Duration.between(libreDebut, rdvDebut).toMinutes() >= dureeMinutes) {
    // enregistrerRdv(planing, currentDate, libreDebut, dureeMinutes);
    // return;
    // }
    // }
    // libreDebut = rdvFin;
    // }
    // }

    // // après le dernier RDV
    // if (Duration.between(libreDebut, libreFin).toMinutes() >= dureeMinutes) {
    // enregistrerRdv(planing, currentDate, libreDebut, dureeMinutes);
    // return;
    // }
    // }
    // }

    // throw new RuntimeException("Aucun créneau disponible dans les " +
    // maxJoursRecherche + " jours à venir.");
    // }
    // public void reserverTempsLibre(Planing_entretient planing, LocalDate date,
    // int dureeMinutes) {
    // int maxJoursRecherche = 30; // on cherche au maximum 30 jours à l'avance

    // for (int i = 0; i < maxJoursRecherche; i++) {
    // LocalDate currentDate = date.plusDays(i);

    // // Récupère l'horaire de travail du jour
    // DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
    // Horaire_travail horaire =
    // horaire_travailService.getByJour_semaine(dayOfWeek.name());

    // if (horaire == null) {
    // continue; // jour non travaillable
    // }

    // List<Detail_horaire> plagesTravail =
    // detail_horaireService.getByHoraire(horaire);
    // if (plagesTravail == null || plagesTravail.isEmpty()) {
    // continue; // aucune plage de travail ce jour
    // }

    // // Récupère les rendez-vous déjà enregistrés
    // List<Emploi_dt_entretient> rdvs = empService.getByDate(currentDate);
    // rdvs.sort(Comparator.comparing(Emploi_dt_entretient::getHeure_debut));

    // // Cas 1 : aucun RDV → prendre la première plage disponible
    // if (rdvs.isEmpty()) {
    // for (Detail_horaire plage : plagesTravail) {
    // if (Duration.between(plage.getHeure_debut(),
    // plage.getHeure_fin()).toMinutes() >= dureeMinutes) {
    // enregistrerRdv(planing, currentDate, plage.getHeure_debut(), dureeMinutes);
    // return;
    // }
    // }
    // }

    // // Cas 2 : chercher un trou entre RDV
    // for (Detail_horaire plage : plagesTravail) {
    // LocalTime libreDebut = plage.getHeure_debut();
    // LocalTime libreFin = plage.getHeure_fin();

    // for (Emploi_dt_entretient rdv : rdvs) {
    // LocalTime rdvDebut = rdv.getHeure_debut();
    // LocalTime rdvFin = rdv.getHeure_fin();

    // if (!rdvFin.isBefore(libreDebut) && !rdvDebut.isAfter(libreFin)) {
    // if (rdvDebut.isAfter(libreDebut)) {
    // if (Duration.between(libreDebut, rdvDebut).toMinutes() >= dureeMinutes) {
    // enregistrerRdv(planing, currentDate, libreDebut, dureeMinutes);
    // return;
    // }
    // }
    // libreDebut = rdvFin;
    // }
    // }

    // // après le dernier RDV
    // if (Duration.between(libreDebut, libreFin).toMinutes() >= dureeMinutes) {
    // enregistrerRdv(planing, currentDate, libreDebut, dureeMinutes);
    // return;
    // }
    // }
    // }

    // throw new RuntimeException("Aucun créneau disponible dans les " +
    // maxJoursRecherche + " jours à venir.");
    // }

    private void enregistrerRdv(Planing_entretient planing, LocalDate date, LocalTime debut, int dureeMinutes) {
        Emploi_dt_entretient values = new Emploi_dt_entretient();
        values.setTache_title("Entretient de : " + planing.getCandidature().getUtilisateur().getUsername());
        values.setPlaningEntretient(planing);
        values.setDateEntretient(date);
        values.setHeure_debut(debut);
        values.setHeure_fin(debut.plusMinutes(dureeMinutes));
        empService.save(values);
    }

    public static boolean isBetween(LocalTime heure, LocalTime debut, LocalTime fin) {
        if (debut.isBefore(fin)) {
            // Cas normal : par exemple 09:00 → 17:00
            return !heure.isBefore(debut) && !heure.isAfter(fin);
        } else {
            // Cas spécial : intervalle qui traverse minuit (ex: 22:00 → 02:00)
            return !heure.isBefore(debut) || !heure.isAfter(fin);
        }
    }


public void reserverTempsLibre(Planing_entretient planing, LocalDate today, int dureeMinutes) {
    LocalDate dateCourante = today.plusDays(1); // commencer demain

    while (true) { // boucle infinie, mais on sort dès qu’on trouve un créneau
        DayOfWeek dayOfWeek = dateCourante.getDayOfWeek();

        Horaire_travail horaireTravail = horaire_travailService.getByJour_semaine(dayOfWeek.name());
        if (horaireTravail == null) {
            System.out.println("Jour non Travaillable : " + dayOfWeek.name());
            dateCourante = dateCourante.plusDays(1);
            continue; // on passe au jour suivant
        }

        List<Detail_horaire> val = detail_horaireService.getByHoraire(horaireTravail);
        if (val.size() < 2) {
            System.out.println("⚠️ Attention : il faut au moins 2 plages (matin/aprem) pour " + dateCourante);
            dateCourante = dateCourante.plusDays(1);
            continue;
        }

        Detail_horaire horaireMatinale = val.get(0);
        Detail_horaire horaireApremMidi = val.get(1);

        LocalTime heureDebutMatinale = horaireMatinale.getHeure_debut();
        LocalTime heureFinMatinale = horaireMatinale.getHeure_fin();
        LocalTime heureDebutAprem = horaireApremMidi.getHeure_debut();
        LocalTime heureFinAprem = horaireApremMidi.getHeure_fin();

        List<Emploi_dt_entretient> emplois = empService.getByDate(dateCourante);

        if (emplois.isEmpty()) {
            enregistrerRdv(planing, dateCourante, heureDebutMatinale, dureeMinutes);
            return; // ✅ trouvé
        }

        LocalTime debutBoucle = heureDebutMatinale;

        while (debutBoucle.isBefore(heureFinAprem)) {
            LocalTime limit = debutBoucle.plusMinutes(dureeMinutes);

            boolean chevauche = false;
            for (Emploi_dt_entretient emploi : emplois) {
                if (isBetween(debutBoucle, emploi.getHeure_debut(), emploi.getHeure_fin())
                    || isBetween(limit, emploi.getHeure_debut(), emploi.getHeure_fin())) {
                    chevauche = true;
                    break;
                }
            }

            if (!chevauche && (isInWorkingHours(debutBoucle, heureDebutMatinale, heureFinMatinale, heureDebutAprem, heureFinAprem)
                    && isInWorkingHours(limit, heureDebutMatinale, heureFinMatinale, heureDebutAprem, heureFinAprem))) {
                enregistrerRdv(planing, dateCourante, debutBoucle, dureeMinutes);
                return; // ✅ trouvé
            }

            debutBoucle = debutBoucle.plusMinutes(1);
        }

        // ⚠️ si on sort de la boucle → pas trouvé ce jour-là → tester le jour suivant
        System.out.println("⚠️ Aucun créneau dispo le " + dateCourante + ", on teste le jour suivant...");
        dateCourante = dateCourante.plusDays(1);
    }
}

private boolean isInWorkingHours(LocalTime time,
                                 LocalTime matinDebut, LocalTime matinFin,
                                 LocalTime apremDebut, LocalTime apremFin) {
    return (isBetween(time, matinDebut, matinFin) || isBetween(time, apremDebut, apremFin));
}



    // public void reserverTempsLibre(Planing_entretient planing, LocalDate today, int dureeMinutes) {

    //     LocalDate tomorrow = today.plusDays(1); // 1 jours plus tard

    //     // while (jour_ferieService.verifyJourFerie(tomorrow) == false) {
    //     // tomorrow = today.plusDays(1); // 1 jours plus tard
    //     // }

    //     DayOfWeek dayOfWeek = tomorrow.getDayOfWeek();
    //     if (horaire_travailService.getByJour_semaine(dayOfWeek.name()) != null) {
    //         Horaire_travail horaireAverier = horaire_travailService.getByJour_semaine(dayOfWeek.name());
    //         System.out.println(horaireAverier);
    //         List<Detail_horaire> val = detail_horaireService.getByHoraire(horaireAverier);
    //         // System.out.println(" Luckassss "+val);
    //         Detail_horaire horaireMatinale = val.get(0);
    //         Detail_horaire horaireApremMidi = val.get(1);

    //         LocalTime heureDebutMatinale = horaireMatinale.getHeure_debut();
    //         LocalTime heureFinMatinale = horaireMatinale.getHeure_fin();
    //         LocalTime heureDebutAprem = horaireApremMidi.getHeure_debut();
    //         LocalTime heureFinAprem = horaireApremMidi.getHeure_fin();

    //         List<Emploi_dt_entretient> emploieDuTempsMisePlace = empService.getByDate(tomorrow);
    //         if (emploieDuTempsMisePlace.isEmpty()) {
    //             enregistrerRdv(planing, tomorrow, heureDebutMatinale, dureeMinutes);
    //             // Removed invalid return statement for void method
    //         } else {
    //             LocalTime debutBoucle = heureDebutMatinale;
    //             boolean valx = true;

    //             while (valx == true) {
    //                 LocalTime limit = debutBoucle.plusMinutes(dureeMinutes);
    //                 for (Emploi_dt_entretient emploi_dt : emploieDuTempsMisePlace) {
    //                     if ((isBetween(debutBoucle, emploi_dt.getHeure_debut(), emploi_dt.getHeure_fin()) == false)
    //                             && (isBetween(limit, emploi_dt.getHeure_debut(), emploi_dt.getHeure_fin()) == false)
    //                             && (isBetween(debutBoucle, heureDebutMatinale, heureFinMatinale)
    //                                     || isBetween(debutBoucle, heureDebutAprem, heureFinAprem))
    //                             && (isBetween(limit, heureDebutMatinale, heureFinMatinale)
    //                                     || isBetween(limit, heureDebutAprem, heureFinAprem))) {

    //                         enregistrerRdv(planing, tomorrow, debutBoucle, dureeMinutes);
    //                         valx = false;
    //                     } else {
    //                         debutBoucle = debutBoucle.plusMinutes(1); // ⚠️ n’oublie pas de réassigner !
    //                     }
    //                 }
    //             }

    //         }

    //     } else {
    //         System.out.println("Jour non Travaillable : " + dayOfWeek.name());
    //     }

    // }
}