package com.neu.autojavaappgenerator.Repository;

import com.neu.autojavaappgenerator.Models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


}
