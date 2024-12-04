package ma.ensa.services;

import jakarta.persistence.EntityNotFoundException;
import ma.ensa.beans.Departement;
import ma.ensa.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }
    public Departement getDepartementById(int id) {
        return departementRepository.getById(id);
    }
    public void deleteDepartement(int id) throws EntityNotFoundException {
        if(departementRepository.existsById(id)) {
            departementRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Departement with id : "+id+"not found");
        }

    }
    public Departement saveDepartement (Departement departement) {
        return departementRepository.save(departement);
    }
}
