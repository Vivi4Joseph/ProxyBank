package org.formation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestTransactionController {

}
