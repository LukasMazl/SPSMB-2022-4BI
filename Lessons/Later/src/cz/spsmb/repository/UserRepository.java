package cz.spsmb.repository;

import cz.spsmb.model.UserEntity;

import java.util.List;

public interface UserRepository {

    void save(List<UserEntity> userEntity);

    List<UserEntity> getAll();
}
