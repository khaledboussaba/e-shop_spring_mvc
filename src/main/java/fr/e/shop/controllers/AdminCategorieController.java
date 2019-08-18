package fr.e.shop.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import fr.e.shop.business.IAdminCategorieBusiness;
import fr.e.shop.entities.Categorie;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategorieController implements HandlerExceptionResolver {

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
		
		if (c.getIdCategorie() != null) {
			if (file.isEmpty()) {
				Categorie cat = business.getCategorie(c.getIdCategorie());
				c.setPhoto(cat.getPhoto());
			}
			business.modifierCategorie(c);
		} else {		
			business.ajouterCategorie(c);
		}
		
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
	
	@RequestMapping(value = "/suppCat")
	public String supp(Long idCat, Model model) {
		business.supprimerCategorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", business.listeCategories());
		return "categorie";
	}
	
	@RequestMapping(value = "/editCat")
	public String edit(Long idCat, Model model) {
		Categorie c = business.getCategorie(idCat);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", business.listeCategories());
		return "categorie";
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorie", new Categorie());
		mv.addObject("categories", business.listeCategories());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categorie");
		return mv;
	}
	
}
