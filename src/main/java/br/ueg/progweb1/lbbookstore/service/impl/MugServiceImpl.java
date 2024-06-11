package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.enums.ProductType;
import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
import br.ueg.progweb1.lbbookstore.model.mug.Mug;
import br.ueg.progweb1.lbbookstore.repository.MugRepository;
import br.ueg.progweb1.lbbookstore.service.MugService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
public class MugServiceImpl extends CrudService<Mug, Long, MugRepository> implements MugService {

    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Override
    protected void validateBasicBusinessLogic(Mug mug) {
        if(mug.getPrice().intValue() <= 0)
            throw new BusinessException(ErrorValidation.INVALID_PRICE);
        if(mug.getQuantity() < 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY);
    }

    @Override
    protected void validateBusinessToList(List<Mug> mugs) {
        if(mugs.isEmpty())
            throw new ModelDataException(ErrorValidation.NOT_FOUND);
    }

    @Override
    protected void validateMandatoryFields(Mug mug) {
        LOG.info(String.valueOf(mug));
        if(Objects.isNull(mug.getName())
                || Objects.isNull(mug.getQuantity())
                || Objects.isNull(mug.getPrice()))
            throw new BusinessException(ErrorValidation.MANDATORY_FIELD_VIOLATION);
    }

    @Override
    protected void prepareToCreate(Mug newMug) {
        newMug.setId(0L);
        newMug.setLastUpdate(LocalDate.now());
        newMug.setType(ProductType.MUG);
        LOG.info(String.valueOf(newMug));
    }

    @Override
    protected void validateBusinessLogicToCreate(Mug newMug) {
        validateBasicBusinessLogic(newMug);
    }

    @Override
    protected void prepareToUpdate(Mug mug, Mug mugDB) {
        mug.setLastUpdate(LocalDate.now());
        mug.setId(mugDB.getId());
        mug.setActive(mugDB.getActive());
    }

    @Override
    protected void validateBusinessLogicToUpdate(Mug mug) {
        validateBasicBusinessLogic(mug);
    }

    @Override
    protected void validateBusinessLogicToDelete(Mug mug) {
        if(mug.getQuantity() > 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY_TO_DELETE);

    }

    @Override
    public Mug active(Long id) {
        Mug mug = validateId(id);
        mug.setActive(!(mug.getActive()));
        repository.save(mug);
        return mug;
    }
}
