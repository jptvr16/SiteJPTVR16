/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Word;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pupil
 */
@Stateless
public class WordFacade extends AbstractFacade<Word> {

    @PersistenceContext(unitName = "WebSiteJPTVR16PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WordFacade() {
        super(Word.class);
    }

    public List<Word> findNoHidden() {
        try {
             return em.createQuery("SELECT w FROM Word w WHERE w.hidden=false")
                     .getResultList();
        } catch (Exception e) {
            return null;
        }
        
    }

    public List<Word> findHidden() {
          try {
             return em.createQuery("SELECT w FROM Word w WHERE w.hidden=true")
                     .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
