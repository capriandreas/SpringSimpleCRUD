package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Mahasiswa;
import com.example.demo.service.MahasiswaService;

public interface MahasiswaService {
	
	List<Mahasiswa> listMahasiswa();
	
	Mahasiswa updateOrSave(Mahasiswa mahasiswa);
	
	Mahasiswa getIdMahasiswa(Integer id);
	
	void deleteMahasiswa(Integer id);
	
}


