package tech.buildrun.customerconnect.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.buildrun.customerconnect.entity.CustomerEntity;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Page<CustomerEntity> findByCpf(String cpf, Pageable pageable);

    Page<CustomerEntity> findByEmail(String email, Pageable pageable);

    Page<CustomerEntity> findByCpfAndEmail(String cpf, String email, Pageable pageable);

    Optional<CustomerEntity> findById(Long customerId);
}