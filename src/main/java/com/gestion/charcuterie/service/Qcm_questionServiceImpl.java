package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qcm_questionServiceImpl implements Qcm_questionService {

    @Autowired
    private Qcm_questionRepository questionRepo;

    @Autowired
    private Qcm_reponseRepository reponseRepo;

    public List<Qcm_question> getAll() {
        return questionRepo.findAll();
    }

    public Qcm_question getById(Integer id) {
        return questionRepo.findById(id).orElse(null);
    }

    public void save(Qcm_question obj) {
        questionRepo.save(obj);
    }

    public void delete(Integer id) {
        questionRepo.deleteById(id);
    }

    // Récupère une question aléatoire d’un département
    public Qcm_question getRandomQuestionByDepartement(int departementId) {
        List<Qcm_question> questions = questionRepo.findByDepartementId(departementId);
        if (questions.isEmpty())
            return null;
        Random rand = new Random();
        return questions.get(rand.nextInt(questions.size()));
    }

    // Récupère réponses d’une question
    public List<Qcm_reponse> getReponses(int questionId) {
        return reponseRepo.findByQuestion_Id(questionId);
    }


    // Récupère toutes les questions d’un département
    public List<Qcm_question> getQuestionsByDepartement(int departementId) {
        return questionRepo.findByDepartementId(departementId);
    }

    // Nombre de points obtenus pour une question
    public double getPoint(int questionId, int nbrPoints, List<Integer> reponsesId) {
        List<Qcm_reponse> rep = reponseRepo.findByQuestion_Id(questionId);
        double SumMarina = 0;
        double NbrMarinaUser = 0;

        for (Qcm_reponse qcm_reponse : rep) {
            if (qcm_reponse.getStatus()) {
                SumMarina++; // sum Marina
            }
        }

        for (Integer repId : reponsesId) {
            Qcm_reponse r = reponseRepo.findById(repId).orElse(null);
            if (r.getStatus()) {
                NbrMarinaUser++;
            }
        }

        return nbrPoints * NbrMarinaUser / SumMarina;
    }

}