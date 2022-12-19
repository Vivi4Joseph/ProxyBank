package org.formation.controller;

import org.formation.entity.Account;
import org.formation.entity.Operation;
import org.formation.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController {

	@Autowired
	private BanqueService banqueService;
	
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	@RequestMapping("/consultercompte")
	public String consulter(Model model, String codeCte , @RequestParam(defaultValue="0")int page,
														  @RequestParam(defaultValue="4")int size) {
		try {
			Account c=banqueService.consulterAccount(codeCte);
			Page<Operation>
		operations = banqueService.listOperation(codeCte, page, size);
			
		}catch (Exception e) {
			model.addAttribute("exception",e);
		}
		return "comptes";
	}
	@RequestMapping(value="/saveOperation",method= RequestMethod.POST)
	public String saveOperation(Model model , String codeCte,String codeCteDes, String typeOperation,double montant) {
		try {
			if(typeOperation.equals("Retrait"))
				banqueService.retirer(codeCteDes, montant);
			
			else if(typeOperation.equals("Versement"))
			banqueService.verser(codeCteDes, montant);
			
			else if(typeOperation.equals("Virement"));
			banqueService.virement(codeCte, codeCteDes, montant);
		}catch (Exception e) {
			model.addAttribute("error",e);
			return "redirect:/consultercompte?codeCte="+codeCte+"&error"+e.getMessage();
		}
		return "redirect:/consultercompte?codeCte="+codeCte;
	}
}
