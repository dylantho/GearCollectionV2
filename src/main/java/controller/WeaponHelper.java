/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Weapon;

public class WeaponHelper {

	public WeaponHelper() {
	}
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GearCollection");
	
	public void insertWeapon(Weapon wep) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(wep);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Weapon> showAllWeapons(){
		EntityManager em = emfactory.createEntityManager();
		List<Weapon> allWeapons = em.createQuery("SELECT i FROM Weapon i").getResultList();
		return allWeapons;
	}
	
	public void deleteWeapon(Weapon toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Weapon> typedQuery = em.createQuery("select wep from Weapon wep where wep.name = :selectedName and wep.weaponType = :selectedweaponType", Weapon.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedweaponType", toDelete.getWeaponType());
		
		typedQuery.setMaxResults(1);
		

		Weapon result	= typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	
	public Weapon searchForWeaponById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Weapon found = em.find(Weapon.class, idToEdit);
		em.close();
		return	found;
	}


	public void updateWeapon(Weapon toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	
	public List<Weapon> searchForWeaponByWeaponName(String weaponName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Weapon> typedQuery = em.createQuery("select wep from Weapon wep where wep.name = :selectedName", Weapon.class);
		typedQuery.setParameter("selectedName", weaponName);
		List<Weapon> found = typedQuery.getResultList();
		em.close();

		return	found;
	}

	
	public List<Weapon> searchForWeaponByWeaponType(String weaponType) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Weapon> typedQuery	= em.createQuery("select wep from Weapon wep where wep.weaponType = :selectedweaponType", Weapon.class);
		typedQuery.setParameter("selectedweaponType",	weaponType);
		List<Weapon> found = typedQuery.getResultList();
		em.close();
		
		return found;

	}
	
	public void	cleanUp(){
		emfactory.close();
		}

}
