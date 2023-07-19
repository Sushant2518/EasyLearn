package com.masai.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtilis {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("easyLearn");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
