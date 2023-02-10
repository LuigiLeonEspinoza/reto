package com.luigi.leon.reto.repositories;

import com.luigi.leon.reto.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface IClientRepository extends JpaRepository<Client, UUID> {



}
