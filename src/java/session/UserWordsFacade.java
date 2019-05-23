/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import entity.UserWords;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pupil
 */
@Stateless
public class UserWordsFacade extends AbstractFacade<UserWords> {

    @PersistenceContext(unitName = "WebSiteJPTVR16PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserWordsFacade() {
        super(UserWords.class);
    }
    public List<UserWords> findUserWords(User user) {
        try {
            return em.createQuery("SELECT uw FROM UserWords uw WHERE uw.user = :user")
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<UserWords> findNoHidden(User regUser) {
       try {
            return em.createQuery("SELECT uw FROM UserWords uw WHERE uw.user = :user AND uw.word.hidden=false AND uw.word.deleted=false")
                    .setParameter("user", regUser)
                    .getResultList();
        } catch (Exception e) {
            return null;
        } 
    }
    public List<UserWords> findHidden(User regUser) {
       try {
            return em.createQuery("SELECT uw FROM UserWords uw WHERE uw.user = :user AND uw.word.hidden=true AND uw.word.deleted=false")
                    .setParameter("user", regUser)
                    .getResultList();
        } catch (Exception e) {
            return null;
        } 
    }
}
