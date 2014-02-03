/*    
 *     RecruitSystem - a distributed application to handle job applications.
 *     Copyright (C) 2014  Federico Klappenbach, Fredrik Johansson, Mikael Tenhunen
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *      along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.kth.ict.ffm.recruitsystem.controller;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ApplicationFacade {   
    @Inject
    private LanguageBean languageBean;

    @PersistenceContext
    EntityManager entityManager;

    public ApplicationFacade() {
    }

    public Collection<String> getCompetences() {
        String currentLanguage = languageBean.getCurrentLanguage();
        Query query = entityManager.createNamedQuery("Competencetranslation.findNameByLocale");
        query.setParameter("locale", currentLanguage);        
        return query.getResultList();
    }

    public void submitApplication(ApplicationDTO application) {
        Query query = entityManager.createQuery("INSERT INTO ");
    }
}
