package fr.e.shop.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.e.shop.business.IAdminCategorieBusiness;
import fr.e.shop.entities.Categorie;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategorieController {

	@Autowired
	private IAdminCategorieBusiness business;
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", business.listeCategories());
		return "categorie";
	}
	
	@RequestMapping(value = "/saveCat")
	public String saveCat(@Valid Categorie c,BindingResult bindingResult, Model model, MultipartFile file) throws IOException {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", business.listeCategories());
			return ("categorie");
		}
		
		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		business.ajouterCategorie(c);
		
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", business.listeCategories());
		return "categorie";
	}
	
	@RequestMapping(value = "photoCat", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException {
		Categorie c = business.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	
}
