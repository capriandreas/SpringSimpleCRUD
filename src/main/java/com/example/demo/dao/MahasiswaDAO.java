package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mahasiswa;
import com.example.demo.service.MahasiswaService;

@Service
public class MahasiswaDAO implements MahasiswaService{
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public List<Mahasiswa> listMahasiswa() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
		
	}

	@Override
	public Mahasiswa updateOrSave(Mahasiswa mahasiswa) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Mahasiswa saved = em.merge(mahasiswa);
		
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Mahasiswa getIdMahasiswa(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Mahasiswa.class, id);
		
	}

}
