package fr.pizzeria.dao.repos.perf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Performance;

@Repository
public class PerfReposDao {
	@Autowired
	PerfRepositories perfRepo;

	public void save(Performance perf) {
		perfRepo.save(perf);
	}
}
