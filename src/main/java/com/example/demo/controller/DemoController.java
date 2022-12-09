package com.example.demo.controller;

import com.example.demo.model.Persona;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Metto nei getMapping gli url degli end point.
@RestController
public class DemoController {
    //associa il metodo get alla chiamata che specifichiamo
    @GetMapping("/prima-chiamata") //end point sotto specifico cosa deve tornarmi
    public String demo1() {
        return "ciao";
    }
    @GetMapping("/seconda-chiamata") //localhost:8083/seconda-chiamata?nome=PIPPO&cognome=ROSSI
    public String demo2(@RequestParam(required = false) String nome, @RequestParam String cognome){   // in base ai parametri che gli passo ritorna
        return "ciao "+ nome+" "+cognome;       //si legge l'url [request] che abbiamo messo nel browser sa che è riferito a questo metodo
        }                                           //@RequestParam dice il tipo di parametro che leggerna nell'URL
                                                    // passo un tipo parametro che richiedo
                                                    //Di default sono obbligatori i @RequestParam
    @GetMapping("/somma/{a}/{b}") //localhost:8083/somma/3/8
    public int demo3(@PathVariable int a, @PathVariable int b){
        return a+b;
    }

    @GetMapping("persona") //Lo slash si può o non può mettere
    public Persona getPersona(){

        Persona p = new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170); // me lo stampa in JSON nell'end-point

        return p;
    }

    @GetMapping("persone")
    public List<Persona> getPersone(){
        List<Persona> p= new ArrayList<>();
        Persona p1= new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170);
        Persona p2= new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170);

        p.add(p1); p.add(p2);
        return p;

    }

    @PostMapping("persona") //possono coesistere 2 con URI identiche e metodo diverso
    public List<Persona> addPersone(@RequestBody Persona persona){
        List<Persona> p= new ArrayList<>();
        Persona p1= new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170);
        Persona p2= new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170);
        //date di default sempre separate dal trattino e scritte al contrario anno mese giorno
        p.add(p1); p.add(p2);
        Persona p3= new Persona();
        p3.setNome(persona.getNome().toUpperCase());
        p3.setCognome(persona.getCognome().toUpperCase());
        p3.setDob(persona.getDob());
        p3.setHeight(persona.getHeight());
        p.add(p3);
        p.add(persona);
        return p;
        // aggiunto un commento di prova
        // aggiungo secondo commento di prova
    }

    @PatchMapping("persone")//localhost:8083/persone?incrementaAltezza=100.
    public List<Persona> patchPersone(@RequestParam int incrementaAltezza){
        List<Persona> p= new ArrayList<>();
        Persona p1= new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170);
        Persona p2= new Persona("Dante","Alighieri", LocalDate.of(1992,02,23),170);

        p.add(p1); p.add(p2);
        List <Persona> personeNew= new ArrayList<>();
        for (Persona pe: p) {
            pe.setHeight(pe.getHeight()+incrementaAltezza);
            personeNew.add(pe);


        }
        return p;

    }


        //Con @PathParam i valori vanno messi direttamente nella URL
        //CON @RequestParam vanno messi i parametri

    }/*
    @RequestMapping(method = RequestMethod.GET, value="/seconda chiamata", consumes = "text", produces = "text/html")
    public String demo2(){
        return "ciao 2";
    }    */

//post invia una risorsa al server ad esempio login
// nel caso della registrazione faccio una put perche salvo una risorsa sul server. Persisto sul file system un nuovo dato.
//metodo patch fa una modifica parziale [I programmatori non lo usano mai]

//La delete non si fa quasi mai perchè di solito si utilizzano i database relazionali.






