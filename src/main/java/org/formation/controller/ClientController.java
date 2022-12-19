package org.formation.controller;

import org.formation.entity.Account;
import org.formation.entity.Client;
import org.formation.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
	@Autowired
	ClientService clientService;
	 
	@RequestMapping(value="/clients")
	public String client() {
		return "formClients";
	}
	
	@RequestMapping(value="/consulterclients")
	public String consulter (Model model , Long codeClt,@RequestParam (defaultValue="0")int page,
														@RequestParam (defaultValue="4")int size) {
		try {
			Client c = clientService.consulterClient(codeClt);
			Page<Account> account = clientService.listeAccount(codeClt, page, size);
			model.addAttribute("codeClt",codeClt);
			model.addAttribute("client",c);
			model.addAttribute("pageCourant",page);
			model.addAttribute("account", account.getContent());
		}catch (Exception e) {
			model.addAttribute("exception",e);
		}
		return "formClients";
	}
	 
	
	
}
