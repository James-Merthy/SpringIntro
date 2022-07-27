package be.digitalcity.demointrospring.controllers.service;

import java.util.List;

public interface IService<TENTITY, TDTO, TID> {
    List<TDTO> getAll();
    TDTO getById(TID id);
    boolean update(TID id, TENTITY entity);
    boolean delete(TID id);
    TDTO insert(TENTITY entity);
}