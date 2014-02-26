/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.ict.ffm.recruitsystem.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import se.kth.ict.ffm.recruitsystem.model.entity.Application;
import se.kth.ict.ffm.recruitsystem.model.entity.Competence;
import se.kth.ict.ffm.recruitsystem.model.entity.Competenceinapplication;
import se.kth.ict.ffm.recruitsystem.model.entity.CompetenceinapplicationPK;
import se.kth.ict.ffm.recruitsystem.model.entity.CompetencetranslationDTO;

import se.kth.ict.ffm.recruitsystem.util.dto.ApplicationDTO;
import se.kth.ict.ffm.recruitsystem.util.dto.CompetenceFromView;

@Stateless
public class CompetenceOperator {
    @PersistenceContext(unitName = "se.kth.ict.ffm_RecruitSystem_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;
    
    public List<CompetencetranslationDTO> getCompetences(String currentLanguage) {
        Query query = entityManager.createNamedQuery("Competencetranslation.findByLocale");
        query.setParameter("locale", currentLanguage);
        return query.getResultList();
    }
    
    public CompetencetranslationDTO getCompetenceTranslation(String name, 
            String currentLanguage) {
        Query query = entityManager.createNamedQuery("Competencetranslation.findByLocaleAndName");
        query.setParameter("locale", currentLanguage);
        query.setParameter("name", name);
        return (CompetencetranslationDTO) query.getSingleResult();
    }    

    public void createAndAddCompetences(ApplicationDTO application, Application applicationEntity) {
        List<CompetenceFromView> comps = application.getCompetences();
        CompetenceFromView comp;
        Collection<Competenceinapplication> competenceinapplicationCollection
                = applicationEntity.getCompetenceinapplicationCollection();
        Competenceinapplication competenceEntity;
        Competence competence;
        CompetenceinapplicationPK pk;
        //Iterate through all the competences in ApplicationDTO
        for (Iterator<CompetenceFromView> iterator = comps.iterator();
                iterator.hasNext();) {
            comp = iterator.next();
            //create the Competenceinapplication entity
            competenceEntity = new Competenceinapplication();
            competenceEntity.setYearsofexperience(comp.getYearsOfExperience());
            competence = entityManager.find(Competence.class, comp.getCompetenceId());
//            pk = new CompetenceinapplicationPK();
//            pk.setCompetenceid(competence.getCompetenceid());
            //NOT SETTING APPLICATION ID IN PK NOW!!
//            competenceEntity.setCompetenceinapplicationPK(pk);
            competenceEntity.setCompetence(competence);
            //add application to Competenceinapplication
            competenceEntity.setApplication(applicationEntity);
            //add Competenceinapplication to application
            competenceinapplicationCollection.add(competenceEntity);
        }
    }

}