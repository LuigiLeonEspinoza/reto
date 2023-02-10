package com.luigi.leon.reto.service;
import com.luigi.leon.reto.model.Client;
import com.luigi.leon.reto.model.dto.ClientDto;
import java.util.List;


public interface IClientService {

    ClientDto saveClient(Client client) throws  Exception;
    ClientDto getClient(String id) throws  Exception;
    List<Client> getAllClient(String status);
    ClientDto updateClient( String id, Client client) throws  Exception;

    boolean deleteClient(String id) throws  Exception;
}
