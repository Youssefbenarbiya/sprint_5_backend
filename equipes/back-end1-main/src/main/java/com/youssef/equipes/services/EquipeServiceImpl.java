package com.youssef.equipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Ligue;
import com.youssef.equipes.repo.EquipeRepository;
import com.youssef.equipes.repo.LigueRepository;

@Service
public class EquipeServiceImpl implements EquipeService{
	
	
	@Autowired
	EquipeRepository equipeRepository;
	
	
	@Autowired
	LigueRepository ligueRepository;
	
	@Override
	public Equipe saveEquipe(Equipe p) {
		// TODO Auto-generated method stub
		return equipeRepository.save(p);
	}

	@Override
	public Equipe updateEquipe(Equipe p) {
		// TODO Auto-generated method stub
		return equipeRepository.save(p);
	}

	@Override
	public void deleteEquipe(Equipe p) {
		// TODO Auto-generated method stub
		equipeRepository.delete(p);
	}

	@Override
	public void deleteEquipeById(Long id) {
		equipeRepository.deleteById(id);		
	}

	@Override
	public Equipe getEquipe(Long id) {
		// TODO Auto-generated method stub
		return equipeRepository.findById(id).get();
	}

	@Override
	public List<Equipe> getAllEquipes() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll();
	}
	@Override
	public Page<Equipe> getAllEquipesParPage(int page, int size) {
	return equipeRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Equipe> findByNomEquipe(String nom) {
		// TODO Auto-generated method stub
		return equipeRepository.findByNomEquipe(nom);
	}

	@Override
	public List<Equipe> findByNomEquipeContains(String nom) {
		// TODO Auto-generated method stub
		return equipeRepository.findByNomEquipeContains(nom);
	}

	@Override
	public List<Equipe> findByNomRank(String nom, int rank) {
		// TODO Auto-generated method stub
		return equipeRepository.findByNomRank(nom, rank);
	}

	@Override
	public List<Equipe> findByLigue(Ligue ligue) {
		// TODO Auto-generated method stub
		return equipeRepository.findByLigue(ligue);
	}

	@Override
	public List<Equipe> findByLigueId(Long id) {
	    // TODO Auto-generated method stub
	    return equipeRepository.findByLigueId(id);
	}


	@Override
	public List<Equipe> findByOrderByNomEquipeAsc() {
		// TODO Auto-generated method stub
		return equipeRepository.findByOrderByNomEquipeAsc();
	}

	@Override
	public List<Equipe> trierEquipesNomsRank() {
		// TODO Auto-generated method stub
		return equipeRepository.trierEquipesNomsRank();
	}

	@Override
	public List<Ligue> getAllLigues() {
		// TODO Auto-generated method stub
		return  ligueRepository.findAll();
	}
	
}
