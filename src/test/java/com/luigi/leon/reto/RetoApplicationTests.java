package com.luigi.leon.reto;

import com.luigi.leon.reto.model.Client;
import com.luigi.leon.reto.model.dto.ClientDto;
import com.luigi.leon.reto.repositories.IClientRepository;
import com.luigi.leon.reto.service.impl.ClientServiceImpl;
import com.luigi.leon.reto.service.util.Encrypt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class RetoApplicationTests {

	@Mock
	IClientRepository clientRepository;
	@InjectMocks
	ClientServiceImpl iClientService;
	@BeforeEach
	public void setUp() {
	}

	@Test
	public void CreateClientHappyCase(){
		UUID uuid = UUID.randomUUID();
		ClientDto respuestaEsperada = new ClientDto(Encrypt.encrypt(uuid.toString()),"fernando","li","dni","76662243","A");
		Client objetoSimulado = new Client(uuid,"fernando","li","dni","76662243","A");
		Client client = new Client(uuid,"fernando","li","dni","76662243","A");
		Mockito.when(clientRepository.save(client)).thenReturn(objetoSimulado);
		final ClientDto resp = iClientService.saveClient(client);
		Assertions.assertEquals(respuestaEsperada,resp);
	}

	@Test
	public void GetClientHappyCase() throws Exception {
		UUID uuid = UUID.randomUUID();
		String id = Encrypt.encrypt(uuid.toString());
		ClientDto respuestaEsperada = new ClientDto(id,"fernando","li","dni","76662243","A");

		Optional<Client> objetoSimulado = Optional.of(new Client(uuid, "fernando", "li", "dni", "76662243", "A"));
		Mockito.when(clientRepository.findById(uuid)).thenReturn(objetoSimulado);
		final ClientDto resp = iClientService.getClient(id);
		Assertions.assertEquals(respuestaEsperada,resp);
	}

	@Test
	public void GetClientErrorCase() {
		UUID uuid = UUID.randomUUID();
		String id = Encrypt.encrypt(uuid.toString());
		Mockito.when(clientRepository.findById(uuid)).thenReturn(null);
		Assertions.assertThrows(Exception.class,()->{iClientService.getClient(id);});
	}


}
