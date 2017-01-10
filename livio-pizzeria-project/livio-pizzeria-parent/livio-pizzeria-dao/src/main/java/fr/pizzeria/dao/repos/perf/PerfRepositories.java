package fr.pizzeria.dao.repos.perf;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;

public interface PerfRepositories extends JpaRepository<Performance, Integer> {

}
