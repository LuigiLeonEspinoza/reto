package com.luigi.leon.reto.controller;

import com.luigi.leon.reto.model.Client;
import com.luigi.leon.reto.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final IClientService clientService;

    @PostMapping()
    public ResponseEntity saveClient(@RequestBody Client client){
        try {
            return new ResponseEntity(clientService.saveClient(client), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/status/{status}")
    public ResponseEntity getStatusClient(@PathVariable("status") String status){
        try {
            return new ResponseEntity(clientService.getAllClient(status), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getClient(@PathVariable("id") String id){
        try {
            return new ResponseEntity(clientService.getClient(id), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable("id") String id,@RequestBody Client client){
        try {
            return new ResponseEntity(clientService.updateClient(id,client), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") String id){

        try {
            boolean status = clientService.deleteClient(id);
            if (status){
                return new ResponseEntity(HttpStatus.OK);
            }
            else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
