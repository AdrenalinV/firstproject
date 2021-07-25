package ru.geekbrains.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.firstproject.model.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
