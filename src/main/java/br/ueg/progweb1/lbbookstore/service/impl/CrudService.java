package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.service.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudService <
        MODEL extends GenericModel<PK>, PK,
        REPOSITORY extends JpaRepository<MODEL, PK>>
        implements GenericCrudService<PK, MODEL>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    REPOSITORY repository;

    public List<MODEL> getAll() {
        var modelList = repository.findAll();
        validateBusinessToGet(modelList);
        return modelList;
    }
    public MODEL getById(PK id) {
        return validateId(id);
    }

    public MODEL create(MODEL newModel) {
        validateMandatoryFields(newModel);
        validateBusinessLogicToCreate(newModel);
        prepareToCreate(newModel);
        return repository.save(newModel);
    }

    @Override
    public MODEL update(MODEL newModel, PK id) {
        validateMandatoryFields(newModel);
        validateBusinessLogicToUpdate(newModel);
        MODEL modelBD = validateId(id);
        prepareToUpdate(newModel, modelBD);

        return repository.save(newModel);
    }

    @Override
    public Boolean delete(PK id) {
        MODEL model = validateId(id);
        validateBusinessLogicToDelete(model);
        repository.deleteById(model.getId());
        return repository.findById(id).isEmpty();

    }
    private MODEL validateId(PK id) {

        Optional<MODEL> model = repository.findById(id);

        if(model.isEmpty())
            throw new BusinessException(ErrorValidation.INVALID_ID);
        return model.get();
    }

    //Validations
    protected abstract void validateBasicBusinessLogic(MODEL model);

    protected abstract void validateBusinessToGet(List<MODEL> modelList);

    protected abstract void validateMandatoryFields(MODEL model);

    protected abstract void prepareToCreate(MODEL newModel) ;

    protected abstract void validateBusinessLogicToCreate(MODEL newModel);

    protected abstract void prepareToUpdate(MODEL newModel, MODEL model);

    protected abstract void validateBusinessLogicToUpdate(MODEL model);

    protected abstract void validateBusinessLogicToDelete(MODEL model);



}
