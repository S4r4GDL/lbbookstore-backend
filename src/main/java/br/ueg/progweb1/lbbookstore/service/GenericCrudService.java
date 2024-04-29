package br.ueg.progweb1.lbbookstore.service;

import java.util.List;

public interface GenericCrudService<PK, MODEL> {
    MODEL create(MODEL newModel);

    MODEL update(MODEL book, PK id);

    MODEL delete(PK id);

    List<MODEL> getAll();

    MODEL getById(PK id);
}
