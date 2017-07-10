package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Mahasiswa;
import com.example.demo.service.MahasiswaService;

@Controller
public class MahasiswaController {
	
	private MahasiswaService mahasiswaService;
	
	@Autowired
	public void setMahasiswaService(MahasiswaService mahasiswaService){
		this.mahasiswaService = mahasiswaService;
	}

	@RequestMapping("/mahasiswa")
	public String MahasiswaList(Model model){
		model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa()); 
		return "mahasiswa";
	}
	
	@RequestMapping(value= "/mahasiswa/create", method= RequestMethod.GET)
	public String tampilkanForm(Model model){
		model.addAttribute("mahasiswa", new Mahasiswa());
		
		return "formMahasiswa";
	}
	
	@RequestMapping(value= "/mahasiswa/create", method= RequestMethod.POST)
	public String simpanData(Model model, Mahasiswa mahasiswa){
		model.addAttribute("mahasiswa", mahasiswaService.updateOrSave(mahasiswa));
		
		return "redirect:/mahasiswa";
	}
	
}
