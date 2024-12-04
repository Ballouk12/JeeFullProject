package ma.ensa.services;

import jakarta.persistence.EntityNotFoundException;
import ma.ensa.beans.Local;
import ma.ensa.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {
    @Autowired
    private LocalRepository localRepository;

    public Local saveLocation(Local local) {
        return localRepository.save(local);
    }

    public List<Local> getAllLocation() {
        return localRepository.findAll();
    }

    public void deleteLocation(int id) throws EntityNotFoundException {
        try {
            localRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Local with id " + id + " not found");
        }
    }

    public Local updateLocation(Local local) {
        Local upLocation = localRepository.findById(local.getId()).get();
        try {
            upLocation.setType(local.getType());
            upLocation.setSize(local.getSize());
            upLocation.setLibelle(local.getLibelle());
            return  localRepository.save(upLocation);
        } catch (NullPointerException e) {
            throw new EntityNotFoundException("Local with id " + local.getId() + " not found");
        }
    }
}
