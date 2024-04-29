package br.ueg.progweb1.lbbookstore.service;

import br.ueg.progweb1.lbbookstore.model.GenericModel;

import java.util.List;

public interface GenericCrudService<PK, MODEL> {
    MODEL create(MODEL newModel);

    MODEL update(MODEL book, PK id);

    MODEL delete(PK id);

    List<MODEL> getAll();

    MODEL getById(PK id);

    MODEL active(PK id);
}
