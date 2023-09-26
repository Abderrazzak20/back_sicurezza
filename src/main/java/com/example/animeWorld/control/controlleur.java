package com.example.animeWorld.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.animeWorld.entita.sicurezza;
import com.example.animeWorld.ripo.ripository;
import com.example.animeWorld.service.servo;

@RestController

@CrossOrigin("http://localhost:4200/")
public class controlleur {
    private ripository productsService;
    private servo servizio;
    private sicurezza sicuro;
    
    @Autowired // Aggiunto per l'iniezione di dipendenza
    public controlleur(ripository productsService) {
        this.productsService = productsService;
    }
    
   @GetMapping("/prodotti/")
   public List<sicurezza> getProdotti() {
	   return productsService.findAll();
   }
   
   @GetMapping("/prodotti/{id}")
   public Optional<sicurezza> getprodotto( @PathVariable Long id) {
	   return productsService.findById(id);   
   }
   
   @PostMapping("/login")
   public ResponseEntity<String> login(@RequestBody sicurezza credenziali){
	   if (servizio.verify(credenziali.getUser(), credenziali.getPassword())) {
		return new ResponseEntity<>("login riuscito",HttpStatus.OK);
	}else {
		return new ResponseEntity<>("login fallito",HttpStatus.UNAUTHORIZED);
	}
   }
   
   @PostMapping("/prodotti/")
   public sicurezza newProdotto(@RequestBody sicurezza body){   
	   return productsService.save(body);
   }
   
   @PutMapping("/enabled")
   public ResponseEntity<String> modificaStato(@RequestBody boolean enabled) {
       // Qui puoi aggiungere la logica per modificare lo stato
       // ad esempio, puoi salvare il nuovo stato nel tuo servizio

       // Esempio di come salvare lo stato in un servizio fittizio:
	   sicuro.setEnabled(enabled);

       return new ResponseEntity<>("Stato modificato con successo", HttpStatus.OK);
   }

   @PutMapping("/prodotti/{id}")
   	public Optional<sicurezza> aggiornaProdotto(@PathVariable Long id, @RequestBody sicurezza nuovoProdotto) {
   		return productsService.findById(id).map(prodotto -> {
        prodotto.setUser(nuovoProdotto.getUser());
        prodotto.setPassword(nuovoProdotto.getPassword());
        return productsService.save(prodotto);
    	});
	}  

	@DeleteMapping("/prodotti/{id}")
	public void deleteProdotto(@PathVariable Long id){
	 productsService.deleteById(id);
	}
}
    


