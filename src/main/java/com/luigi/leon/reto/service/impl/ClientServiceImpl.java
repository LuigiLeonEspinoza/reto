package com.luigi.leon.reto.service.impl;

import com.luigi.leon.reto.model.Client;
import com.luigi.leon.reto.model.dto.ClientDto;
import com.luigi.leon.reto.repositories.IClientRepository;
import com.luigi.leon.reto.service.IClientService;
import com.luigi.leon.reto.service.util.Encrypt;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    private final IClientRepository clientRepository;

    @Override
    public ClientDto saveClient(Client client)  {
        logger.debug("saveClient ClientServiceImpl");
        Client clientTemp = clientRepository.save(client);
        String encryptData = Encrypt.encrypt(clientTemp.getId().toString());
        ClientDto clientDto = new ClientDto();
        clientDto.setId(encryptData);
        clientDto.setName(clientTemp.getName());
        clientDto.setLastName(clientTemp.getLastName());
        clientDto.setTypeDocument(clientTemp.getTypeDocument());
        clientDto.setNumberDocument(clientTemp.getNumberDocument());
        clientDto.setStatus(clientTemp.getStatus());
        return clientDto;
    }

    @Override
    public ClientDto getClient(String id) throws Exception {
        logger.debug("getClient ClientServiceImpl");
        UUID decodeData =  UUID.fromString(Encrypt.decrypt(id));
        Client client =  Optional.ofNullable(clientRepository.findById(decodeData).get()).orElseThrow(() -> new RuntimeException("Unavailable"));

        String encryptData = Encrypt.encrypt(client.getId().toString());
        ClientDto clientDto = new ClientDto();
        clientDto.setId(encryptData);
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setTypeDocument(client.getTypeDocument());
        clientDto.setNumberDocument(client.getNumberDocument());
        clientDto.setStatus(client.getStatus());
       return clientDto;
    }
    @Override
    public List<Client> getAllClient(String status) {
        logger.debug("getAllClient ClientServiceImpl");
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream().filter(client -> client.getStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(String id, Client client) {
        logger.debug("updateClient ClientServiceImpl");
        UUID decodeData =  UUID.fromString(Encrypt.decrypt(id));
        Client clientExist = clientRepository.findById(decodeData).get();
        Optional.ofNullable(clientExist).orElseThrow(()->{
            logger.error("entity nullable");
            return new RuntimeException("entity nullable");
        });
        clientExist.setName(client.getName());
        clientExist.setLastName(client.getLastName());
        clientExist.setTypeDocument(client.getTypeDocument());
        clientExist.setNumberDocument(client.getNumberDocument());
        Client clientTemp = clientRepository.save(clientExist);
        String encryptData = Encrypt.encrypt(clientTemp.getId().toString());
        ClientDto clientDto = new ClientDto();
        clientDto.setId(encryptData);
        clientDto.setName(clientTemp.getName());
        clientDto.setLastName(clientTemp.getLastName());
        clientDto.setTypeDocument(clientTemp.getTypeDocument());
        clientDto.setNumberDocument(clientTemp.getNumberDocument());
        clientDto.setStatus(clientTemp.getStatus());
        return clientDto;

    }

    @Override
    public boolean deleteClient(String id)  {
        try {
            UUID decodeData =  UUID.fromString(Encrypt.decrypt(id));
            clientRepository.deleteById(decodeData);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
