package com.CreativemindFactory.Storage_Unit.Repository;

import com.CreativemindFactory.Storage_Unit.Entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage,String> {
}
